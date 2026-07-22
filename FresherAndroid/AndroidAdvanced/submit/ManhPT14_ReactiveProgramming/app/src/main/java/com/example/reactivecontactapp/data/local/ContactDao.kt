package com.example.reactivecontactapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable


@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAllContacts(): Observable<List<Contact>>

    @Query("SELECT * FROM contacts WHERE name LIKE :query OR phone LIKE :query ORDER BY name ASC")
    fun search(query: String): Observable<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact): Completable

    @Update
    fun update(contact: Contact): Completable

    @Delete
    fun delete(contact: Contact): Completable
}