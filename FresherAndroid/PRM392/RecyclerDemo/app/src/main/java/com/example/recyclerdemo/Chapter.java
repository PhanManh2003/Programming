package com.example.recyclerdemo;

public class Chapter {
    private String title;
    private String description;
    private int ava_chap;

    public Chapter(String title, String description, int ava_chap) {
        this.title = title;
        this.description = description;
        this.ava_chap = ava_chap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAva_chap() {
        return ava_chap;
    }

    public void setAva_chap(int ava_chap) {
        this.ava_chap = ava_chap;
    }
}
