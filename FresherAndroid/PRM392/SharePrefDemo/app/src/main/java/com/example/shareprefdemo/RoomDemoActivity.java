package com.example.shareprefdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class RoomDemoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_uid, edt_fn, edt_ln;
    MyRoomDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        db = Room.databaseBuilder(getApplicationContext(),
                MyRoomDatabase.class, "user_db")
                .allowMainThreadQueries().build();
        edt_uid = findViewById(R.id.edt_uid);
        edt_ln = findViewById(R.id.edt_lastname);
        edt_fn = findViewById(R.id.edt_firstname);
        ((Button)findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_read)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            String uid = edt_uid.getText().toString();
            String f = edt_fn.getText().toString();
            String l = edt_ln.getText().toString();
            UserDao userDao = db.userDao();
            userDao.insertAll(new User(Integer.valueOf(uid), f, l));
        } else if (view.getId() == R.id.btn_read) {
            UserDao userDao = db.userDao();
            List<User> users = userDao.getAll();
            ((TextView)findViewById(R.id.tv_show)).setText(users.toString());
        }

    }

}