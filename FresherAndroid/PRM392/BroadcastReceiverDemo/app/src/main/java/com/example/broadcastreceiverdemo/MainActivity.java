package com.example.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String MY_CUSTOM_BROADCAST = "com.example.broadcastreceiverdemo.MY_CUSTOM_BROADCAST";
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter f = new IntentFilter(); // → Tạo bộ lọc (filter) để chỉ định loại broadcast mà bạn quan tâm.
        f.addAction(Intent.ACTION_BATTERY_LOW); // chỉ định loại broadcast là ACTION_BATTERY_LOW.
        f.addAction(MY_CUSTOM_BROADCAST);
        registerReceiver(receiver, f); // → Đăng ký broadcast receiver với bộ lọc đã tạo.
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver); // ngừng lắng nghe broadcast.
    }

    public void onSendBroadcast(View view) {
        Intent i = new Intent();
        i.setAction(MY_CUSTOM_BROADCAST);
        i.putExtra("data", "This is my custom broadcast");
        sendBroadcast(i);
    }
}