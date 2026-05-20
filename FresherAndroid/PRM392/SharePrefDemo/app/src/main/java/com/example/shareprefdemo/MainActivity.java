package com.example.shareprefdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt_usn, edt_pass;
    CheckBox cb;
    SharedPreferences shared_pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        edt_usn = findViewById(R.id.edt_username);
        edt_pass = findViewById(R.id.edt_pass);
        cb = findViewById(R.id.cb_remember);
        ((Button)findViewById(R.id.btn_login)).setOnClickListener(this);
        shared_pref = getSharedPreferences("account", MODE_PRIVATE);
        String u = shared_pref.getString("username", "");
        String p = shared_pref.getString("pass", "");
        boolean saved = shared_pref.getBoolean("is_saved", false);
        if (saved) {
            edt_usn.setText(u);
            edt_pass.setText(p);
            cb.setChecked(true);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            if (cb.isChecked()) {
                editor = shared_pref.edit();
                editor.putString("username", edt_usn.getText().toString());
                editor.putString("pass", edt_pass.getText().toString());
                editor.putBoolean("is_saved", true);
                editor.commit();
            } else {
                editor = shared_pref.edit();
//                editor.remove("username");
                editor.clear();
                editor.commit();
            }
        }
    }
}