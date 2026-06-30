package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "occupation",
    foreignKeys = [
        ForeignKey(
            entity = Room::class,
            parentColumns = ["roomNumber"],
            childColumns = ["roomNumber"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Client::class,
            parentColumns = ["clientId"],
            childColumns = ["clientId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("roomNumber"), Index("clientId")]
)
data class Occupation(
    @PrimaryKey(autoGenerate = true)
    val occupationId: Int = 0,
    val roomNumber: Int,
    val clientId: Int,
    val checkIn: String,   // format: "yyyy-MM-dd"
    val checkOut: String,  // format: "yyyy-MM-dd"
    val extraExpenses: Double = 0.0
)