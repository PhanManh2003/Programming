package com.example.foregroundservicemusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundservicemusic.R;
import com.example.foregroundservicemusic.activity.PlayerActivity;
import com.example.foregroundservicemusic.adapter.PlaylistAdapter;
import com.example.foregroundservicemusic.adapter.SongAdapter;
import com.example.foregroundservicemusic.data.DataProvider;
import com.example.foregroundservicemusic.model.Playlist;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class PlaylistFragment extends Fragment {

        private PlaylistAdapter adapter;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_playlist, container, false);

            // Setup RecyclerView hiển thị danh sách playlist
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            adapter = new PlaylistAdapter(
                    DataProvider.getPlaylists(),
                    playlist -> {
                        // Click vào playlist rỗng → thông báo
                        if (playlist.getSongCount() == 0) {
                            Toast.makeText(getContext(),
                                    "Playlist trống!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // Click vào playlist có bài → hiện BottomSheet list bài
                        showSongListBottomSheet(playlist);
                    }
            );
            recyclerView.setAdapter(adapter);

            // Nút tạo playlist mới → hiện dialog nhập tên
            view.findViewById(R.id.btnCreatePlaylist).setOnClickListener(v ->
                    showCreatePlaylistDialog());

            return view;
        }

        // Dialog nhập tên để tạo playlist mới
        private void showCreatePlaylistDialog() {
            // Tạo EditText để user nhập tên playlist
            EditText editText = new EditText(getContext());
            editText.setHint("Tên playlist");

            new android.app.AlertDialog.Builder(getContext())
                    .setTitle("Tạo playlist mới")
                    .setView(editText)
                    .setPositiveButton("Tạo", (dialog, which) -> {
                        String name = editText.getText().toString().trim();

                        // Validate tên không được rỗng
                        if (name.isEmpty()) {
                            Toast.makeText(getContext(),
                                    "Tên không được để trống!",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // adapter.addPlaylist thêm vào list (cùng reference với DataProvider)
                        // và gọi notifyItemInserted — không cần gọi DataProvider.addPlaylist riêng
                        Playlist newPlaylist = new Playlist(name);
                        adapter.addPlaylist(newPlaylist);

                        Toast.makeText(getContext(),
                                "Đã tạo: " + name, Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Huỷ", null)
                    .show();
        }

        // BottomSheet hiển thị SongAdapter — list bài trong playlist
        private void showSongListBottomSheet(Playlist playlist) {
            BottomSheetDialog dialog = new BottomSheetDialog(requireContext());

            RecyclerView rv = new RecyclerView(requireContext());
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.setPadding(0, 8, 0, 48);
            rv.setClipToPadding(false);

            SongAdapter songAdapter = new SongAdapter(
                    playlist.getSongs(),
                    (song, position) -> {
                        dialog.dismiss();
                        Intent intent = new Intent(getContext(), PlayerActivity.class);
                        intent.putExtra("songs", new ArrayList<>(playlist.getSongs()));
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
            );
            rv.setAdapter(songAdapter);
            dialog.setContentView(rv);
            dialog.show();
        }
    }

