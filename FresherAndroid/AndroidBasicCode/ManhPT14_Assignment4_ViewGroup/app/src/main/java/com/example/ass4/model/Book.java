package com.example.ass4.model;

public class Book {
    private String title;
    private String author;
    private int imageRes; // resource id của ảnh

    public Book() {

    }

    public Book(String title, String author, int imageRes) {
        this.title = title;
        this.author = author;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

}
