package com.example.bai2_intentsenddata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_b);

        // Nhận intent từ A và lấy data
        Intent intentFromA = getIntent();
        ArrayList<String> greetings = intentFromA.getStringArrayListExtra("greetings");
        // Display vô text view với string builder cho đẹp
        tvResult = findViewById(R.id.tvResult);
        StringBuilder sb = new StringBuilder();
        for (String greeting : greetings) {
            sb.append(greeting).append("\n");
        }
        tvResult.setText(sb.toString());


        // Hiển thị ra Logcat
        for (String greeting : greetings) {
            Log.d("GREETING", greeting);
        }
    }
}