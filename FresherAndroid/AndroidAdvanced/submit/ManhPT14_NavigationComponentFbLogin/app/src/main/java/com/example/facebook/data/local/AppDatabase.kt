package com.example.facebook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.facebook.data.local.dao.UserDao
import com.example.facebook.data.local.entity.UserEntity


@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}