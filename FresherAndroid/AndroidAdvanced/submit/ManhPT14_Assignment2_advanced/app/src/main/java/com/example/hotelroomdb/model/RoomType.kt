package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_type")
data class RoomType(
    @PrimaryKey(autoGenerate = true)
    val typeId: Int = 0,
    val typeName: String,
    val pricePerNight: Double
)