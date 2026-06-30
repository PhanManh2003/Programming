package com.example.hotelroomdb.repository

import com.example.hotelroomdb.dao.OccupationDao
import com.example.hotelroomdb.model.Occupation
import com.example.hotelroomdb.model.relation.OccupationDetail
import com.example.hotelroomdb.model.result.ClientExpense
import com.example.hotelroomdb.model.result.YearlyRevenue
import kotlinx.coroutines.flow.Flow

class OccupationRepository(private val occupationDao: OccupationDao) {
    fun getAllDetails(): Flow<List<OccupationDetail>> = occupationDao.getAllDetails()
    fun getClientExpenses2023(): Flow<List<ClientExpense>> = occupationDao.getClientExpenses2023()
    fun getYearlyRevenue(): Flow<List<YearlyRevenue>> = occupationDao.getYearlyRevenue()
    suspend fun insert(occupation: Occupation) = occupationDao.insert(occupation)
    suspend fun update(occupation: Occupation) = occupationDao.update(occupation)
    suspend fun delete(occupation: Occupation) = occupationDao.delete(occupation)
}