package com.example.ass1.model

/**
 * FILE: ContactDatabase.kt

 *
 * Mục đích: Tạo và quản lý Room Database (SQLite).
 * Đây là điểm truy cập duy nhất vào database trong toàn bộ app.
 * Sử dụng Singleton Pattern để đảm bảo chỉ có 1 instance database tồn tại.
 * Khi database được tạo lần đầu (onCreate), tự động chèn 50 contact mẫu.
 *
 * Thuộc tầng: MODEL (trong MVVM)
 */
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// @Database: khai báo đây là Room Database
// entities: danh sách các bảng (Entity) trong database
// version: phiên bản schema, tăng khi thay đổi cấu trúc bảng
// exportSchema = false: không xuất file schema (dùng trong production thì nên để true)
@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    // Hàm trừu tượng — Room sẽ tự sinh code implement
    // Trả về DAO để thực hiện các câu truy vấn
    abstract fun contactDao(): ContactDao
    companion object {
        // @Volatile: đảm bảo INSTANCE luôn được đọc từ bộ nhớ chính
        // (tránh lỗi trên môi trường đa luồng)
        @Volatile
        private var INSTANCE: ContactDatabase? = null
        /**
         * Hàm lấy instance của database (Singleton Pattern).
         * Nếu database chưa tồn tại → tạo mới.
         * Nếu đã tồn tại → trả về instance cũ.
         */
        fun getDatabase(context: Context): ContactDatabase {
            // Nếu INSTANCE chưa có thì mới tạo (double-check locking)
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,   // dùng applicationContext để tránh memory leak
                    ContactDatabase::class.java,  // class của database
                    "contact_database"            // tên file .db trên thiết bị
                )
                    .addCallback(object : Callback() {
                        // onCreate: được gọi 1 lần duy nhất khi database vừa được tạo
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Chạy trên IO thread để không block UI
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    seedData(database.contactDao()) // Chèn dữ liệu mẫu
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance // Lưu lại instance vừa tạo
                instance
            }
        }
        /**
         * Hàm chèn 50 contact mẫu vào database.
         * Chỉ chạy 1 lần khi database được tạo lần đầu.
         */
        private suspend fun seedData(dao: ContactDao) {
            val firstNames = listOf("Nguyen", "Tran", "Le", "Pham", "Hoang",
                "Vu", "Dang", "Bui", "Do", "Ho")
            val lastNames  = listOf("An", "Binh", "Cuong", "Dung", "Giang",
                "Hoa", "Khoa", "Lan", "Minh", "Nam")
            // Tạo danh sách 50 contact với tên, phone, email ngẫu nhiên
            val contacts = (1..50).map { i ->
                val first = firstNames[i % firstNames.size]  // Lấy họ theo vòng
                val last  = lastNames[i % lastNames.size]    // Lấy tên theo vòng
                Contact(
                    name  = "$first $last $i",                          // VD: "Nguyen An 1"
                    phone = "09${i.toString().padStart(8, '0')}",       // VD: "0900000001"
                    email = "${first.lowercase()}${i}@gmail.com"        // VD: "nguyen1@gmail.com"
                )
            }
            dao.insertAll(contacts) // Chèn toàn bộ 50 contact vào DB một lần
        }
    }
}