package com.example.animationmusic.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;       // Tên bài hát
    private String artist;      // Tên ca sĩ
    private int coverImageRes;  // Resource ID của ảnh bìa (drawable)
    private int audioRes;       // Resource ID của file nhạc (raw)

    public Song(String title, String artist, int coverImageRes, int audioRes) {
        this.title = title;
        this.artist = artist;
        this.coverImageRes = coverImageRes;
        this.audioRes = audioRes;
    }

    // Getter
    public String getTitle()       { return title; }
    public String getArtist()      { return artist; }
    public int getCoverImageRes()  { return coverImageRes; }
    public int getAudioRes()       { return audioRes; }
}
