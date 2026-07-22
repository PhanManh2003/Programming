package com.example.reactivecontactapp.data.repository

import com.example.reactivecontactapp.data.local.Contact
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface ContactRepository {
    fun getAllContacts(): Observable<List<Contact>>
    fun search(query: String): Observable<List<Contact>>
    fun insert(contact: Contact): Completable
    fun update(contact: Contact): Completable
    fun delete(contact: Contact): Completable
}