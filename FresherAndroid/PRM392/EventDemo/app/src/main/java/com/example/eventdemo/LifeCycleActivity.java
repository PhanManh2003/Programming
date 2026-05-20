package com.example.eventdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LifeCycleActivity extends AppCompatActivity {
    EditText edt_fullname , edt_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        edt_fullname = findViewById(R.id.edt_fullname);
        edt_age = findViewById(R.id.edt_age);
        Log.d("LifeCycle_Log","onCreate");
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence fn = edt_fullname.getText();
                int age = Integer.valueOf(edt_age.getText().toString());
               Intent intent = new Intent(LifeCycleActivity.this, MainActivity.class);
               Person p = new Person(fn.toString(), age);
               intent.putExtra("person",p);
               startActivity(intent);
               finish();
            }
        });
        ((Button) findViewById(R.id.btn_call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0869374650"));
//               i2.setAction(Intent.ACTION_DIAL);
//               i2.setData(Uri.parse("tel:0869374650"));
               startActivity(i2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCycle_Log","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCycle_Log","onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCycle_Log","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCycle_Log","onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("LifeCycle_Log","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("LifeCycle_Log","onStop");
        super.onStop();
    }
}