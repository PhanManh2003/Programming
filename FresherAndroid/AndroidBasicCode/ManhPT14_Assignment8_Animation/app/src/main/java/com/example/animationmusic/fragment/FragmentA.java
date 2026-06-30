package com.example.animationmusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationmusic.MainActivity;
import com.example.animationmusic.R;
import com.example.animationmusic.adapter.SongAdapter;
import com.example.animationmusic.model.Song;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {

    // Constructor rỗng - bắt buộc phải có
    public FragmentA() {}

    // Không cần newInstance vì không có data truyền vào

    // Chỉ inflate layout
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    // Logic ở đây
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SongAdapter adapter = new SongAdapter(getSampleSongs(), song -> {
            //  Truyền thẳng object Song
            FragmentB fragmentB = FragmentB.newInstance(song);
            ((MainActivity) requireActivity()).navigateTo(fragmentB, true);
        });

        recyclerView.setAdapter(adapter);
    }

    // tạo sẵn data song
    private List<Song> getSampleSongs() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("Đừng Trách Cẩm Đam",   "Various Artists", R.drawable.dungtrachcauvidam,      R.raw.dungtrachcauvidam));
        songs.add(new Song("Bèo Dạt Mây Trôi",      "Various Artists", R.drawable.beodatmaytroi,          R.raw.beodatmaytroi));
        songs.add(new Song("Biết Tình",              "Various Artists", R.drawable.bientinh,               R.raw.bientinh));
        songs.add(new Song("Chuyện Tình Người Đan Áo","Various Artists",R.drawable.chuyentinhnguoidanao,   R.raw.chuyentinhnguoidanao));
        songs.add(new Song("Đường Tình Đôi Ngả",     "Various Artists", R.drawable.duongtinhdoinga,        R.raw.duongtinhdoinga));
        songs.add(new Song("Gói Đó",                 "Various Artists", R.drawable.goido,                  R.raw.goido));
        songs.add(new Song("Hay Quên Anh",           "Various Artists", R.drawable.hayquenanh,             R.raw.hayquenanh));
        songs.add(new Song("Hoa Sưng Hà Nắng",       "Various Artists", R.drawable.hoasunhanang,           R.raw.hoasunhanang));
        songs.add(new Song("Hương Tóc Mạ Non",       "Various Artists", R.drawable.huongtocmanon,          R.raw.huongtocmanon));
        songs.add(new Song("Kiếp Ve Sầu",            "Various Artists", R.drawable.kiepvesau,              R.raw.keipvesau));
        songs.add(new Song("Lại Hỏi Người Yêu",      "Various Artists", R.drawable.lainhonguoiyeu,         R.raw.lainhonguoiyeu));
        songs.add(new Song("Sầu Tím Thiệp Hồng",     "Various Artists", R.drawable.sautimthiephong,        R.raw.sautimthiephong));

        return songs;
    }
}
