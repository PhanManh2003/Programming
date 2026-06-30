package com.example.fragmentsinger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsinger.R;
import com.example.fragmentsinger.model.Singer;

import java.util.List;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.SingerViewHolder> {

    public interface OnSingerClickListener {
        void onSingerClick(Singer singer);
    }

    private final List<Singer> singers;
    private final OnSingerClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public SingerAdapter(List<Singer> singers, OnSingerClickListener listener) {
        this.singers = singers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SingerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_singer, parent, false);
        return new SingerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingerViewHolder holder, int position) {
        Singer singer = singers.get(position);
        holder.tvName.setText(singer.getName());

        if (position == selectedPosition) {
            holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.selected_bg));
            holder.tvName.setTextColor(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.selected_text));
            holder.ivIcon.setColorFilter(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
        } else {
            holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.item_bg));
            holder.tvName.setTextColor(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.text_primary));
            holder.ivIcon.setColorFilter(
                    ContextCompat.getColor(holder.itemView.getContext(), R.color.primary));
        }

        holder.itemView.setOnClickListener(v -> {
            int prev = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            if (prev != RecyclerView.NO_POSITION) notifyItemChanged(prev);
            notifyItemChanged(selectedPosition);
            listener.onSingerClick(singer);
        });
    }

    @Override
    public int getItemCount() {
        return singers.size();
    }

    static class SingerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivIcon;

        SingerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_singer_name);
            ivIcon = itemView.findViewById(R.id.iv_singer_icon);
        }
    }
}
