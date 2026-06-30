package com.example.notificationmusic; // Khai báo tên package của ứng dụng

import android.Manifest; // Import lớp Manifest chứa các hằng số quyền hệ thống
import android.annotation.SuppressLint; // Import annotation để tắt cảnh báo Lint không cần thiết
import android.app.Notification; // Import lớp Notification để tạo đối tượng thông báo
import android.app.NotificationChannel; // Lớp đại diện cho kênh thông báo (bắt buộc từ Android 8.0+)
import android.app.NotificationManager;  // Dịch vụ hệ thống để quản lý notification
import android.app.PendingIntent;        // Intent "trì hoãn" - được thực thi khi user tương tác với notification
import android.content.Context;          // Đối tượng chứa thông tin môi trường app
import android.content.Intent;           // Dùng để gửi yêu cầu tới BroadcastReceiver
import android.content.pm.PackageManager; // Import PackageManager để kiểm tra quyền đã cấp hay chưa
import android.os.Build; // Import Build để kiểm tra phiên bản Android đang chạy
import android.widget.RemoteViews;       // View đặc biệt dùng để render layout tuỳ chỉnh trong notification

import androidx.core.app.ActivityCompat; // Import để kiểm tra quyền runtime
import androidx.core.app.NotificationCompat;       // Builder tạo notification tương thích nhiều phiên bản API
import androidx.core.app.NotificationManagerCompat; // Wrapper tương thích để post/cancel notification

public class NotificationHelper { // Khai báo lớp tiện ích xử lý toàn bộ logic liên quan đến notification

    public static final String CHANNEL_ID = "music_channel"; // Hằng số ID kênh thông báo dùng để tạo và tham chiếu kênh
    public static final int NOTIF_ID = 1; // Hằng số ID của notification, dùng để cập nhật hoặc huỷ notification

    public static final String ACTION_PREV = "ACTION_PREV"; // Hằng số chuỗi hành động: bấm nút Bài trước
    public static final String ACTION_PAUSE = "ACTION_PAUSE"; // Hằng số chuỗi hành động: bấm nút Tạm dừng/Phát
    public static final String ACTION_NEXT = "ACTION_NEXT"; // Hằng số chuỗi hành động: bấm nút Bài tiếp theo
    public static final String ACTION_EXPAND = "ACTION_EXPAND"; // Hằng số chuỗi hành động: bấm nút Mở rộng notification
    public static final String ACTION_COLLAPSE = "ACTION_COLLAPSE"; // Hằng số chuỗi hành động: bấm nút Thu gọn notification
    public static final String ACTION_CLOSE = "ACTION_CLOSE"; // Hằng số chuỗi hành động: bấm nút Đóng notification

