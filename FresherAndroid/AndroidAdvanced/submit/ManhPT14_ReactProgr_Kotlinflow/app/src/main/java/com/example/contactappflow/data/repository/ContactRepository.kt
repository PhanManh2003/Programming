package com.example.contactappflow.data.repository

import com.example.contactappflow.data.local.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getAllContacts(): Flow<List<Contact>>
    fun search(query: String): Flow<List<Contact>>
    suspend fun insert(contact: Contact)
    suspend fun update(contact: Contact)
    suspend fun delete(contact: Contact)
}