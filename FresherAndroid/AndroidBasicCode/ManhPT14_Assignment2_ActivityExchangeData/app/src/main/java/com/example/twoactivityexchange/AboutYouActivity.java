package com.example.twoactivityexchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

/*
* 1. Thiết kế giao diện
* 2. Xử lí sự kiện click và logic
*  [Ac1] Click "Your name" text view
        ↓  intent + "field_name=Your name"
[Ac2] Hiện EditText với hint "Enter your name..."
* khi nhập thì validate luôn
* -> Submit bật khi có text chuẩn
        ↓  result + "field_name" + "value"
[Ac1] Nhận kết quả → textView.setText(value)
* */
public class AboutYouActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvName, tvAge, tvMajor, tvFav;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);

        // lấy các text view rồi gán biến
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvMajor = findViewById(R.id.tvMajor);
        tvFav = findViewById(R.id.tvFav);

        // đăng kí sự kiện click cho các textView
        tvName.setOnClickListener(this);
        tvAge.setOnClickListener(this);
        tvMajor.setOnClickListener(this);
        tvFav.setOnClickListener(this);

        // Đăng ký launcher nhận kết quả từ B
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        // nhận data từ bên Input value gửi về
                        String fieldName = result.getData().getStringExtra("field_name");
                        String value = result.getData().getStringExtra("value");

                        if ("your name ...".equals(fieldName)) tvName.setText(value);
                        else if ("your age ...".equals(fieldName)) tvAge.setText(value);
                        else if ("your major ...".equals(fieldName)) tvMajor.setText(value);
                        else if ("your favourite ...".equals(fieldName)) tvFav.setText(value);
                    }
                }
        );

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InputValueActivity.class);
        if (v.getId() == R.id.tvName) intent.putExtra("field_name", "your name ...");
        else if (v.getId() == R.id.tvAge) intent.putExtra("field_name", "your age ...");
        else if (v.getId() == R.id.tvMajor) intent.putExtra("field_name", "your major ...");
        else if (v.getId() == R.id.tvFav) intent.putExtra("field_name", "your favourite ...");

        launcher.launch(intent);
    }
}