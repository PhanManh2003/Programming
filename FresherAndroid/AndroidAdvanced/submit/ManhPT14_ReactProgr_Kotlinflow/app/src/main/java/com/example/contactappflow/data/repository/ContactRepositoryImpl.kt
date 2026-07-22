package com.example.contactappflow.data.repository

import com.example.contactappflow.data.local.Contact
import com.example.contactappflow.data.local.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ContactRepositoryImpl(
    private val dao: ContactDao
) : ContactRepository {

    override fun getAllContacts(): Flow<List<Contact>> =
        dao.getAllContacts().flowOn(Dispatchers.IO)

    override fun search(query: String): Flow<List<Contact>> =
        dao.search("%$query%").flowOn(Dispatchers.IO)

    override suspend fun insert(contact: Contact) {
        dao.insert(contact)
    }

    override suspend fun update(contact: Contact) {
        dao.update(contact)
    }

    override suspend fun delete(contact: Contact) {
        dao.delete(contact)
    }
}