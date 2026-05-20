package com.example.retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recy_post);
        adapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Tao API
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        // Gọi API

        apiService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    List<Post> posts = response.body();

                    // In ra tổng số phần tử để kiểm tra
                    Log.d("API_RESPONSE", "Số lượng post nhận được: " + posts.size());

                    // Duyệt qua tất cả phần tử và in ra logcat
                    for (Post post : posts) {
                        Log.d("API_RESPONSE",
                                "ID: " + post.getId() + "\n" +
                                        "Title: " + post.getTitle() + "\n" +
                                        "Body: " + post.getBody() + "\n" +
                                        "-----------------------");
                    }

                    // Nếu không muốn hiển thị recycler nữa thì bỏ adapter

                     adapter.setPosts(posts);

                } else {
                    Log.e("API_RESPONSE", "Response không hợp lệ hoặc null");
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi kết nối: " + t.getMessage());
            }
        });

    }
}