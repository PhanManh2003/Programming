package com.example.inventorymanagement.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.inventorymanagement.data.model.Transaction;

/**
 * @Database: khai báo Room database, liệt kê các @Entity (bảng) và version schema.
 *
 * Room thay thế hoàn toàn SQLiteOpenHelper:
 *   - Tự tạo bảng dựa trên @Entity
 *   - Tự xử lý migration khi version tăng
 *   - Kiểm tra SQL tại compile time (không bị crash runtime vì typo)
 *
 * exportSchema = false: không xuất file JSON schema (dùng trong CI/migration test).
 */
@Database(entities = {Transaction.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;

    /** Room tự sinh implementation của interface DAO tại compile time */
    public abstract TransactionDao transactionDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "inventory.db")   // Tên file database giữ nguyên
                    // Cho phép query trên main thread — chấp nhận được vì
                    // ContentProvider đã chạy trên Binder thread pool,
                    // và app này là demo không yêu cầu async.
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
