package com.example.ass1.model
/**
 * FILE: ContactDao.kt

 *
 * Mục đích: Định nghĩa các thao tác truy vấn (CRUD) với bảng "contacts" trong Room.
 * DAO = Data Access Object — là giao diện giữa code Kotlin và SQLite.
 * Room sẽ tự động tạo code implement cho interface này ở compile time.
 *
 * Thuộc tầng: MODEL (trong MVVM)
 */
import androidx.room.*


// @Dao: báo cho Room biết interface này chứa các câu lệnh SQL
@Dao
interface ContactDao {
    // Lấy toàn bộ danh sách contact từ bảng "contacts"
    // suspend fun: chạy bất đồng bộ (Coroutine), không block UI thread
    @Query("SELECT * FROM contacts")
    suspend fun getAllContacts(): List<Contact>
    // Chèn danh sách contact vào database
    // onConflict = REPLACE: nếu trùng ID thì thay thế bản ghi cũ
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contacts: List<Contact>)
    // Đếm số lượng contact hiện có trong database
    // Dùng để kiểm tra DB có dữ liệu chưa (tránh seed data trùng lặp)
    @Query("SELECT COUNT(*) FROM contacts")
    suspend fun getCount(): Int
}