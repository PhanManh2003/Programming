package com.example.ass1.view

/**
 * FILE: MainActivity.kt

 *
 * Mục đích: Màn hình chính của ứng dụng — đây là tầng VIEW trong MVVM.
 * Activity chịu trách nhiệm:
 *   1. Hiển thị UI (RecyclerView, ProgressBar, Button)
 *   2. Lắng nghe (observe) dữ liệu từ ViewModel qua LiveData
 *   3. Gửi sự kiện người dùng (nhấn nút) lên ViewModel
 *
 * Nguyên tắc: Activity KHÔNG chứa logic nghiệp vụ — chỉ hiển thị và lắng nghe.
 *
 * Thuộc tầng: VIEW (trong MVVM)
 */
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels           // Delegate để tạo ViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil   // Tiện ích setup Data Binding
import com.example.ass1.R
import com.example.ass1.databinding.ActivityMainBinding  // Class tự sinh từ XML
import com.example.ass1.model.ContactDatabase
import com.example.ass1.model.ContactRepository
import com.example.ass1.viewmodel.MainViewModel
import com.example.ass1.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    // Binding: thay thế findViewById, truy cập view trực tiếp qua tên ID
    private lateinit var binding: ActivityMainBinding

    // Adapter cho RecyclerView
    private lateinit var adapter: ContactAdapter

    // Khởi tạo ViewModel qua Factory (truyền ContactRepository vào)
    // by viewModels: delegate của Android KTX, tự quản lý vòng đời ViewModel
    private val viewModel: MainViewModel by viewModels {
        val dao = ContactDatabase.getDatabase(this).contactDao() // Lấy DAO từ DB
        val repository = ContactRepository(dao)                         // Tạo Repository
        MainViewModelFactory(repository)                                // Tạo Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup Data Binding: gắn layout với Activity
        // Từ đây trở đi dùng "binding.tenView" thay vì findViewById
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // lifecycleOwner: cho phép LiveData trong XML tự cập nhật
        binding.lifecycleOwner = this
        setupRecyclerView()      // Thiết lập RecyclerView
        observeViewModel()       // Đăng ký lắng nghe LiveData từ ViewModel
        setupClickListeners()    // Gắn sự kiện cho các nút
    }

    /** Thiết lập RecyclerView với Adapter */
    private fun setupRecyclerView() {
        adapter = ContactAdapter()              // Tạo adapter
        binding.recyclerView.adapter = adapter  // Gán adapter cho RecyclerView
    }

    /** Lắng nghe các LiveData từ ViewModel và cập nhật UI tương ứng */
    private fun observeViewModel() {
        // Observe danh sách contacts → cập nhật RecyclerView khi có dữ liệu mới
        viewModel.contacts.observe(this) { list ->
            adapter.submitList(list) // DiffUtil tự tính toán và animate thay đổi
        }
        // Observe tiến trình tải → cập nhật ProgressBar và text "%"
        viewModel.downloadProgress.observe(this) { progress ->
            binding.progressBar.progress = progress         // Cập nhật thanh progress
            binding.tvProgress.text = "$progress%"          // Hiển thị con số phần trăm
        }
        // Observe trạng thái loading → ẩn/hiện khu vực progress
        viewModel.isLoading.observe(this) { loading ->
            // Nếu đang tải: hiện progressContainer, nếu xong: ẩn đi
            binding.progressContainer.visibility = if (loading) View.VISIBLE else View.GONE
            // Disable nút Download khi đang tải, enable lại khi xong
            binding.btnDownload.isEnabled = !loading
        }
    }

    /** Gắn sự kiện click cho các nút */
    private fun setupClickListeners() {
        // Khi nhấn nút Download → gọi ViewModel xử lý
        // Activity không tự xử lý logic — chỉ uỷ thác cho ViewModel
        binding.btnDownload.setOnClickListener {
            viewModel.downloadContacts()
        }
    }
}
