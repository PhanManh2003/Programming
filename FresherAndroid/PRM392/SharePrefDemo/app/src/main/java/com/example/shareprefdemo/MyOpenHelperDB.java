package com.example.shareprefdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelperDB extends SQLiteOpenHelper {

    public MyOpenHelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version); //xác định tên, version của db
    }

    @Override
    public void onCreate(SQLiteDatabase db) {// tạo các table
        String sql = "CREATE TABLE user (uid int primary key, firstname text, lastname text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//nâng cấp db
        if (i1>i) {
            //drop current table, recreate ......
        }
    }
}
