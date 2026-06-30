package com.example.notificationmusic; // Khai báo tên package của ứng dụng

import android.content.BroadcastReceiver; // Lớp cơ sở để lắng nghe các broadcast Intent từ hệ thống hoặc app khác
import android.content.Context;           // Cần để tạo Toast và gọi các phương thức của NotificationHelper
import android.content.Intent;            // Chứa action string để xác định người dùng đã bấm nút nào
import android.widget.Toast;              // Hiển thị thông báo ngắn ở góc màn hình

import androidx.core.app.NotificationManagerCompat; // Dùng để cancel (xóa) notification khỏi thanh thông báo

// BroadcastReceiver nhận các broadcast được gửi từ PendingIntent trong notification
// Mỗi khi user bấm nút trên notification, hệ thống gửi broadcast → onReceive() được gọi
public class MusicNotificationReceiver extends BroadcastReceiver { // Khai báo lớp kế thừa BroadcastReceiver để xử lý sự kiện từ notification

    @Override // Ghi đè phương thức onReceive từ lớp cha BroadcastReceiver
    public void onReceive(Context context, Intent intent) { // Phương thức được gọi tự động khi nhận được broadcast từ notification
        String action = intent.getAction(); // Lấy chuỗi action từ Intent để xác định nút nào đã được bấm
        if (action == null) return; // Nếu action là null thì thoát khỏi phương thức để tránh lỗi NullPointerException

        switch (action) { // Dùng cấu trúc switch để xử lý từng loại hành động khác nhau
            case NotificationHelper.ACTION_PREV: // Trường hợp người dùng bấm nút Bài trước
                Toast.makeText(context, "Previous", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Previous" trên màn hình
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch

            case NotificationHelper.ACTION_PAUSE: // Trường hợp người dùng bấm nút Tạm dừng/Phát
                Toast.makeText(context, "Pause / Play", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Pause / Play" trên màn hình
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch

            case NotificationHelper.ACTION_NEXT: // Trường hợp người dùng bấm nút Bài tiếp theo
                Toast.makeText(context, "Next", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Next" trên màn hình
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch

            case NotificationHelper.ACTION_EXPAND: // Trường hợp người dùng bấm nút Mở rộng notification
                Toast.makeText(context, "Expanded", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Expanded" trên màn hình
                NotificationHelper.showExpanded(context); // Gọi phương thức cập nhật notification sang dạng mở rộng
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch

            case NotificationHelper.ACTION_COLLAPSE: // Trường hợp người dùng bấm nút Thu gọn notification
                Toast.makeText(context, "Collapsed", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Collapsed" trên màn hình
                NotificationHelper.showCollapsed(context); // Gọi phương thức cập nhật notification sang dạng thu gọn
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch

            case NotificationHelper.ACTION_CLOSE: // Trường hợp người dùng bấm nút Đóng notification
                Toast.makeText(context, "Closed", Toast.LENGTH_SHORT).show(); // Hiển thị thông báo ngắn "Closed" trên màn hình
                NotificationManagerCompat.from(context).cancel(NotificationHelper.NOTIF_ID); // Xoá notification khỏi thanh thông báo bằng ID đã định nghĩa
                break; // Kết thúc xử lý trường hợp này, thoát khỏi switch
        }
    }
}
