package com.example.contactapp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contactapp.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    long insert(Contact contact);

    @Update
    int update(Contact contact);

    @Delete
    int delete(Contact contact);

    // Lấy tất cả, sắp xếp theo alphabet
    @Query("SELECT * FROM contacts ORDER BY name COLLATE NOCASE ASC")
    List<Contact> getAll();

    @Query("SELECT * FROM contacts WHERE id = :id LIMIT 1")
    Contact getById(int id);

    // Tìm theo tên hoặc số điện thoại
    @Query("SELECT * FROM contacts WHERE name LIKE :kw OR phone LIKE :kw ORDER BY name COLLATE NOCASE ASC")
    List<Contact> search(String kw);

    @Query("SELECT COUNT(*) FROM contacts")
    int count();
}
