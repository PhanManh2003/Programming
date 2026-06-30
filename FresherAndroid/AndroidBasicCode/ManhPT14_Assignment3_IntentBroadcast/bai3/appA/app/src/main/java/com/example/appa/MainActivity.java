package com.example.appa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
* Hướng dẫn nếu button không mở app B lên
* 1. Vô File -> New -> Import Project -> chọn app B
* 2. Chạy App A như bình thường sẽ hết bug
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // lấy 2 button
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        // xử lí sự kiện
        // Cách 1: dùng Intent trực tiếp
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.appb.INTENT_OPEN");
            startActivity(intent);
        });

        // Cách 2: dùng BroadcastReceiver
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.appb.BROADCAST_OPEN");
            // Android 8+ chặn implicit broadcast giữa 2 app nên phải setPackage
            intent.setPackage("com.example.appb");
            sendBroadcast(intent);
        });
    }
}