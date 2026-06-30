package com.example.fragmentsinger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsinger.adapter.SingerAdapter;
import com.example.fragmentsinger.data.DataRepository;
import com.example.fragmentsinger.viewmodel.SingerViewModel;

public class SingerListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singer_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SingerViewModel viewModel = new ViewModelProvider(requireActivity())
                .get(SingerViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.rv_singers);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        SingerAdapter adapter = new SingerAdapter(DataRepository.getSingers(), singer -> {
            viewModel.selectSinger(singer);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left,
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                    )
                    .replace(R.id.fragment_container, new SongListFragment())
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setAdapter(adapter);
    }
}
