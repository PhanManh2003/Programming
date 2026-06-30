package com.example.foregroundservicemusic.model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;       // Tên album
    private String artist;     // Tên nghệ sĩ của album
    private int coverArt;      // Ảnh bìa album (lấy từ bài đầu tiên)
    private List<Song> songs;  // Danh sách bài trong album

    public Album(String name, String artist, int coverArt) {
        this.name = name;
        this.artist = artist;
        this.coverArt = coverArt;
        this.songs = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getArtist() { return artist; }
    public int getCoverArt() { return coverArt; }
    public List<Song> getSongs() { return songs; }
    public void addSong(Song song) { songs.add(song); }
    public int getSongCount() { return songs.size(); }
}
