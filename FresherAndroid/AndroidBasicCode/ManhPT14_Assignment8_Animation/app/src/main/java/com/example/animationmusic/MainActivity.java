package com.example.animationmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.animationmusic.fragment.FragmentA;
import com.example.animationmusic.model.Song;

public class MainActivity extends AppCompatActivity {

    // MediaPlayer sống ở MainActivity → không bị mất khi back
    private MediaPlayer mediaPlayer;
    private Song currentSong;
    private boolean isPlaying = false;

    // View MiniPlayer
    private CardView miniPlayer;
    private ImageView imgMiniCover;
    private TextView tvMiniTitle, tvMiniArtist;
    private ImageButton btnMiniPlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ MiniPlayer
        miniPlayer        = findViewById(R.id.miniPlayer);
        imgMiniCover      = findViewById(R.id.imgMiniCover);
        tvMiniTitle       = findViewById(R.id.tvMiniTitle);
        tvMiniArtist      = findViewById(R.id.tvMiniArtist);
        btnMiniPlayPause  = findViewById(R.id.btnMiniPlayPause);

        // Click MiniPlayer → mở lại FragmentB
        miniPlayer.setOnClickListener(v -> {
            if (currentSong != null) {
                navigateTo(
                        com.example.animationmusic.fragment.FragmentB
                                .newInstance(currentSong),
                        true
                );
            }
        });

        // Nút Play/Pause trên MiniPlayer
        btnMiniPlayPause.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    btnMiniPlayPause.setImageResource(
                            android.R.drawable.ic_media_play
                    );
                } else {
                    mediaPlayer.start();
                    btnMiniPlayPause.setImageResource(
                            android.R.drawable.ic_media_pause
                    );
                }
                isPlaying = !isPlaying;
            }
        });

        // Hiển thị FragmentA lúc đầu
        if (savedInstanceState == null) {
            navigateTo(new FragmentA(), false);
        }
    }

    /**
     * FragmentB gọi hàm này để bắt đầu phát nhạc
     * MediaPlayer sống ở MainActivity nên không bị mất khi back
     */
    public void playSong(Song song) {
        // Nếu đang phát bài khác thì dừng lại
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        currentSong = song;

        // Tạo MediaPlayer mới
        mediaPlayer = MediaPlayer.create(this, song.getAudioRes());
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        isPlaying = true;

        // Hiển thị MiniPlayer
        showMiniPlayer(song);
    }

    /**
     * Hiển thị MiniPlayer với thông tin bài hát
     */
    public void showMiniPlayer(Song song) {
        miniPlayer.setVisibility(View.VISIBLE);
        imgMiniCover.setImageResource(song.getCoverImageRes());
        tvMiniTitle.setText(song.getTitle());
        tvMiniArtist.setText(song.getArtist());
        btnMiniPlayPause.setImageResource(android.R.drawable.ic_media_pause);
    }

    /**
     * Lấy MediaPlayer hiện tại để FragmentB dùng
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    /**
     * Điều hướng Fragment
     */
    public void navigateTo(Fragment fragment, boolean addToBack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment);

        if (addToBack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Giải phóng khi thoát app hoàn toàn
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}