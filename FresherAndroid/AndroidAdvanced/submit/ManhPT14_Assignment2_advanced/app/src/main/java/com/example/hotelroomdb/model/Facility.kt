package com.example.hotelroomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facility")
data class Facility(
    @PrimaryKey(autoGenerate = true)
    val facilityId: Int = 0,
    val facilityName: String
)