package com.example.hotelroomdb.dao

import androidx.room.*
import com.example.hotelroomdb.model.RoomType
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(roomType: RoomType): Long

    @Update
    suspend fun update(roomType: RoomType)

    @Delete
    suspend fun delete(roomType: RoomType)

    @Query("SELECT * FROM room_type")
    fun getAll(): Flow<List<RoomType>>

    @Query("SELECT * FROM room_type WHERE typeId = :id")
    suspend fun getById(id: Int): RoomType?
}