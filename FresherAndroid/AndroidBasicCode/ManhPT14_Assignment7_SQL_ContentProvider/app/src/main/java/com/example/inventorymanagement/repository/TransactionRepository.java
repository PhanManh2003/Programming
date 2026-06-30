package com.example.inventorymanagement.repository;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;

import com.example.inventorymanagement.data.db.TransactionContract;
import com.example.inventorymanagement.data.model.RevenueStats;
import com.example.inventorymanagement.data.model.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Repository là tầng trung gian giữa ViewModel và nguồn dữ liệu.
 * ViewModel không cần biết data đến từ SQLite, network hay cache —
 * chỉ cần gọi Repository là xong.
 */
public class TransactionRepository {

    private static final String PREFS_NAME        = "inventory_prefs";
    private static final String KEY_INVOICE_COUNTER = "invoice_counter";

    private final ContentResolver contentResolver;
    private final SharedPreferences prefs;

    public TransactionRepository(Context context) {
        // ContentResolver là cầu nối để gọi các phương thức của ContentProvider
        this.contentResolver = context.getContentResolver();
        // SharedPreferences lưu bộ đếm invoice — reset về 0 khi Clear Batch
        this.prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /** Thêm giao dịch mới vào database thông qua ContentProvider */
    public long addTransaction(String type, double amount, String currency, String holderName) {
        // Tăng invoice counter lên 1 trước khi insert
        int invoiceNumber = prefs.getInt(KEY_INVOICE_COUNTER, 0) + 1;
        prefs.edit().putInt(KEY_INVOICE_COUNTER, invoiceNumber).apply();

        // Lấy thời gian hiện tại làm DateTime của giao dịch
        String dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                .format(new Date());

        // ContentValues giống như một Map<String, Object> chứa dữ liệu cần insert
        ContentValues values = new ContentValues();
        values.put(TransactionContract.TransactionEntry.COLUMN_INVOICE_NUMBER, invoiceNumber);
        values.put(TransactionContract.TransactionEntry.COLUMN_TYPE,           type);
        values.put(TransactionContract.TransactionEntry.COLUMN_AMOUNT,         amount);
        values.put(TransactionContract.TransactionEntry.COLUMN_CURRENCY,       currency);
        values.put(TransactionContract.TransactionEntry.COLUMN_HOLDER_NAME,    holderName);
        values.put(TransactionContract.TransactionEntry.COLUMN_DATE_TIME,      dateTime);

        Uri inserted = contentResolver.insert(
                TransactionContract.TransactionEntry.CONTENT_URI, values);
        // Lấy ID của dòng vừa tạo từ URI trả về (phần cuối URI là ID)
        return inserted != null ? Long.parseLong(inserted.getLastPathSegment()) : -1;
    }

    /**
     * Lấy danh sách giao dịch, hỗ trợ lọc qua selection/selectionArgs
     * (giống mệnh đề WHERE trong SQL).
     */
    public List<Transaction> getTransactions(String selection, String[] selectionArgs) {
        List<Transaction> list = new ArrayList<>();
        Cursor cursor = contentResolver.query(
                TransactionContract.TransactionEntry.CONTENT_URI,
                null,                  // null = lấy tất cả các cột
                selection,
                selectionArgs,
                TransactionContract.TransactionEntry._ID + " DESC"); // Mới nhất lên đầu

        if (cursor != null) {
            while (cursor.moveToNext()) {
                list.add(fromCursor(cursor));
            }
            cursor.close(); // Luôn đóng Cursor sau khi dùng xong để tránh memory leak
        }
        return list;
    }

    /** Tính tổng doanh thu theo từng loại (SALE/REFUND) và từng tiền tệ (VND/USD) */
    public RevenueStats getRevenueStats(String selection, String[] selectionArgs) {
        RevenueStats stats = new RevenueStats();

        // Chỉ query 3 cột cần thiết để tính toán, không lấy dư cột
        String[] projection = {
                TransactionContract.TransactionEntry.COLUMN_AMOUNT,
                TransactionContract.TransactionEntry.COLUMN_TYPE,
                TransactionContract.TransactionEntry.COLUMN_CURRENCY
        };

        Cursor cursor = contentResolver.query(
                TransactionContract.TransactionEntry.CONTENT_URI,
                projection, selection, selectionArgs, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                double amount   = cursor.getDouble(0);
                String type     = cursor.getString(1);
                String currency = cursor.getString(2);

                boolean isSale = TransactionContract.TransactionEntry.TYPE_SALE.equals(type);
                boolean isVND  = TransactionContract.TransactionEntry.CURRENCY_VND.equals(currency);

                // Phân loại và cộng dồn vào đúng bucket
                if (isSale) {
                    if (isVND) stats.totalSaleVND += amount;
                    else       stats.totalSaleUSD += amount;
                } else {
                    if (isVND) stats.totalRefundVND += amount;
                    else       stats.totalRefundUSD += amount;
                }
            }
            cursor.close();
        }
        return stats;
    }

    /** Xóa toàn bộ giao dịch và reset bộ đếm invoice về 0 */
    public void clearBatch() {
        // selection = null → xóa tất cả dòng trong bảng
        contentResolver.delete(TransactionContract.TransactionEntry.CONTENT_URI, null, null);
        prefs.edit().putInt(KEY_INVOICE_COUNTER, 0).apply();
    }

    /** Chuyển đổi một hàng trong Cursor thành đối tượng Transaction */
    private Transaction fromCursor(Cursor cursor) {
        Transaction t = new Transaction();
        t.setId(cursor.getLong(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry._ID)));
        t.setInvoiceNumber(cursor.getInt(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_INVOICE_NUMBER)));
        t.setType(cursor.getString(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_TYPE)));
        t.setAmount(cursor.getDouble(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_AMOUNT)));
        t.setCurrency(cursor.getString(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_CURRENCY)));
        t.setHolderName(cursor.getString(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_HOLDER_NAME)));
        t.setDateTime(cursor.getString(cursor.getColumnIndexOrThrow(TransactionContract.TransactionEntry.COLUMN_DATE_TIME)));
        return t;
    }
}
