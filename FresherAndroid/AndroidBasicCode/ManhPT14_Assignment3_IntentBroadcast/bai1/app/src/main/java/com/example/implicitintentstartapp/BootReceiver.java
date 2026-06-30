package com.example.implicitintentstartapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // check xem có đúng là intent action boot completed ko ( optional nhưng nên check để tránh nhận nhầm các intent khác )
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // Thông báo đã nhận broadcast
            Toast.makeText(context, "Đã nhận BOOT_COMPLETED!", Toast.LENGTH_LONG).show();

            // Dùng Implicit Intent để mở app
            Intent launchIntent = new Intent();
            launchIntent.setAction("com.example.implicitintentstartapp.LAUNCH"); // action tự đặt

            /*
            * Khi mở Activity từ bên ngoài Activity (ở đây là từ BroadcastReceiver),
            * Android bắt buộc phải có flag này vì BroadcastReceiver không có back stack
            *  — cần tạo một task mới để chứa Activity.
            * */

            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(launchIntent);
        }
    }
}
