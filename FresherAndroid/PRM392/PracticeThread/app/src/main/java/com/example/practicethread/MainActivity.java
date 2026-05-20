package com.example.practicethread;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PersonAdapter adapter;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_person);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dùng ExecutorService để chạy background thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String urlStr = "https://reqres.in/api/users?page=2";
                URL url = new URL(urlStr);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                InputStream inputstream = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(inputstream));
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    text.append(line);
                }

                JSONObject obj = new JSONObject(text.toString());
                JSONArray dataArray = obj.getJSONArray("data");

                // Parse JSON sang mảng Person bằng Gson
                Gson gson = new Gson();
                Person[] list = gson.fromJson(dataArray.toString(), Person[].class);
                personList = Arrays.asList(list);

                Log.i("DATA", "Loaded " + personList.size() + " users");

                // Cập nhật UI (phải chạy trên MainThread)
                runOnUiThread(() -> {
                    adapter = new PersonAdapter(MainActivity.this, personList);
                    recyclerView.setAdapter(adapter);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}