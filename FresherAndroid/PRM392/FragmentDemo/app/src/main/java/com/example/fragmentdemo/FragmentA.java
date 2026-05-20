package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args); // Gắn dữ liệu cho fragment khi khởi tạo
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b = view.findViewById(R.id.btn_goto);
        EditText edt_data = view.findViewById(R.id.editTextText);
        SeekBar sb = view.findViewById(R.id.seekBar);
        SeekBar seekR = view.findViewById(R.id.seekBarRed);
        SeekBar seekG = view.findViewById(R.id.seekBarGreen);
        SeekBar seekB = view.findViewById(R.id.seekBarBlue);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt_data.getText().toString();
                int font_size = sb.getProgress();
                int r = seekR.getProgress();
                int g = seekG.getProgress();
                int b = seekB.getProgress();
//                ((MainActivity) getActivity()).gotoFragB(data, font_size);

                // TODO 1: try new way to call gotoFragB with fm.
                FragmentManager fm = ((MainActivity)getActivity()).getSupportFragmentManager();
                FragmentB fragB = FragmentB.newInstance(data, String.valueOf(font_size));
                fm.beginTransaction()
                        .replace(R.id.ln_container, fragB, "")
                        .commit();
                // TODO 2: add 3 seek bar items ( represent for each color channel)
            }
        });
    }
}