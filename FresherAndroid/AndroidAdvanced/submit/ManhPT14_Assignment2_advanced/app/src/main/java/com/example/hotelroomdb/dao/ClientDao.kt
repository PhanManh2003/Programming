package com.example.hotelroomdb.dao

import androidx.room.*
import com.example.hotelroomdb.model.Client
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(client: Client): Long

    @Update
    suspend fun update(client: Client)

    @Delete
    suspend fun delete(client: Client)

    @Query("SELECT * FROM client")
    fun getAll(): Flow<List<Client>>

    @Query("SELECT * FROM client WHERE clientId = :id")
    suspend fun getById(id: Int): Client?
}