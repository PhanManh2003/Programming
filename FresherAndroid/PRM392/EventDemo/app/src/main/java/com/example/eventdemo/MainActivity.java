package com.example.eventdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_login;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.button);
        textView = findViewById(R.id.tv_result);
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               btn_login.setText("you clicked");
//            }
//        });
        btn_login.setOnClickListener(this::onClick);
        textView.setOnClickListener(this::onClick);
//        CharSequence fullname=  getIntent().getCharSequenceExtra("fullname");
//        int age = getIntent().getIntExtra("age",0);
        Person p = (Person) getIntent().getSerializableExtra("person");
        String fullname = p.getName();
        int age = p.getAge();
        textView.setText(fullname + "/" + age);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            btn_login.setText("you clicked btn");
        } else if (v.getId() == R.id.tv_result) {
            textView.setText("you clicked text");
        }

    }

//    public void onClickBtn(View view) {
//        btn_login.setText("You've clicked");
//    }
}