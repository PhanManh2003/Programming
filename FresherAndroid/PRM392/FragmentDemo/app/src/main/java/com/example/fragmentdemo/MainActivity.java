package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragManager;
    FragmentTransaction frag_trans;
    FragmentA fragA;
    FragmentB fragB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ((Button) findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_remove)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_replace)).setOnClickListener(this);

        fragManager = getSupportFragmentManager();
        fragA = FragmentA.newInstance(null, null);
        fragB = FragmentB.newInstance(null, null);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add) {
            frag_trans = fragManager.beginTransaction();
            frag_trans.add(R.id.ln_container, fragA, "");
            frag_trans.commit();
        } else if (v.getId() == R.id.btn_replace) {
            frag_trans = fragManager.beginTransaction();
            frag_trans.replace(R.id.ln_container, fragB, "");
            frag_trans.commit();

        } else if (v.getId() == R.id.btn_remove) {
            frag_trans = fragManager.beginTransaction();
            frag_trans.remove(fragB);
            frag_trans.commit();

        }

    }

    public void gotoFragB(String data, int font_size) {
        fragB = FragmentB.newInstance(data, String.valueOf(font_size));
        frag_trans = fragManager.beginTransaction();
        frag_trans.replace(R.id.ln_container, fragB, "");
        frag_trans.commit();
    }
}