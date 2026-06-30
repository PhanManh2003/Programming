package com.example.fragmentsinger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsinger.adapter.SongAdapter;
import com.example.fragmentsinger.data.DataRepository;
import com.example.fragmentsinger.model.Singer;
import com.example.fragmentsinger.viewmodel.SingerViewModel;

public class SongListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SingerViewModel viewModel = new ViewModelProvider(requireActivity())
                .get(SingerViewModel.class);

        TextView tvTitle = view.findViewById(R.id.tv_song_list_title);
        RecyclerView recyclerView = view.findViewById(R.id.rv_songs);
        ImageButton btnBack = view.findViewById(R.id.btn_back);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        Singer selectedSinger = viewModel.getSelectedSinger().getValue();
        if (selectedSinger != null) {
            tvTitle.setText("List Song of " + selectedSinger.getName());
            recyclerView.setAdapter(
                    new SongAdapter(DataRepository.getSongsForSinger(selectedSinger.getName())));
        }

        btnBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack());
    }
}
