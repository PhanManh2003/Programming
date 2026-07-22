package com.example.reactivecontactapp.data.repository

import com.example.reactivecontactapp.data.local.Contact
import com.example.reactivecontactapp.data.local.ContactDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class ContactRepositoryImpl(
    private val dao: ContactDao
) : ContactRepository {

    override fun getAllContacts(): Observable<List<Contact>> =
        dao.getAllContacts()

    override fun search(query: String): Observable<List<Contact>> =
        dao.search("%$query%")

    override fun insert(contact: Contact): Completable =
        dao.insert(contact)

    override fun update(contact: Contact): Completable =
        dao.update(contact)

    override fun delete(contact: Contact): Completable =
        dao.delete(contact)
}