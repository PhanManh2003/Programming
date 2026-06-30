package com.example.ass1.model

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val phone: String,
    val email: String
)