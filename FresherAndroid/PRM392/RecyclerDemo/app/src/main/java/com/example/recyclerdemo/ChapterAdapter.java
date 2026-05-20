package com.example.recyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {
    List<Chapter> list;

    public ChapterAdapter(List<Chapter> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chapter_card, parent, false);

        return new ChapterHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder holder, int position) {
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_desc.setText(list.get(position).getDescription());
        holder.img_ava.setImageResource(list.get(position).getAva_chap());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ChapterHolder extends RecyclerView.ViewHolder {
        //dai dien cho rowxml

        TextView tv_title, tv_desc;

        ImageView img_ava;
        public ChapterHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            img_ava = itemView.findViewById(R.id.img_ava);
        }
    }
}