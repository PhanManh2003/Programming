package com.example.contactapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "email")
    private String email;

    // Lưu ảnh dạng Base64 string, null nếu không có
    @ColumnInfo(name = "photo")
    private String photo;

    public Contact(String name, String phone, String email, String photo) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPhone(String p) {
        this.phone = p;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setPhoto(String p) {
        this.photo = p;
    }
}
