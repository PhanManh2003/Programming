package com.example.foregroundservicemusic.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;    // Tên bài hát
    private String artist;   // Tên ca sĩ
    private String album;    // Tên album
    private int resourceId;  // R.raw.xxx — file mp3 trong res/raw
    private int coverArt;    // R.drawable.xxx — ảnh bìa trong res/drawable

    public Song(String title, String artist, String album,
                int resourceId, int coverArt) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.resourceId = resourceId;
        this.coverArt = coverArt;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getCoverArt() {
        return coverArt;
    }
}