    public static void createChannel(Context context) { // Phương thức tạo kênh thông báo (bắt buộc từ Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // Kiểm tra nếu thiết bị chạy Android 8.0 (API 26) trở lên
            NotificationChannel channel = new NotificationChannel( // Tạo đối tượng kênh thông báo mới
                    CHANNEL_ID, // ID kênh dùng để nhận diện kênh trong hệ thống
                    "Music Player", // Tên hiển thị của kênh trong phần cài đặt hệ thống
                    NotificationManager.IMPORTANCE_LOW // Mức độ quan trọng thấp: không phát âm thanh, không rung
            );
            channel.setDescription("Music playback controls"); // Đặt mô tả cho kênh, hiển thị trong cài đặt ứng dụng
            NotificationManager manager = // Khai báo biến quản lý notification
                    context.getSystemService(NotificationManager.class); // Lấy dịch vụ NotificationManager từ hệ thống
            manager.createNotificationChannel(channel); // Đăng ký kênh thông báo với hệ thống Android
        }
    }

    private static PendingIntent makePI(Context context, String action) { // Phương thức tạo PendingIntent tương ứng với từng nút bấm
        Intent intent = new Intent(action); // Tạo Intent với action string tương ứng với nút bấm
        intent.setPackage(context.getPackageName()); // Giới hạn Intent chỉ gửi tới package của ứng dụng này để tăng bảo mật
        return PendingIntent.getBroadcast( // Tạo và trả về PendingIntent dạng broadcast
                context, // Context của ứng dụng
                action.hashCode(), // Mã yêu cầu duy nhất được tạo từ hash của chuỗi action
                intent, // Intent sẽ được gửi đi khi người dùng bấm nút trên notification
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE // Cờ: cập nhật nếu đã tồn tại và không thể thay đổi sau khi tạo
        );
    }

    public static void showCollapsed(Context context) { // Phương thức hiển thị notification dạng thu gọn
        RemoteViews view = new RemoteViews( // Tạo đối tượng RemoteViews để render layout tuỳ chỉnh bên trong notification
                context.getPackageName(), R.layout.notification_collapsed); // Sử dụng layout notification_collapsed.xml làm giao diện

        view.setOnClickPendingIntent(R.id.btn_prev, // Gán PendingIntent cho nút Bài trước trong layout
                makePI(context, ACTION_PREV)); // Tạo PendingIntent xử lý hành động quay về bài trước
        view.setOnClickPendingIntent(R.id.btn_play_pause, // Gán PendingIntent cho nút Phát/Tạm dừng trong layout
                makePI(context, ACTION_PAUSE)); // Tạo PendingIntent xử lý hành động phát hoặc tạm dừng nhạc
        view.setOnClickPendingIntent(R.id.btn_next, // Gán PendingIntent cho nút Bài tiếp theo trong layout
                makePI(context, ACTION_NEXT)); // Tạo PendingIntent xử lý hành động chuyển sang bài tiếp theo
        view.setOnClickPendingIntent(R.id.btn_expand, // Gán PendingIntent cho nút Mở rộng trong layout
                makePI(context, ACTION_EXPAND)); // Tạo PendingIntent xử lý hành động mở rộng notification
        view.setOnClickPendingIntent(R.id.btn_close, // Gán PendingIntent cho nút Đóng trong layout
                makePI(context, ACTION_CLOSE)); // Tạo PendingIntent xử lý hành động đóng notification

        // showCollapsed() - đổi setCustomContentView thành setCustomBigContentView
        Notification notif = new NotificationCompat.Builder(context, CHANNEL_ID) // Tạo builder để xây dựng đối tượng Notification
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Đặt icon nhỏ hiển thị trên thanh trạng thái hệ thống
                .setCustomContentView(view) // Đặt layout tuỳ chỉnh cho notification khi ở trạng thái thu gọn
                .setCustomBigContentView(view) // Đặt layout tuỳ chỉnh cho notification khi ở trạng thái mở rộng
                // XÓA .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setPriority(NotificationCompat.PRIORITY_LOW) // Đặt độ ưu tiên thấp: không làm gián đoạn người dùng
                .setOngoing(true) // Đặt notification là đang diễn ra, người dùng không thể vuốt để xoá
                .build(); // Hoàn thiện quá trình xây dựng và tạo đối tượng Notification

        //  cần check permission trước khi gọi notify().
        if (ActivityCompat.checkSelfPermission(context, // Kiểm tra quyền POST_NOTIFICATIONS trước khi gửi notification
                Manifest.permission.POST_NOTIFICATIONS) // Tên quyền cần kiểm tra
                == PackageManager.PERMISSION_GRANTED // Điều kiện đúng: quyền đã được người dùng cấp
                || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) { // Hoặc thiết bị chạy Android dưới 13 (không yêu cầu quyền này)
            NotificationManagerCompat.from(context).notify(NOTIF_ID, notif); // Gửi notification lên hệ thống với ID đã định nghĩa
        }
    }

    // SeekBar không được hỗ trợ trong RemoteViews!
    public static void showExpanded(Context context) { // Phương thức hiển thị notification dạng mở rộng
        RemoteViews view = new RemoteViews( // Tạo đối tượng RemoteViews để render layout tuỳ chỉnh trong notification
                context.getPackageName(), R.layout.notification_expanded); // Sử dụng layout notification_expanded.xml làm giao diện

        view.setOnClickPendingIntent(R.id.btn_prev_exp, // Gán PendingIntent cho nút Bài trước (phiên bản mở rộng)
                makePI(context, ACTION_PREV)); // Tạo PendingIntent xử lý hành động quay về bài trước
        view.setOnClickPendingIntent(R.id.btn_play_pause_exp, // Gán PendingIntent cho nút Phát/Tạm dừng (phiên bản mở rộng)
                makePI(context, ACTION_PAUSE)); // Tạo PendingIntent xử lý hành động phát hoặc tạm dừng nhạc
        view.setOnClickPendingIntent(R.id.btn_next_exp, // Gán PendingIntent cho nút Bài tiếp theo (phiên bản mở rộng)
                makePI(context, ACTION_NEXT)); // Tạo PendingIntent xử lý hành động chuyển sang bài tiếp theo
        view.setOnClickPendingIntent(R.id.btn_collapse, // Gán PendingIntent cho nút Thu gọn trong layout mở rộng
                makePI(context, ACTION_COLLAPSE)); // Tạo PendingIntent xử lý hành động thu gọn notification
        view.setOnClickPendingIntent(R.id.btn_close_exp, // Gán PendingIntent cho nút Đóng (phiên bản mở rộng)
                makePI(context, ACTION_CLOSE)); // Tạo PendingIntent xử lý hành động đóng notification

        // showExpanded() - tương tự
        Notification notif = new NotificationCompat.Builder(context, CHANNEL_ID) // Tạo builder để xây dựng đối tượng Notification
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Đặt icon nhỏ hiển thị trên thanh trạng thái hệ thống
                .setCustomContentView(view)      // thêm dòng này - đặt layout tuỳ chỉnh khi notification thu gọn
                .setCustomBigContentView(view) // Đặt layout tuỳ chỉnh cho notification khi ở trạng thái mở rộng
                // XÓA .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setPriority(NotificationCompat.PRIORITY_LOW) // Đặt độ ưu tiên thấp: không làm gián đoạn người dùng
                .setOngoing(true) // Đặt notification là đang diễn ra, người dùng không thể vuốt để xoá
                .build(); // Hoàn thiện quá trình xây dựng và tạo đối tượng Notification


        if (ActivityCompat.checkSelfPermission(context, // Kiểm tra quyền POST_NOTIFICATIONS trước khi gửi notification
                Manifest.permission.POST_NOTIFICATIONS) // Tên quyền cần kiểm tra
                == PackageManager.PERMISSION_GRANTED // Điều kiện đúng: quyền đã được người dùng cấp
                || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) { // Hoặc thiết bị chạy Android dưới 13
            NotificationManagerCompat.from(context).notify(NOTIF_ID, notif); // Gửi notification lên hệ thống với ID đã định nghĩa
        }
    }
}
