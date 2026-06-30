package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "room_type_photo",
    foreignKeys = [ForeignKey(
        entity = RoomType::class,
        parentColumns = ["typeId"],
        childColumns = ["typeId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("typeId")]
)
data class RoomTypePhoto(
    @PrimaryKey(autoGenerate = true)
    val photoId: Int = 0,
    val typeId: Int,
    val photoUrl: String,
    val isDefault: Boolean = false
)