package com.example.hotelroomdb.dao

import androidx.room.*
import com.example.hotelroomdb.model.Occupation
import com.example.hotelroomdb.model.relation.OccupationDetail
import com.example.hotelroomdb.model.result.ClientExpense
import com.example.hotelroomdb.model.result.YearlyRevenue
import kotlinx.coroutines.flow.Flow

@Dao
interface OccupationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(occupation: Occupation): Long

    @Update
    suspend fun update(occupation: Occupation)

    @Delete
    suspend fun delete(occupation: Occupation)

    @Query("""
        SELECT o.occupationId, c.fullName AS clientName, o.roomNumber,
               rt.typeName, rt.pricePerNight, o.checkIn, o.checkOut, o.extraExpenses
        FROM occupation o
        INNER JOIN client c ON o.clientId = c.clientId
        INNER JOIN room r ON o.roomNumber = r.roomNumber
        INNER JOIN room_type rt ON r.typeId = rt.typeId
        ORDER BY o.checkIn DESC
    """)
    fun getAllDetails(): Flow<List<OccupationDetail>>

    // Mục 4: tổng chi phí mỗi khách năm 2023
    @Query("""
        SELECT o.clientId, c.fullName AS clientName,
               SUM(
                   (julianday(o.checkOut) - julianday(o.checkIn)) * rt.pricePerNight
                   + o.extraExpenses
               ) AS totalExpense
        FROM occupation o
        INNER JOIN client c ON o.clientId = c.clientId
        INNER JOIN room r ON o.roomNumber = r.roomNumber
        INNER JOIN room_type rt ON r.typeId = rt.typeId
        WHERE strftime('%Y', o.checkIn) = '2023'
        GROUP BY o.clientId, c.fullName
        ORDER BY totalExpense DESC
    """)
    fun getClientExpenses2023(): Flow<List<ClientExpense>>

    // Mục 5: doanh thu theo năm
    @Query("""
        SELECT CAST(strftime('%Y', o.checkIn) AS INTEGER) AS year,
               SUM(
                   (julianday(o.checkOut) - julianday(o.checkIn)) * rt.pricePerNight
                   + o.extraExpenses
               ) AS totalRevenue
        FROM occupation o
        INNER JOIN room r ON o.roomNumber = r.roomNumber
        INNER JOIN room_type rt ON r.typeId = rt.typeId
        GROUP BY year
        ORDER BY year DESC
    """)
    fun getYearlyRevenue(): Flow<List<YearlyRevenue>>
}