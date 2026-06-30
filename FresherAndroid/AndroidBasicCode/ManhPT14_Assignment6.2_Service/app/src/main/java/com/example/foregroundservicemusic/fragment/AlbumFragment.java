package com.example.foregroundservicemusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.activity.PlayerActivity;
import com.example.foregroundservicemusic.adapter.AlbumAdapter;
import com.example.foregroundservicemusic.adapter.SongAdapter;
import com.example.foregroundservicemusic.data.DataProvider;
import com.example.foregroundservicemusic.model.Album;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        AlbumAdapter adapter = new AlbumAdapter(
                DataProvider.getAlbums(),
                // Click album → hiện BottomSheet list bài trong album
                album -> showSongListBottomSheet(album)
        );
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void showSongListBottomSheet(Album album) {
        BottomSheetDialog dialog = new BottomSheetDialog(requireContext());

        RecyclerView rv = new RecyclerView(requireContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setPadding(0, 8, 0, 48);
        rv.setClipToPadding(false);

        SongAdapter songAdapter = new SongAdapter(
                album.getSongs(),
                (song, position) -> {
                    dialog.dismiss();
                    Intent intent = new Intent(getContext(), PlayerActivity.class);
                    intent.putExtra("songs", new ArrayList<>(album.getSongs()));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
        );
        rv.setAdapter(songAdapter);
        dialog.setContentView(rv);
        dialog.show();
    }
}
