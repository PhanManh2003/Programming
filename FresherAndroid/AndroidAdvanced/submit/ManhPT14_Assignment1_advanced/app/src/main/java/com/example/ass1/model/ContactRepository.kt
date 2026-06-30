package com.example.ass1.model

/**
 * FILE: ContactRepository.kt

 *
 * Mục đích: Tầng trung gian giữa ViewModel và DAO.
 * Repository chịu trách nhiệm xử lý logic lấy dữ liệu từ database,
 * đồng thời chia nhỏ việc tải thành từng batch để có thể báo cáo
 * tiến trình (progress %) về cho ViewModel.
 *
 * Lợi ích của Repository Pattern:
 * - ViewModel không cần biết dữ liệu đến từ đâu (DB, API, cache...)
 * - Dễ thay đổi nguồn dữ liệu mà không ảnh hưởng ViewModel
 *
 * Thuộc tầng: MODEL (trong MVVM)
 */


import kotlinx.coroutines.delay // Tạm dừng trong Coroutine (giả lập delay I/O)

class ContactRepository(
    private val dao: ContactDao  // Nhận DAO từ bên ngoài (Dependency Injection thủ công)
) {
    /**
     * Hàm tải toàn bộ contacts từ database, đồng thời báo cáo tiến trình.
     *
     * @param onProgress: callback nhận giá trị progress từ 0 đến 100
     * @return danh sách toàn bộ Contact đã tải
     *
     * suspend fun: phải gọi từ Coroutine (ViewModel dùng viewModelScope)
     */
    suspend fun loadContacts(onProgress: (Int) -> Unit): List<Contact> {
        // Bước 1: Lấy toàn bộ contact từ database (chạy trên IO thread)
        val allContacts = dao.getAllContacts()
        val total = allContacts.size  // Tổng số contact
        // Nếu database rỗng → báo 100% và trả về list trống
        if (total == 0) {
            onProgress(100)
            return emptyList()
        }
        // Bước 2: Chia danh sách thành ~10 batch để simulate progress
        // Ví dụ: 50 contact → batchSize = 5, mỗi batch là 5 contact
        val batchSize = maxOf(1, total / 10)
        val result = mutableListOf<Contact>()   // Danh sách kết quả tích lũy
        val batches = allContacts.chunked(batchSize) // Cắt list thành các phần nhỏ
        // Bước 3: Xử lý từng batch
        batches.forEachIndexed { index, batch ->
            delay(400)           // Giả lập độ trễ đọc từ disk/network (0.4 giây/batch)
            result.addAll(batch) // Gom batch vào kết quả cuối
            // Tính % đã hoàn thành: (số batch đã xong / tổng batch) * 100
            val progress = ((index + 1) * 100 / batches.size).coerceAtMost(100)
            // Gọi callback để báo progress về ViewModel
            onProgress(progress)
        }
        onProgress(100) // Đảm bảo kết thúc luôn = 100%
        return result
    }
}