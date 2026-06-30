package com.example.ass4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        String title    = getIntent().getStringExtra("title");
        String author   = getIntent().getStringExtra("author");
        int  imageRes = getIntent().getIntExtra("imageRes", 0);

        ((TextView)  findViewById(R.id.tvDetailTitle)).setText("Titlte: " + title);
        ((TextView)  findViewById(R.id.tvDetailAuthor)).setText("Author: " + author);
        // ko dc dùng setImageResource vì sẽ ko khớp với bên kia dùng setBackgroundResource
        ((ImageView) findViewById(R.id.imgDetail)).setBackgroundResource(imageRes);
    }
}