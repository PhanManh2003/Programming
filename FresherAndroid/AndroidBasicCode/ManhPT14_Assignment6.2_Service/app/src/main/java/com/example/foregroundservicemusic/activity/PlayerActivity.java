package com.example.foregroundservicemusic.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.model.Song;
import com.example.foregroundservicemusic.service.MusicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PlayerActivity extends AppCompatActivity {

    private MusicService musicService;
    private boolean isBound = false;
    private boolean userDragging = false;

    private ImageView imgCover;
    private TextView tvTitle, tvArtist, tvCurrentTime, tvTotalTime;
    private SeekBar seekBar;
    private ImageButton btnPrev, btnPlayPause, btnNext;

    private List<Song> songs;
    private int startPosition;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable updateSeekBar = new Runnable() {
        @Override
        public void run() {
            if (isBound && musicService != null) {
                int current = musicService.getCurrentPosition();
                int duration = musicService.getDuration();
                if (!userDragging && duration > 0) {
                    seekBar.setMax(duration);
                    seekBar.setProgress(current);
                    tvCurrentTime.setText(formatTime(current));
                    tvTotalTime.setText(formatTime(duration));
                }
                updatePlayPauseIcon();
                updateSongInfo();
            }
            handler.postDelayed(this, 500);
        }
    };

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            MusicService.MusicBinder musicBinder = (MusicService.MusicBinder) binder;
            musicService = musicBinder.getService();
            isBound = true;
            updateSongInfo();
            handler.post(updateSeekBar);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        bindViews();
        extractIntentData();
        startMusicService();
        bindMusicService();
        setupControls();
    }

    private void bindViews() {
        imgCover = findViewById(R.id.imgCover);
        tvTitle = findViewById(R.id.tvTitle);
        tvArtist = findViewById(R.id.tvArtist);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvTotalTime = findViewById(R.id.tvTotalTime);
        seekBar = findViewById(R.id.seekBar);
        btnPrev = findViewById(R.id.btnPrev);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnNext = findViewById(R.id.btnNext);
    }

    private void extractIntentData() {
        songs = (ArrayList<Song>) getIntent().getSerializableExtra("songs");
        startPosition = getIntent().getIntExtra("position", 0);
        if (songs == null) songs = new ArrayList<>();
    }

    private void startMusicService() {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("songs", new ArrayList<>(songs));
        intent.putExtra("position", startPosition);
        ContextCompat.startForegroundService(this, intent);
    }

    private void bindMusicService() {
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private void setupControls() {
        btnPrev.setOnClickListener(v -> {
            if (isBound) musicService.playPrev();
        });

        btnPlayPause.setOnClickListener(v -> {
            if (!isBound) return;
            if (musicService.isPlaying()) musicService.pause();
            else musicService.resume();
        });

        btnNext.setOnClickListener(v -> {
            if (isBound) musicService.playNext();
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) tvCurrentTime.setText(formatTime(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userDragging = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userDragging = false;
                if (isBound) musicService.seekTo(seekBar.getProgress());
            }
        });
    }

    private void updateSongInfo() {
        if (!isBound || musicService == null) return;
        Song song = musicService.getCurrentSong();
        if (song == null) return;
        tvTitle.setText(song.getTitle());
        tvArtist.setText(song.getArtist());
        imgCover.setImageResource(song.getCoverArt());
    }

    private void updatePlayPauseIcon() {
        if (!isBound || musicService == null) return;
        btnPlayPause.setImageResource(
                musicService.isPlaying()
                        ? android.R.drawable.ic_media_pause
                        : android.R.drawable.ic_media_play
        );
    }

    private String formatTime(int millis) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        return String.format(Locale.getDefault(), "%d:%02d", minutes, seconds);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateSeekBar);
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }
}
