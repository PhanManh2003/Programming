package com.example.hotelroomdb.model.relation


import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotelroomdb.model.Room
import com.example.hotelroomdb.model.RoomType

data class RoomWithType(
    @Embedded val room: Room,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "typeId"
    )
    val roomType: RoomType
)