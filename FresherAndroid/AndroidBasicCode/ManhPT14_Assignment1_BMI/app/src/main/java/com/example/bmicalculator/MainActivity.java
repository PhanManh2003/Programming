package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtHeight;
    private EditText edtWeight;
    private TextView tvResult2;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lấy các view ra từ id
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        tvResult2 = findViewById(R.id.tvResult2);
        btnOk = findViewById(R.id.btnOk);
        // hàm calculate xử lí khi click event xuất hiện trên btn
        btnOk.setOnClickListener(view -> calculateBMI());
    }


    // hàm tính BMI
    private void calculateBMI() {
        String heightStr = edtHeight.getText().toString().trim();
        String weightStr = edtWeight.getText().toString().trim();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            tvResult2.setText("Please enter height and weight");
            return;
        }
        try {
            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);

            if (height <= 0 || weight <= 0) {
                tvResult2.setText("Height and weight must be > 0");
                return;
            }

            double bmi = weight / (height * height);

            String category;

            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            String result = String.format(
                    "BMI = %.2f\n%s",
                    bmi,
                    category
            );

            tvResult2.setText(result);

        } catch (NumberFormatException e) {
            tvResult2.setText("Invalid input, must be number.");
        }
    }
}