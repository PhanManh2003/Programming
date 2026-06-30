package com.example.sqlitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper(context: Context?, name: String?, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase) { // create tables
        val sql = "CREATE TABLE user (" +
                "uid INTEGER PRIMARY KEY, " +
                "firstname TEXT NOT NULL, " +
                "lastname TEXT NOT NULL)"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // TODO: drop current tables, re-create new tables
    }
}
