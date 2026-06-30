package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client")
data class Client(
    @PrimaryKey(autoGenerate = true)
    val clientId: Int = 0,
    val fullName: String,
    val gender: String,
    val country: String,
    val phone: String
)