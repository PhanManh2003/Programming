# Activities / Fragments
MainActivity.java          ← chứa bottom tab: Playlists, Artists, Albums
PlayerActivity.java        ← màn hình phát nhạc (ảnh 1 bên trái)

# Fragments (tab trong MainActivity)
PlaylistFragment.java      ← tab Playlists
ArtistFragment.java        ← tab Artists  
AlbumFragment.java         ← tab Albums

# Service
MusicService.java          ← Foreground Service, phát nhạc khi app đóng

# Receiver
MusicReceiver.java         ← xử lý nút Prev/Pause/Next từ notification

# Model
Song.java                  ← title, artist, album, uri, albumArt
Artist.java                ← name, list songs
Album.java                 ← name, artist, list songs
Playlist.java              ← name, list songs

# Adapter
SongAdapter.java           ← hiển thị list bài hát
ArtistAdapter.java
AlbumAdapter.java
PlaylistAdapter.java

# Mối quan hệ giữa các file
MainActivity
├── PlaylistFragment ──► PlaylistAdapter
│                              │ click vào playlist
│                              ▼
│                         SongAdapter (list bài trong playlist)
│                              │
├── ArtistFragment  ──► ArtistAdapter
│                              │ click vào artist
│                              ▼
│                         SongAdapter (list bài của artist)
│                              │
└── AlbumFragment   ──► AlbumAdapter
        │ click vào album
        ▼
   SongAdapter (list bài trong album)
        │ click vào 1 bài hát cụ thể
        ▼
    PlayerActivity
        │ startService / bindService
        ▼
    MusicService (Foreground)
        │ show notification
        ▼
    MusicReceiver ──► Prev/Pause/Next/Close

## XML cần tạo
# Layout (res/layout/)
activity_main.xml          ← ViewPager2 + BottomNavigationView
activity_player.xml        ← Player screen (ảnh 1 bên trái)
fragment_playlist.xml      ← RecyclerView + nút "Create new playlist"
fragment_artist.xml        ← RecyclerView
fragment_album.xml         ← RecyclerView
item_song.xml              ← 1 item bài hát trong list
item_artist.xml            ← 1 item artist
item_album.xml             ← 1 item album
item_playlist.xml          ← 1 item playlist

 

# Notification layout (res/layout/)
notification_collapsed.xml ← layout notification nhỏ (tái sử dụng từ bài trước)
notification_expanded.xml  ← layout notification mở rộng