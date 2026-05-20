package com.example.multithreaddemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView tv;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        // handler chạy trên main thread
        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                tv.setText("count: " + count);
            }
        };
    }

    public void onStartCount(View view) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long future_time = System.currentTimeMillis() + 10000;
                while (System.currentTimeMillis() < future_time) {
                    try {
                        synchronized (this) {
                            wait(1000);
                            count += 1;
                            handler.sendEmptyMessage(0);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();

    }
}