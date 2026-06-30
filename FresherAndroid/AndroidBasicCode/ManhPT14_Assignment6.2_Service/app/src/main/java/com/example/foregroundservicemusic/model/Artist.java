package com.example.foregroundservicemusic.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;       // Tên nghệ sĩ
    private List<Song> songs;  // Danh sách bài hát của nghệ sĩ này

    public Artist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    // Thêm bài hát vào danh sách của nghệ sĩ
    public void addSong(Song song) {
        songs.add(song);
    }

    // Số bài hát — dùng để hiển thị "X bài hát" trong item
    public int getSongCount() {
        return songs.size();
    }

    // Lấy ảnh bìa của bài đầu tiên để đại diện cho nghệ sĩ
    public int getCoverArt() {
        if (songs.isEmpty()) return 0;
        return songs.get(0).getCoverArt();
    }
}
