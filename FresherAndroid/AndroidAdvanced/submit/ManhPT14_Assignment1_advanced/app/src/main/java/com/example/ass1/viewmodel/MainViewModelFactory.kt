package com.example.ass1.viewmodel

/**
 * FILE: MainViewModelFactory.kt

 *
 * Mục đích: Factory để tạo MainViewModel với tham số (ContactRepository).
 * Cần thiết vì MainViewModel có constructor nhận tham số.
 *
 * Thuộc tầng: VIEWMODEL (trong MVVM)
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ass1.model.ContactRepository

class MainViewModelFactory(
    private val repository: ContactRepository  // Repository sẽ được truyền vào ViewModel
) : ViewModelProvider.Factory {
    /**
     * Hàm tạo ViewModel theo yêu cầu của Android.
     * Android sẽ tự gọi hàm này khi cần tạo ViewModel.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Kiểm tra xem class được yêu cầu có phải MainViewModel không
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")  // Bỏ qua cảnh báo ép kiểu (an toàn ở đây)
            return MainViewModel(repository) as T  // Tạo ViewModel với Repository
        }
        // Nếu class không hợp lệ → báo lỗi
        throw IllegalArgumentException("Không tìm thấy ViewModel: ${modelClass.name}")
    }
}