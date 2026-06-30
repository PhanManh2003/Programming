package com.example.animationmusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationmusic.R;
import com.example.animationmusic.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songs;
    private int lastPosition = -1; // Vị trí item cuối cùng đã hiển thị

    // Interface để xử lý sự kiện click từ Fragment
    public interface OnSongClickListener {
        void onSongClick(Song song);
    }

    private OnSongClickListener listener;

    public SongAdapter(List<Song> songs, OnSongClickListener listener) {
        this.songs = songs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout item_song.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song song = songs.get(position);

        // Gán data vào view
        holder.tvTitle.setText(song.getTitle());
        holder.tvSubtitle.setText(song.getArtist());
        holder.imgCover.setImageResource(song.getCoverImageRes());

        // Xử lý click vào item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSongClick(song);
            }
        });

        // Gọi animation khi scroll
        setScrollAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    // -------- ViewHolder --------
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView tvTitle, tvSubtitle;

        public ViewHolder(View view) {
            super(view);
            imgCover = view.findViewById(R.id.imgCover);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvSubtitle = view.findViewById(R.id.tvSubtitle);
        }
    }

    /**
     * Animation khi scroll RecyclerView
     * Scroll lên  → item bay từ dưới lên + fade in  (ass  2)
     * Scroll xuống → item bay từ trên xuống + fade in
     */
    private void setScrollAnimation(View view, int position) {
        if (position > lastPosition) {
            // Scroll UP: item xuất hiện từ phía dưới
            view.setTranslationY(150f);
            view.setAlpha(0f);

            // dùng ViewPropertyAnimator
            view.animate()
                    .translationY(0f)   // trượt về vị trí thật
                    .alpha(1f)          // hiện dần
                    .setDuration(400)
                    .setInterpolator(new DecelerateInterpolator())
                    .start();
        } else {
            // Scroll DOWN: item xuất hiện từ phía trên
            view.setTranslationY(-150f);
            view.setAlpha(0f);

            view.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setDuration(400)
                    .setInterpolator(new DecelerateInterpolator())
                    .start();
        }

        // Cập nhật vị trí cuối cùng
        lastPosition = position;
    }


}
