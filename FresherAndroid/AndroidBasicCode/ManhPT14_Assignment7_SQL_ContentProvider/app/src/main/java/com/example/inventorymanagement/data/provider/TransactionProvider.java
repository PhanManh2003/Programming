package com.example.inventorymanagement.data.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.example.inventorymanagement.data.db.AppDatabase;
import com.example.inventorymanagement.data.db.TransactionContract;
import com.example.inventorymanagement.data.db.TransactionDao;
import com.example.inventorymanagement.data.model.Transaction;

/**
 * ContentProvider vẫn giữ nguyên vai trò là cổng truy cập data.
 * Điểm thay đổi duy nhất: bên trong không còn dùng SQLiteOpenHelper (DatabaseHelper)
 * mà dùng Room DAO — Room giờ quản lý schema và database lifecycle.
 *
 * Luồng sau khi migrate:
 *   Repository → ContentResolver → ContentProvider → Room DAO → SQLite
 */
public class TransactionProvider extends ContentProvider {

    private static final int TRANSACTIONS   = 100;
    private static final int TRANSACTION_ID = 101;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(TransactionContract.AUTHORITY,
                TransactionContract.TransactionEntry.TABLE_NAME, TRANSACTIONS);
        uriMatcher.addURI(TransactionContract.AUTHORITY,
                TransactionContract.TransactionEntry.TABLE_NAME + "/#", TRANSACTION_ID);
    }

    // Dùng Room DAO thay vì DatabaseHelper
    private TransactionDao dao;

    @Override
    public boolean onCreate() {
        // Lấy DAO từ AppDatabase (singleton) — Room tự tạo bảng nếu chưa có
        dao = AppDatabase.getInstance(getContext()).transactionDao();
        return true;
    }

    /**
     * Query dữ liệu.
     * Vì ContentProvider nhận WHERE clause động từ bên ngoài (caller tự truyền),
     * không thể dùng @Query cố định trong DAO — phải dùng @RawQuery với SimpleSQLiteQuery.
     */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection, @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        // Xây dựng câu SELECT động
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append(projection != null ? TextUtils.join(", ", projection) : "*");
        sql.append(" FROM ").append(TransactionContract.TransactionEntry.TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case TRANSACTIONS:
                if (selection != null) sql.append(" WHERE ").append(selection);
                break;
            case TRANSACTION_ID:
                // Truy vấn một dòng theo ID lấy từ cuối URI
                sql.append(" WHERE ").append(TransactionContract.TransactionEntry._ID)
                        .append(" = ").append(ContentUris.parseId(uri));
                selectionArgs = null; // ID đã nhúng thẳng vào SQL, không dùng bind args
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        if (sortOrder != null) sql.append(" ORDER BY ").append(sortOrder);

        // SimpleSQLiteQuery bọc SQL + args, Room truyền vào @RawQuery an toàn
        Cursor cursor = dao.rawQuery(new SimpleSQLiteQuery(sql.toString(), selectionArgs));
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    /**
     * Insert dòng mới.
     * Đây là nơi Room ORM phát huy: @Insert nhận Transaction object,
     * Room tự build câu INSERT dựa trên @Entity — không cần viết SQL thủ công.
     */
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if (uriMatcher.match(uri) != TRANSACTIONS) {
            throw new IllegalArgumentException("Insertion not supported for URI: " + uri);
        }

        // Chuyển ContentValues → Transaction entity để Room có thể insert
        long id = dao.insert(contentValuesToTransaction(values));

        if (id == -1) throw new RuntimeException("Failed to insert row for " + uri);
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    /**
     * Update dòng — dùng @RawQuery vì WHERE clause là động.
     */
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values,
                      @Nullable String selection, @Nullable String[] selectionArgs) {
        if (values == null || values.isEmpty()) return 0;

        // Xây dựng SET clause từ ContentValues
        StringBuilder setClauses = new StringBuilder();
        Object[] setArgs = new Object[values.size()];
        int i = 0;
        for (String key : values.keySet()) {
            if (setClauses.length() > 0) setClauses.append(", ");
            setClauses.append(key).append(" = ?");
            setArgs[i++] = values.get(key);
        }

        // Ghép SET args + WHERE args thành một mảng cho SimpleSQLiteQuery
        Object[] allArgs;
        if (selectionArgs != null) {
            allArgs = new Object[setArgs.length + selectionArgs.length];
            System.arraycopy(setArgs, 0, allArgs, 0, setArgs.length);
            System.arraycopy(selectionArgs, 0, allArgs, setArgs.length, selectionArgs.length);
        } else {
            allArgs = setArgs;
        }

        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(TransactionContract.TransactionEntry.TABLE_NAME)
                .append(" SET ").append(setClauses);

        switch (uriMatcher.match(uri)) {
            case TRANSACTIONS:
                if (selection != null) sql.append(" WHERE ").append(selection);
                break;
            case TRANSACTION_ID:
                sql.append(" WHERE ").append(TransactionContract.TransactionEntry._ID)
                        .append(" = ").append(ContentUris.parseId(uri));
                break;
            default:
                throw new IllegalArgumentException("Update not supported for URI: " + uri);
        }

        int rows = dao.rawExecute(new SimpleSQLiteQuery(sql.toString(), allArgs));
        if (rows != 0) getContext().getContentResolver().notifyChange(uri, null);
        return rows;
    }

    /**
     * Delete dòng — dùng @RawQuery để hỗ trợ cả xóa toàn bộ (Clear Batch)
     * lẫn xóa theo điều kiện.
     */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection,
                      @Nullable String[] selectionArgs) {

        StringBuilder sql = new StringBuilder("DELETE FROM ")
                .append(TransactionContract.TransactionEntry.TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case TRANSACTIONS:
                // selection = null → xóa tất cả (Clear Batch)
                if (selection != null) sql.append(" WHERE ").append(selection);
                break;
            case TRANSACTION_ID:
                sql.append(" WHERE ").append(TransactionContract.TransactionEntry._ID)
                        .append(" = ").append(ContentUris.parseId(uri));
                selectionArgs = null;
                break;
            default:
                throw new IllegalArgumentException("Deletion not supported for URI: " + uri);
        }

        int rows = dao.rawExecute(new SimpleSQLiteQuery(sql.toString(), selectionArgs));
        if (rows != 0) getContext().getContentResolver().notifyChange(uri, null);
        return rows;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TRANSACTIONS:
                return "vnd.android.cursor.dir/vnd." + TransactionContract.AUTHORITY + "."
                        + TransactionContract.TransactionEntry.TABLE_NAME;
            case TRANSACTION_ID:
                return "vnd.android.cursor.item/vnd." + TransactionContract.AUTHORITY + "."
                        + TransactionContract.TransactionEntry.TABLE_NAME;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    /** Chuyển ContentValues (dạng Map) sang Transaction entity để Room insert */
    private Transaction contentValuesToTransaction(ContentValues v) {
        Transaction t = new Transaction();
        t.setInvoiceNumber(v.getAsInteger(TransactionContract.TransactionEntry.COLUMN_INVOICE_NUMBER));
        t.setType(v.getAsString(TransactionContract.TransactionEntry.COLUMN_TYPE));
        t.setAmount(v.getAsDouble(TransactionContract.TransactionEntry.COLUMN_AMOUNT));
        t.setCurrency(v.getAsString(TransactionContract.TransactionEntry.COLUMN_CURRENCY));
        t.setHolderName(v.getAsString(TransactionContract.TransactionEntry.COLUMN_HOLDER_NAME));
        t.setDateTime(v.getAsString(TransactionContract.TransactionEntry.COLUMN_DATE_TIME));
        return t;
    }
}
