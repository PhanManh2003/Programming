package com.example.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version); // create db, version
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // create tables
        String sql = "CREATE TABLE user (" +
                "uid INTEGER PRIMARY KEY, " +
                "firstname TEXT NOT NULL, " +
                "lastname TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: drop current tables, re-create new tables
    }
}
