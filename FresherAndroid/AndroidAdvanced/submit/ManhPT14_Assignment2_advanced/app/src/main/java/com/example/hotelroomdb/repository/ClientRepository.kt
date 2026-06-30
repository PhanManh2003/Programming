package com.example.hotelroomdb.repository

import com.example.hotelroomdb.dao.ClientDao
import com.example.hotelroomdb.model.Client
import kotlinx.coroutines.flow.Flow

class ClientRepository(private val clientDao: ClientDao) {
    fun getAllClients(): Flow<List<Client>> = clientDao.getAll()
    suspend fun insert(client: Client) = clientDao.insert(client)
    suspend fun update(client: Client) = clientDao.update(client)
    suspend fun delete(client: Client) = clientDao.delete(client)
    suspend fun getById(id: Int) = clientDao.getById(id)
}