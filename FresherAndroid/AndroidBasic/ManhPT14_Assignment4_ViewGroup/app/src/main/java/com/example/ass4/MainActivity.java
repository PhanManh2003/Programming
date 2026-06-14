package com.example.ass4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass4.adapter.BookAdapter;
import com.example.ass4.data.MockData;
import com.example.ass4.model.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BookAdapter adapter;
    private ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // lấy các view từ xml main
        RecyclerView recyclerView = findViewById(R.id.recy_book);
        SearchView searchView = findViewById(R.id.searchView);
        Button btnSortTitle = findViewById(R.id.btnSortTitle);
        Button btnSortAuthor = findViewById(R.id.btnSortAuthor);


        // lấy danh sách book
        bookList = MockData.getBooks();

        // Tạo adapter, gán adapter vào recycler view và setlayout manager cho recycler view
        adapter  = new BookAdapter(this, bookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    //  Search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String query) {
                adapter.filter(query);
                return true;
            }
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }
        });

    //  Sort
        btnSortTitle.setOnClickListener(v  -> adapter.sort("title"));
        btnSortAuthor.setOnClickListener(v -> adapter.sort("author"));
    }
}