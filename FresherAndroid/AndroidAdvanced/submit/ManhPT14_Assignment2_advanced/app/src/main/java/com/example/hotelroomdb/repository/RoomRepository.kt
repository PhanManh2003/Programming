package com.example.hotelroomdb.repository

import com.example.hotelroomdb.dao.RoomDao
import com.example.hotelroomdb.dao.RoomTypeDao
import com.example.hotelroomdb.model.Room
import com.example.hotelroomdb.model.RoomType
import com.example.hotelroomdb.model.relation.RoomWithType
import androidx.room.Room as RoomLib
import kotlinx.coroutines.flow.Flow

class RoomRepository(private val roomDao: RoomDao, private val roomTypeDao: RoomTypeDao) {
    fun getAllRooms(): Flow<List<Room>> = roomDao.getAll()
    fun getAllRoomsWithType(): Flow<List<RoomWithType>> = roomDao.getAllWithType()
    suspend fun insert(room: Room) = roomDao.insert(room)
    suspend fun delete(room: Room) = roomDao.delete(room)
    suspend fun getAvailableRooms(checkIn: String, checkOut: String) =
        roomDao.getAvailableRooms(checkIn, checkOut)

    fun getAllRoomTypes(): Flow<List<RoomType>> = roomTypeDao.getAll()
    suspend fun insertRoomType(roomType: RoomType) = roomTypeDao.insert(roomType)
}