package com.example.foregroundservicemusic.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;       // Tên playlist do user đặt
    private List<Song> songs;  // Danh sách bài trong playlist

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Song> getSongs() { return songs; }
    public void addSong(Song song) { songs.add(song); }
    public void removeSong(Song song) { songs.remove(song); }
    public int getSongCount() { return songs.size(); }

    // Lấy ảnh bìa bài đầu tiên để đại diện cho playlist
    // Trả về 0 nếu playlist rỗng
    public int getCoverArt() {
        if (songs.isEmpty()) return 0;
        return songs.get(0).getCoverArt();
    }
}
