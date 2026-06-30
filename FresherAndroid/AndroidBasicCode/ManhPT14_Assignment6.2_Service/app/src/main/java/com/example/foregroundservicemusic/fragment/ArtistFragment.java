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
import com.example.foregroundservicemusic.adapter.ArtistAdapter;
import com.example.foregroundservicemusic.adapter.SongAdapter;
import com.example.foregroundservicemusic.data.DataProvider;
import com.example.foregroundservicemusic.model.Artist;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ArtistFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArtistAdapter adapter = new ArtistAdapter(
                DataProvider.getArtists(),
                // Click artist → hiện BottomSheet list bài của artist
                artist -> showSongListBottomSheet(artist)
        );
        recyclerView.setAdapter(adapter);
        return view;
    }

    // Hiện BottomSheet chứa SongAdapter — list bài của artist
    private void showSongListBottomSheet(Artist artist) {
        BottomSheetDialog dialog = new BottomSheetDialog(requireContext());

        // Tạo RecyclerView trực tiếp — tránh inflate layout có height=match_parent
        // (inflate null parent khiến ConstraintLayout height=0, BottomSheet trống)
        RecyclerView rv = new RecyclerView(requireContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setPadding(0, 8, 0, 48);
        rv.setClipToPadding(false);

        SongAdapter songAdapter = new SongAdapter(
                artist.getSongs(),
                (song, position) -> {
                    dialog.dismiss();
                    Intent intent = new Intent(getContext(), PlayerActivity.class);
                    intent.putExtra("songs", new ArrayList<>(artist.getSongs()));
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
        );
        rv.setAdapter(songAdapter);
        dialog.setContentView(rv);
        dialog.show();
    }

}
