package com.example.twoactivityexchange;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputValueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_value);
        EditText edtInput = findViewById(R.id.edtInput);
        Button btnSubmit = findViewById(R.id.tvSubmit);

        // nhận field name từ A rồi điền hint vô editText
        String fieldName = getIntent().getStringExtra("field_name");
        edtInput.setHint("Enter " + fieldName);

        // Disable submit ban đầu
        btnSubmit.setEnabled(false);

        /* Validate: chỉ bật Submit khi thoả mãn điều kiện
        1. Name không được để trống
        2. Age phải từ 1 trở lên
        3. Major không được để trống
        4. Favourite không được để trống
         */
        edtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                String value = s.toString().trim();
                boolean valid;

                // chỉ age mới cần validate số, mấy cái kia validate not empty là dc
                if ("your age ...".equals(fieldName)) {
                    valid = validateAge(value, edtInput);
                } else {
                    valid = validateNotEmpty(value, edtInput);
                }

                btnSubmit.setEnabled(valid);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        btnSubmit.setOnClickListener(v -> {
            Intent resultItent = new Intent();
            resultItent.putExtra("field_name", fieldName);
            resultItent.putExtra("value", edtInput.getText().toString().trim());
            setResult(RESULT_OK, resultItent);
            finish();
        });
    }

    // validate age
    private boolean validateNotEmpty(String value, EditText edt) {

        if (value.isEmpty()) {
            // ko dùng Toast vì mỗi lần nhập 1 kí tự mà chưa
            // hợp lệ nó sẽ hiển thị rất nhiều thông báo
            edt.setError("This field cannot be empty");
            return false;
        }

        edt.setError(null);
        return true;
    }

    private boolean validateAge(String value, EditText edt) {

        if (value.isEmpty()) {
            edt.setError("Age is required");
            return false;
        }

        try {
            int age = Integer.parseInt(value);

            if (age <= 0) {
                edt.setError("Age must be greater than 0");
                return false;
            }

            edt.setError(null);
            return true;

        } catch (NumberFormatException e) {
            edt.setError("Age must be a number");
            return false;
        }
    }

}