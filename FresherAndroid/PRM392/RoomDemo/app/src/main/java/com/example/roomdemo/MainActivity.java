package com.example.roomdemo;

import android.database.sqlite.SQLiteDatabase;
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
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_uid, edt_fn, edt_ln;
    UserDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        ((Button) findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_read)).setOnClickListener(this);
        edt_uid = findViewById(R.id.edt_uid);
        edt_fn = findViewById(R.id.edt_firstname);
        edt_ln = findViewById(R.id.edt_lastname);
        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user_db").allowMainThreadQueries().build();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_read) {
            List<User> users = db.userDao().getAll();
            ((TextView)findViewById(R.id.tv_show)).setText(users.toString());
        } else if (v.getId() == R.id.btn_add) {
            // Lấy dữ liệu từ EditText
            int uid = Integer.parseInt(edt_uid.getText().toString());
            String firstName = edt_fn.getText().toString();
            String lastName = edt_ln.getText().toString();

            // Tạo user mới
            User user = new User(uid, firstName, lastName);

            // Thêm vào DB
            db.userDao().insert(user);

            // Thông báo
            ((TextView) findViewById(R.id.tv_show)).setText("Đã thêm user: " + user.toString());
        }
    }
}