package com.example.permissiondemo;

import static android.Manifest.permission.CALL_PHONE;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        requestCallPhonePermission();
    }
    public void onCall(View view){
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 099888888"));
        startActivity(i);
    }
    public void requestCallPhonePermission(){
        //Kiểm tra xem app của bạn có quyền (permission) gọi điện thoại trực tiếp chưa, chưa thì request
        if (checkSelfPermission(CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE}, 1001);
        }
    }
}