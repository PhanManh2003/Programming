package com.example.bai2_intentsenddata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;


public class ActivityA extends AppCompatActivity {

    private Button btnGoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_a);

        // Tạo list
        ArrayList<String> greetings = new ArrayList<>(Arrays.asList(
                "Hello!", "Hi!", "Salut!", "Hallo!", "Ciao!",
                "Ahoj!", "YAH sahs!", "Bog!", "Hej!", "Czesc!",
                "Ní hảo!", "Kon'nichiwa!", "Annyeonghaseyo!", "Shalom!",
                "Sah-wahd-dee-kah!", "Merhaba!", "Hujambo!", "Olá!"
        ));


        // Gửi list sang B thông qua button
        btnGoB = findViewById(R.id.btnGoToB);
        btnGoB.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityB.class);
            intent.putStringArrayListExtra("greetings", greetings);
            startActivity(intent);
        });
    }

}
