package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "room_type_facility",
    primaryKeys = ["typeId", "facilityId"],
    foreignKeys = [
        ForeignKey(
            entity = RoomType::class,
            parentColumns = ["typeId"],
            childColumns = ["typeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Facility::class,
            parentColumns = ["facilityId"],
            childColumns = ["facilityId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("facilityId")]
)
data class RoomTypeFacility(
    val typeId: Int,
    val facilityId: Int
)