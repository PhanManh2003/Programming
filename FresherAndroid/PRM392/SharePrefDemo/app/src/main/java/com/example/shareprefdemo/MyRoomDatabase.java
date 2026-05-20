package com.example.shareprefdemo;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
