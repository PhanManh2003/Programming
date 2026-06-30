package com.example.inventorymanagement.data.db;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.RawQuery;

import androidx.sqlite.db.SupportSQLiteQuery;

import com.example.inventorymanagement.data.model.Transaction;

/**
 * DAO (Data Access Object): interface định nghĩa các thao tác với database.
 * Room tự sinh code implement tại compile time dựa trên các annotation.
 *
 * Dùng ở đây kết hợp với ContentProvider:
 *   - @Insert  : typed, Room tự build câu INSERT từ @Entity
 *   - @RawQuery: cho ContentProvider cần SQL động (WHERE tuỳ ý từ caller)
 */
@Dao
public interface TransactionDao {

    /**
     * @Insert: Room tự sinh câu INSERT INTO dựa trên các @ColumnInfo trong Transaction.
     * Trả về rowId của dòng vừa thêm.
     */
    @Insert
    long insert(Transaction transaction);

    /**
     * @RawQuery trả về Cursor: dùng cho ContentProvider.query()
     * vì ContentProvider bắt buộc phải trả về Cursor theo contract của Android.
     *
     * SupportSQLiteQuery cho phép truyền SQL động kèm bind args an toàn
     * (tránh SQL injection hơn nối string trực tiếp).
     */
    @RawQuery
    Cursor rawQuery(SupportSQLiteQuery query);

    /**
     * @RawQuery trả về int: dùng cho DELETE và UPDATE động trong ContentProvider.
     * Room trả về số dòng bị ảnh hưởng.
     */
    @RawQuery
    int rawExecute(SupportSQLiteQuery query);
}
