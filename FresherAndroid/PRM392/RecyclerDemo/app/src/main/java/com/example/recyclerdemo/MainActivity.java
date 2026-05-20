package com.example.recyclerdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chapter c1 = new Chapter("Chapter 1", "Android Architechture", R.drawable.android_image_1);
        Chapter c2 = new Chapter("Chapter 2", "Android Layout", R.drawable.android_image_2);
        Chapter c3 = new Chapter("Chapter 3", "Android Activity", R.drawable.android_image_3);
        Chapter c4 = new Chapter("Chapter 4", "Android Style & theme", R.drawable.android_image_4);
        Chapter c5 = new Chapter("Chapter 5", "Android RecyclerView", R.drawable.android_image_5);
        Chapter c6 = new Chapter("Chapter 6", "Android HEhee", R.drawable.android_image_6);
        Chapter c7 = new Chapter("Chapter 7", "Android Abcdaf", R.drawable.android_image_7);
        Chapter c8 = new Chapter("Chapter 8", "Android esagerahb", R.drawable.android_image_8);

        List<Chapter> chaps = new ArrayList<>();

        chaps.add(c1);
        chaps.add(c2);
        chaps.add(c3);
        chaps.add(c4);
        chaps.add(c5);
        chaps.add(c6);
        chaps.add(c7);
        chaps.add(c8);

        ChapterAdapter adapter = new ChapterAdapter(chaps);
        RecyclerView rec = findViewById(R.id.rec_chapter);
        rec.setLayoutManager(new LinearLayoutManager(this));
//        rec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rec.setAdapter(adapter);
    }
}