package com.example.shareprefdemo;

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

public class SQLiteDemoActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt_uid, edt_fn, edt_ln;
    MyOpenHelperDB myHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);
        edt_uid = findViewById(R.id.edt_uid);
        edt_ln = findViewById(R.id.edt_lastname);
        edt_fn = findViewById(R.id.edt_firstname);
        myHelper = new MyOpenHelperDB(this, "user_db", null, 1);
        ((Button)findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_read)).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            db = myHelper.getWritableDatabase();
            String uid = edt_uid.getText().toString();
            String sql = "INSERT INTO user VALUES (?, ?, ?)";
            db.execSQL(sql,
                    new String[]{uid, edt_fn.getText().toString(), edt_ln.getText().toString()});
            db.close();
        } else if (view.getId() == R.id.btn_read) {
            String sql = "SELECT * FROM user";
            db = myHelper.getReadableDatabase();
            Cursor c = db.rawQuery(sql, null);
            String result = "";
            while (c.moveToNext()) {
                int uid = c.getInt(0);
                int fn_index = c.getColumnIndex("firstname");
                String f = c.getString(fn_index);
                String l = c.getString(2);
                result += uid + ": " + f + " " + l + "\n";
            }
            ((TextView)findViewById(R.id.tv_show)).setText(result);

            db.close();
        }
    }
}