package com.example.foregroundservicemusic.service;

import android.app.Service;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.model.Song;
import com.example.foregroundservicemusic.receiver.MusicReceiver;

import java.util.ArrayList;
import java.util.List;

public class MusicService extends Service {
    // Channel ID — phải khớp với channel đã tạo trong MainActivity
    public static final String CHANNEL_ID = "music_channel";
    public static final int NOTIF_ID = 1;

    // MediaPlayer phát nhạc
    private MediaPlayer mediaPlayer;

    // Danh sách bài và vị trí hiện tại
    private List<Song> songs = new ArrayList<>();
    private int currentIndex = 0;

    // Binder để Activity bind vào Service
    private final IBinder binder = new MusicBinder();

    // MusicBinder cung cấp reference đến MusicService
    // cho Activity bind vào để gọi các method điều khiển
    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            // Xử lý lệnh từ MusicReceiver (nút notification)
            String command = intent.getStringExtra("command");
            if (command != null) {
                switch (command) {
                    case "prev":   playPrev(); break;
                    case "next":   playNext(); break;
                    case "toggle":
                        if (isPlaying()) pause();
                        else resume();
                        break;
                }
                return START_NOT_STICKY;
            }

            // Nhận list bài và vị trí từ PlayerActivity
            ArrayList<Song> songList = (ArrayList<Song>)
                    intent.getSerializableExtra("songs");
            int position = intent.getIntExtra("position", 0);

            if (songList != null && !songList.isEmpty()) {
                songs = songList;
                currentIndex = position;
                playCurrent();
            }
        }
        // START_NOT_STICKY: không tự restart khi bị kill
        return START_NOT_STICKY;
    }

    // Phát bài hát hiện tại theo currentIndex
    private void playCurrent() {
        // Giải phóng MediaPlayer cũ nếu có
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        Song song = songs.get(currentIndex);

        // Tạo MediaPlayer từ resource trong res/raw
        mediaPlayer = MediaPlayer.create(this, song.getResourceId());
        mediaPlayer.start();

        // Khi phát xong → tự chuyển bài tiếp theo
        mediaPlayer.setOnCompletionListener(mp -> playNext());

        // Hiện Foreground Notification (API 29+ cần truyền foregroundServiceType)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            startForeground(NOTIF_ID, buildNotification(),
                    android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK);
        } else {
            startForeground(NOTIF_ID, buildNotification());
        }
    }

    // Build notification với RemoteViews
    private Notification buildNotification() {
        Song song = songs.get(currentIndex);

        // Collapsed view
        RemoteViews collapsed = new RemoteViews(
                getPackageName(), R.layout.notification_collapsed);
        collapsed.setTextViewText(R.id.tv_song_title, song.getTitle());
        collapsed.setTextViewText(R.id.tv_artist, song.getArtist());
        collapsed.setImageViewResource(R.id.iv_album_art, song.getCoverArt());
        collapsed.setOnClickPendingIntent(R.id.btn_prev,
                makePendingIntent(MusicReceiver.ACTION_PREV));
        collapsed.setOnClickPendingIntent(R.id.btn_play_pause,
                makePendingIntent(MusicReceiver.ACTION_PAUSE));
        collapsed.setOnClickPendingIntent(R.id.btn_next,
                makePendingIntent(MusicReceiver.ACTION_NEXT));
        collapsed.setOnClickPendingIntent(R.id.btn_close,
                makePendingIntent(MusicReceiver.ACTION_CLOSE));

        // Expanded view
        RemoteViews expanded = new RemoteViews(
                getPackageName(), R.layout.notification_expanded);

        expanded.setTextViewText(R.id.tv_song_title_exp, song.getTitle());
        expanded.setTextViewText(R.id.tv_artist_exp, song.getArtist());
        expanded.setImageViewResource(R.id.iv_album_art_exp, song.getCoverArt());

        expanded.setOnClickPendingIntent(R.id.btn_prev_exp,
                makePendingIntent(MusicReceiver.ACTION_PREV));
        expanded.setOnClickPendingIntent(R.id.btn_play_pause_exp,
                makePendingIntent(MusicReceiver.ACTION_PAUSE));
        expanded.setOnClickPendingIntent(R.id.btn_next_exp,
                makePendingIntent(MusicReceiver.ACTION_NEXT));
        expanded.setOnClickPendingIntent(R.id.btn_close_exp,
                makePendingIntent(MusicReceiver.ACTION_CLOSE));

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setCustomContentView(collapsed)
                .setCustomBigContentView(expanded)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)  // Không swipe để dismiss
                .build();
    }

    // Tạo PendingIntent gửi broadcast đến MusicReceiver
    private android.app.PendingIntent makePendingIntent(String action) {
        Intent intent = new Intent(action);
        intent.setPackage(getPackageName());
        return android.app.PendingIntent.getBroadcast(
                this, action.hashCode(), intent,
                android.app.PendingIntent.FLAG_UPDATE_CURRENT |
                        android.app.PendingIntent.FLAG_IMMUTABLE);
    }

    // Cập nhật notification khi đổi bài hoặc play/pause
    private void updateNotification() {
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != android.content.pm.PackageManager.PERMISSION_GRANTED) return;
        }
        NotificationManagerCompat.from(this)
                .notify(NOTIF_ID, buildNotification());
    }

    // ==================== Public methods cho Activity ====================

    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            updateNotification();
        }
    }

    public void resume() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            updateNotification();
        }
    }

    public void playNext() {
        // Vòng lại bài đầu nếu đang ở bài cuối
        currentIndex = (currentIndex + 1) % songs.size();
        playCurrent();
    }

    public void playPrev() {
        // Về bài cuối nếu đang ở bài đầu
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
        playCurrent();
    }

    public void seekTo(int position) {
        if (mediaPlayer != null) mediaPlayer.seekTo(position);
    }

    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public int getCurrentPosition() {
        return mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return mediaPlayer != null ? mediaPlayer.getDuration() : 0;
    }

    public Song getCurrentSong() {
        if (songs.isEmpty()) return null;
        return songs.get(currentIndex);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Giải phóng MediaPlayer khi service bị destroy
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
