package com.example.hotelroomdb.dao

import androidx.room.*
import com.example.hotelroomdb.model.Facility
import com.example.hotelroomdb.model.RoomTypeFacility
import kotlinx.coroutines.flow.Flow

@Dao
interface FacilityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(facility: Facility): Long

    @Delete
    suspend fun delete(facility: Facility)

    @Query("SELECT * FROM facility")
    fun getAll(): Flow<List<Facility>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoomTypeFacility(cross: RoomTypeFacility)

    @Query("SELECT f.* FROM facility f INNER JOIN room_type_facility rtf" +
            " ON f.facilityId = rtf.facilityId WHERE rtf.typeId = :typeId")
    suspend fun getFacilitiesByType(typeId: Int): List<Facility>
}