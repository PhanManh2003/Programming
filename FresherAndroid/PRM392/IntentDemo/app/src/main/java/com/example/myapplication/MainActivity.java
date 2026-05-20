package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.btn_call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open dial app, using implicit intent
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0987654321"));
                startActivity(i);
            }
        });


    }

    public void onGoToSecondActivity(View view) {
        //Explicit intent
        Intent i = new Intent(this, SecondActivity.class);
        CharSequence fn = ((EditText)findViewById(R.id.editTextText)).getText();
        String age_str = ((EditText)findViewById(R.id.editTextNumber)).getText().toString();
        int age = Integer.parseInt(age_str);
//        i.putExtra("fullname", fn);
//        i.putExtra("age", age);
        Person p = new Person(fn.toString(), age);
        i.putExtra("person", p);
        startActivity(i);
    }
}