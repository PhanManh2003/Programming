package com.example.foregroundservicemusic.data;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.model.Album;
import com.example.foregroundservicemusic.model.Artist;
import com.example.foregroundservicemusic.model.Playlist;
import com.example.foregroundservicemusic.model.Song;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// DataProvider là class tĩnh — cung cấp data dùng chung toàn app
// Dùng lazy initialization: chỉ khởi tạo data khi được gọi lần đầu
public class DataProvider {
    private static List<Song> songs;
    private static List<Artist> artists;
    private static List<Album> albums;
    private static List<Playlist> playlists;

    public static List<Song> getSongs() {
        if (songs == null) initData();
        return songs;
    }

    public static List<Artist> getArtists() {
        if (artists == null) initData();
        return artists;
    }

    public static List<Album> getAlbums() {
        if (albums == null) initData();
        return albums;
    }

    public static List<Playlist> getPlaylists() {
        // Playlist do user tạo nên khởi tạo rỗng, không cần initData
        if (playlists == null) playlists = new ArrayList<>();
        return playlists;
    }

    // Thêm playlist mới do user tạo
    public static void addPlaylist(Playlist playlist) {
        if (playlists == null) playlists = new ArrayList<>();
        playlists.add(playlist);
    }

    private static void initData() {
        // Khởi tạo danh sách bài hát hard-code từ res/raw và res/drawable
        songs = new ArrayList<>();
        songs.add(new Song("Hoa Sứ Nhà Nàng", "Quốc Đại",
                "NhacCuaTui", R.raw.hoasunhanang, R.drawable.hoasunhanang));
        songs.add(new Song("Hương Tóc Mạ Non", "Đan Trường",
                "NhacCuaTui", R.raw.huongtocmanon, R.drawable.huongtocmanon));
        songs.add(new Song("Lại Nhớ Người Yêu", "Lưu Ánh Loan",
                "NhacCuaTui", R.raw.lainhonguoiyeu, R.drawable.lainhonguoiyeu));
        songs.add(new Song("Sầu Tím Thiệp Hồng", "Lưu Ánh Loan",
                "NhacCuaTui", R.raw.sautimthiephong, R.drawable.sautimthiephong));
        songs.add(new Song("Đừng Trách Câu Ví Dặm", "Cấp Anh Tài",
                "NhacCuaTui", R.raw.dungtrachcauvidam, R.drawable.dungtrachcauvidam));

        // Group songs theo Artist
        // LinkedHashMap giữ thứ tự insert, tránh đảo lộn danh sách
        artists = new ArrayList<>();
        Map<String, Artist> artistMap = new LinkedHashMap<>();
        for (Song song : songs) {
            if (!artistMap.containsKey(song.getArtist())) {
                artistMap.put(song.getArtist(), new Artist(song.getArtist()));
            }
            artistMap.get(song.getArtist()).addSong(song);
        }
        artists.addAll(artistMap.values());

        // Group songs theo Album
        albums = new ArrayList<>();
        Map<String, Album> albumMap = new LinkedHashMap<>();
        for (Song song : songs) {
            if (!albumMap.containsKey(song.getAlbum())) {
                albumMap.put(song.getAlbum(),
                        new Album(song.getAlbum(), song.getArtist(), song.getCoverArt()));
            }
            albumMap.get(song.getAlbum()).addSong(song);
        }
        albums.addAll(albumMap.values());
    }
}