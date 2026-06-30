package com.example.animationmusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Handler;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import com.example.animationmusic.MainActivity;
import com.example.animationmusic.R;
import com.example.animationmusic.model.Song;

public class FragmentB extends Fragment {
    // ===== 1. Key cho Bundle =====
    private static final String ARG_SONG = "song";

    // ===== 2. Biến lưu data =====
    private Song mSong;

    // ===== 3. Khai báo View =====
    private ImageView imgCover;
    private TextView tvTitle, tvArtist, tvCurrentTime, tvTotalTime;
    private SeekBar seekBarProgress, seekBarVolume;
    private ImageButton btnBack, btnPlayPause, btnPrevious, btnNext;

    // ===== 4. Animation & Media =====
    private Animation rotateAnim;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private Handler handler = new Handler();
    private boolean isPlaying = true;

    // ===== 5. Constructor rỗng - BẮT BUỘC =====
    public FragmentB() {
    }

    // ===== 6. newInstance - cách DUY NHẤT tạo FragmentB =====
    public static FragmentB newInstance(Song song) {
        FragmentB fragment = new FragmentB();

        // Đóng gói Song vào Bundle
        Bundle args = new Bundle();
        args.putSerializable(ARG_SONG, song);

        fragment.setArguments(args);
        return fragment;
    }

    // ===== 7. Lấy data từ Bundle =====
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Lấy object Song từ Bundle
            mSong = (Song) getArguments().getSerializable(ARG_SONG);
        }
    }

    // ===== 8. Chỉ inflate layout =====
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    // ===== 9. findViewById + logic =====
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // findViewById
        imgCover = view.findViewById(R.id.imgCover);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvArtist = view.findViewById(R.id.tvArtist);
        tvCurrentTime = view.findViewById(R.id.tvCurrentTime);
        tvTotalTime = view.findViewById(R.id.tvTotalTime);
        seekBarProgress = view.findViewById(R.id.seekBarProgress);
        seekBarVolume = view.findViewById(R.id.seekBarVolume);
        btnBack = view.findViewById(R.id.btnBack);
        btnPlayPause = view.findViewById(R.id.btnPlayPause);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        btnNext = view.findViewById(R.id.btnNext);

        // Set data lên UI từ mSong
        tvTitle.setText(mSong.getTitle());
        tvArtist.setText(mSong.getArtist());
        imgCover.setImageResource(mSong.getCoverImageRes());

        // Setup từng phần
        setupRotateAnimation();
        setupMediaPlayer();
        setupSeekBarProgress();
        setupSeekBarVolume();
        setupButtons();
    }

    /**
     * Load và bắt đầu animation xoay ảnh bìa
     * Assignment 1: View Animation
     */
    private void setupRotateAnimation() {
        rotateAnim = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
        imgCover.startAnimation(rotateAnim);
    }

    /**
     * Khởi tạo MediaPlayer và phát nhạc
     */
    private void setupMediaPlayer() {
        MainActivity activity = (MainActivity) requireActivity();

        // Gọi MainActivity phát nhạc
        activity.playSong(mSong);

        // Lấy MediaPlayer từ MainActivity để dùng
        mediaPlayer = activity.getMediaPlayer();
        isPlaying = true;

        // Hiển thị tổng thời gian
        tvTotalTime.setText(formatTime(mediaPlayer.getDuration()));

        // Cập nhật SeekBar
        updateSeekBar();
    }

    /**
     * Cập nhật SeekBar mỗi 500ms
     */
    private void updateSeekBar() {
        seekBarProgress.setMax(mediaPlayer.getDuration());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBarProgress.setProgress(mediaPlayer.getCurrentPosition());
                    tvCurrentTime.setText(formatTime(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 500);
                }
            }
        };

        handler.post(runnable);
    }

    /**
     * SeekBar tiến trình — cho phép tua nhạc
     */
    private void setupSeekBarProgress() {
        seekBarProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    tvCurrentTime.setText(formatTime(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /**
     * SeekBar âm lượng
     */
    private void setupSeekBarVolume() {
        audioManager = (AudioManager) requireContext()
                .getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax(maxVolume);
        seekBarVolume.setProgress(currentVolume);

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    audioManager.setStreamVolume(
                            AudioManager.STREAM_MUSIC, progress, 0
                    );
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /**
     * Các nút điều khiển
     */
    private void setupButtons() {

        // Nút Back → về FragmentA
        btnBack.setOnClickListener(v ->
                requireActivity().onBackPressed()
        );

        //   nút Play/Pause — đồng bộ với MainActivity
        btnPlayPause.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) requireActivity();

            if (isPlaying) {
                mediaPlayer.pause();
                imgCover.clearAnimation();
                btnPlayPause.setImageResource(android.R.drawable.ic_media_play);
                // Cập nhật nút MiniPlayer
                activity.setPlaying(false);
            } else {
                mediaPlayer.start();
                imgCover.startAnimation(rotateAnim);
                btnPlayPause.setImageResource(android.R.drawable.ic_media_pause);
                activity.setPlaying(true);
            }
            isPlaying = !isPlaying;
        });

        // Nút Previous → về đầu bài
        btnPrevious.setOnClickListener(v -> {
            mediaPlayer.seekTo(0);
            seekBarProgress.setProgress(0);
            tvCurrentTime.setText("00:00");
        });

        // Nút Next → tua đến gần cuối
        btnNext.setOnClickListener(v ->
                mediaPlayer.seekTo(mediaPlayer.getDuration() - 1000)
        );
    }

    /**
     * Chuyển millisecond → "mm:ss"
     * Ví dụ: 65000 → "01:05"
     */
    private String formatTime(int milliseconds) {
        int seconds = (milliseconds / 1000) % 60;
        int minutes = (milliseconds / 1000) / 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    // ===== 10. Giải phóng tài nguyên =====

    // Sửa onDestroyView — KHÔNG release MediaPlayer nữa
// vì MediaPlayer sống ở MainActivity
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Chỉ dừng handler, KHÔNG release mediaPlayer
        handler.removeCallbacksAndMessages(null);
        mediaPlayer = null; // chỉ bỏ tham chiếu, không release
    }
}
