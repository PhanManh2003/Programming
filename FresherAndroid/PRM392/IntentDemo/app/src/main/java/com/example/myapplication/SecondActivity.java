package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        CharSequence fn = getIntent().getCharSequenceExtra("fullname");
//        int age = getIntent().getIntExtra("age", 0);
        Person p = (Person)getIntent().getSerializableExtra("person");
        ((TextView)findViewById(R.id.tv_result)).setText(p.toString());
    }
}