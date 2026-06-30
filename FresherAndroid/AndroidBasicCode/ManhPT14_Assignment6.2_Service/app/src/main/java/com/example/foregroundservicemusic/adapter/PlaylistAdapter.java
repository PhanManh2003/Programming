package com.example.foregroundservicemusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.model.Playlist;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    public interface OnPlaylistClickListener {
        void onPlaylistClick(Playlist playlist);
    }

    private List<Playlist> playlists;
    private OnPlaylistClickListener listener;

    public PlaylistAdapter(List<Playlist> playlists, OnPlaylistClickListener listener) {
        this.playlists = playlists;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        holder.tvPlaylistName.setText(playlist.getName());
        holder.tvSongCount.setText(playlist.getSongCount() + " bài hát");

        // Nếu playlist có bài → hiện ảnh bìa bài đầu tiên
        // Nếu rỗng → hiện icon mặc định
        if (playlist.getCoverArt() != 0) {
            holder.imgPlaylist.setImageResource(playlist.getCoverArt());
        } else {
            holder.imgPlaylist.setImageResource(android.R.drawable.ic_menu_agenda);
        }

        holder.itemView.setOnClickListener(v ->
                listener.onPlaylistClick(playlist));
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    // Thêm playlist mới và refresh RecyclerView
    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
        notifyItemInserted(playlists.size() - 1);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlaylist;
        TextView tvPlaylistName, tvSongCount;

        ViewHolder(View itemView) {
            super(itemView);
            imgPlaylist = itemView.findViewById(R.id.imgPlaylist);
            tvPlaylistName = itemView.findViewById(R.id.tvPlaylistName);
            tvSongCount = itemView.findViewById(R.id.tvSongCount);
        }
    }

}
