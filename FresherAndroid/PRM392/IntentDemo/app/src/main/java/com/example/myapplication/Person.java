package com.example.myapplication;

import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Serializable {
    private String fullname;
    private int age;

    public Person(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullname + "/" + age;
    }
}
