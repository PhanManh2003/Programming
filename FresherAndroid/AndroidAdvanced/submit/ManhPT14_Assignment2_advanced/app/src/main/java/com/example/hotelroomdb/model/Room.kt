package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "room",
    foreignKeys = [ForeignKey(
        entity = RoomType::class,
        parentColumns = ["typeId"],
        childColumns = ["typeId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("typeId")]
)
data class Room(
    @PrimaryKey
    val roomNumber: Int,
    val typeId: Int
)