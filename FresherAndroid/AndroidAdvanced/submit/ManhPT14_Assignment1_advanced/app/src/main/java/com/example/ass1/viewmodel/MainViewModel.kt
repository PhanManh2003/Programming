package com.example.ass1.viewmodel
/**
 * FILE: MainViewModel.kt

 *
 * Mục đích: Xử lý logic nghiệp vụ và cung cấp dữ liệu cho View (MainActivity).
 * ViewModel là cầu nối giữa Model (Repository) và View (Activity/Fragment).
 *
 * Thuộc tầng: VIEWMODEL (trong MVVM)
 */

import androidx.lifecycle.MutableLiveData  // LiveData có thể thay đổi giá trị
import androidx.lifecycle.ViewModel        // Lớp cha của ViewModel
import androidx.lifecycle.viewModelScope   // CoroutineScope gắn với vòng đời ViewModel
import com.example.ass1.model.Contact
import com.example.ass1.model.ContactRepository
import kotlinx.coroutines.Dispatchers      // Dispatchers.IO: thread cho database
import kotlinx.coroutines.launch           // Khởi chạy Coroutine
import kotlinx.coroutines.withContext      // Chuyển đổi thread trong Coroutine
class MainViewModel(
    private val repository: ContactRepository  // Nhận Repository qua Factory
) : ViewModel() {
    // LiveData chứa danh sách contacts hiển thị trên RecyclerView
    val contacts = MutableLiveData<List<Contact>>()
    // LiveData chứa % tiến trình tải (0 → 100)
    val downloadProgress = MutableLiveData(0)
    // LiveData trạng thái đang tải hay không
    // true = đang tải → hiện ProgressBar, disable nút Download
    val isLoading = MutableLiveData(false)
    /**
     * Hàm bắt đầu tải danh sách contact từ database.
     * Được gọi khi người dùng nhấn nút "Download".
     *
     * viewModelScope.launch: Coroutine tự huỷ khi ViewModel bị destroy
     */
    fun downloadContacts() {
        viewModelScope.launch {
            isLoading.value = true    // Bật trạng thái đang tải
            downloadProgress.value = 0 // Reset về 0%
            // Chạy việc tải dữ liệu trên IO thread (không block UI)
            val result = withContext(Dispatchers.IO) {
                repository.loadContacts { progress ->
                    // Callback này được gọi mỗi khi 1 batch hoàn thành
                    // postValue: dùng khi đang ở background thread (IO Dispatcher)
                    downloadProgress.postValue(progress)
                }
            }
            // Sau khi tải xong → cập nhật danh sách lên UI thread
            contacts.value = result
            isLoading.value = false   // Tắt trạng thái đang tải
        }
    }
}