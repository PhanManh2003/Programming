package com.example.hotelroomdb.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.hotelroomdb.model.Room
import com.example.hotelroomdb.model.relation.RoomWithType
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(room: Room): Long

    @Delete
    suspend fun delete(room: Room)

    @Query("SELECT * FROM room")
    fun getAll(): Flow<List<Room>>

    @Transaction
    @Query("SELECT * FROM room")
    fun getAllWithType(): Flow<List<RoomWithType>>

    @Query("SELECT * FROM room WHERE roomNumber = :roomNumber")
    suspend fun getByNumber(roomNumber: Int): Room?

    // Phòng chưa bị thuê trong khoảng thời gian (dùng cho form)
    @Query(
        """
        SELECT * FROM room 
        WHERE roomNumber NOT IN (
            SELECT roomNumber FROM occupation
            WHERE checkIn < :checkOut AND checkOut > :checkIn
        )
    """
    )
    suspend fun getAvailableRooms(checkIn: String, checkOut: String): List<Room>
}