package com.example.notificationmusic; // Khai báo tên package của ứng dụng

import android.Manifest; // Import lớp Manifest chứa các hằng số quyền hệ thống
import android.content.Intent; // Import Intent để khởi chạy Activity hoặc gửi broadcast
import android.content.pm.PackageManager; // Import PackageManager để kiểm tra quyền đã cấp hay chưa
import android.net.Uri; // Import Uri để xây dựng đường dẫn tới cài đặt ứng dụng
import android.os.Build; // Import Build để kiểm tra phiên bản Android đang chạy
import android.os.Bundle; // Import Bundle để nhận trạng thái đã lưu của Activity
import android.provider.Settings; // Import Settings để mở trang cài đặt ứng dụng
import android.widget.Button; // Import Button để tham chiếu nút bấm trên giao diện
import android.widget.Toast; // Import Toast để hiển thị thông báo ngắn

import androidx.activity.result.ActivityResultLauncher; // Import launcher để xử lý kết quả trả về từ Activity
import androidx.activity.result.contract.ActivityResultContracts; // Import hợp đồng yêu cầu quyền từ người dùng
import androidx.appcompat.app.AppCompatActivity; // Import lớp cơ sở cho Activity có hỗ trợ ActionBar
import androidx.core.app.NotificationManagerCompat; // Import để quản lý và kiểm tra quyền notification

public class MainActivity extends AppCompatActivity { // Khai báo lớp MainActivity kế thừa AppCompatActivity


    @Override // Ghi đè phương thức onCreate từ lớp cha
    protected void onCreate(Bundle savedInstanceState) { // Phương thức được gọi khi Activity được khởi tạo
        super.onCreate(savedInstanceState); // Gọi phương thức onCreate của lớp cha để khởi tạo đúng cách
        setContentView(R.layout.activity_main); // Thiết lập giao diện người dùng từ file layout activity_main.xml

        NotificationHelper.createChannel(this); // Tạo kênh thông báo (notification channel) cần thiết cho ứng dụng
        requestPermissionIfNeeded(); // Kiểm tra và yêu cầu quyền hiển thị notification nếu chưa được cấp

        Button btnShow = findViewById(R.id.btnShow); // Tìm và tham chiếu nút "Show" trên giao diện theo ID
        btnShow.setOnClickListener(v -> NotificationHelper.showCollapsed(this)); // Gán sự kiện click: hiển thị notification dạng thu gọn khi bấm nút

    }

    private void requestPermissionIfNeeded() { // Phương thức kiểm tra và yêu cầu quyền đăng thông báo nếu cần
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Kiểm tra nếu thiết bị chạy Android 13 (API 33) trở lên
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) // Kiểm tra xem quyền POST_NOTIFICATIONS đã được cấp chưa
                    != PackageManager.PERMISSION_GRANTED) { // Nếu quyền chưa được cấp thì thực hiện yêu cầu
                requestPermissions( // Hiển thị hộp thoại hệ thống để yêu cầu người dùng cấp quyền
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100); // Yêu cầu quyền POST_NOTIFICATIONS với mã yêu cầu là 100
            }
        }
    }

}
