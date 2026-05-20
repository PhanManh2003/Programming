package com.example.sqlitedemo;

import android.database.Cursor;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_uid, edt_fn, edt_ln;
    MyOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        ((Button) findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_read)).setOnClickListener(this);

        edt_uid = findViewById(R.id.edt_uid);
        edt_fn = findViewById(R.id.edt_firstname);
        edt_ln = findViewById(R.id.edt_lastname);
        openHelper = new MyOpenHelper(this, "userdb", null, 1);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            db = openHelper.getWritableDatabase();
            String s = "INSERT INTO user (uid, firstname, lastname) VALUES (?,?,?)";
            db.execSQL(s, new String[]{edt_uid.getText().toString(),
                    edt_fn.getText().toString(), edt_ln.getText().toString()});
            db.close();
        } else if (v.getId() == R.id.btn_read) {
            String sql = "SELECT * FROM user";
            db = openHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            String result = "";
            while (cursor.moveToNext()) {
                int uid = cursor.getInt(0);
                int fn_index = cursor.getColumnIndex("firstname");
                String fn = cursor.getString(fn_index);
                int ln_index = cursor.getColumnIndex("lastname");
                String ln = cursor.getString(ln_index);
                result += uid + ": " + fn + " " + ln;
            }
            ((TextView)findViewById(R.id.tv_show)).setText(result);
        }
    }
}