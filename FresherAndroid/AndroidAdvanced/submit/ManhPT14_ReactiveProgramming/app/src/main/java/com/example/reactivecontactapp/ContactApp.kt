package com.example.reactivecontactapp

import android.app.Application
import androidx.room.Room
import com.example.reactivecontactapp.data.local.AppDatabase
import com.example.reactivecontactapp.data.repository.ContactRepository
import com.example.reactivecontactapp.data.repository.ContactRepositoryImpl

class ContactApp : Application() {

    lateinit var database: AppDatabase
        private set

    lateinit var repository: ContactRepository
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "contact_db"
        ).build()

        repository = ContactRepositoryImpl(database.contactDao())
    }
}