package com.example.hotelroomdb.repository

import com.example.hotelroomdb.dao.FacilityDao
import com.example.hotelroomdb.model.Facility
import com.example.hotelroomdb.model.RoomTypeFacility
import kotlinx.coroutines.flow.Flow

class FacilityRepository(private val facilityDao: FacilityDao) {
    fun getAllFacilities(): Flow<List<Facility>> = facilityDao.getAll()
    suspend fun insert(facility: Facility) = facilityDao.insert(facility)
    suspend fun delete(facility: Facility) = facilityDao.delete(facility)
    suspend fun getFacilitiesByType(typeId: Int) = facilityDao.getFacilitiesByType(typeId)
    suspend fun insertRoomTypeFacility(cross: RoomTypeFacility) =
        facilityDao.insertRoomTypeFacility(cross)
}