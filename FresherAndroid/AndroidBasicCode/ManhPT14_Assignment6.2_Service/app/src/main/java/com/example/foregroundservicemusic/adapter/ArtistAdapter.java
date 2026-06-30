package com.example.foregroundservicemusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.model.Artist;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    public interface OnArtistClickListener {
        void onArtistClick(Artist artist);
    }

    private List<Artist> artists;
    private OnArtistClickListener listener;

    public ArtistAdapter(List<Artist> artists, OnArtistClickListener listener) {
        this.artists = artists;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.tvArtistName.setText(artist.getName());
        // Hiện số bài hát của nghệ sĩ
        holder.tvSongCount.setText(artist.getSongCount() + " bài hát");
        // Dùng ảnh bìa bài đầu tiên làm avatar nghệ sĩ
        holder.imgArtist.setImageResource(artist.getCoverArt());

        holder.itemView.setOnClickListener(v ->
                listener.onArtistClick(artist));
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgArtist;
        TextView tvArtistName, tvSongCount;

        ViewHolder(View itemView) {
            super(itemView);
            imgArtist = itemView.findViewById(R.id.imgArtist);
            tvArtistName = itemView.findViewById(R.id.tvArtistName);
            tvSongCount = itemView.findViewById(R.id.tvSongCount);
        }
    }
}
