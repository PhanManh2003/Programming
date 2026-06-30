package com.example.contactapp.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;
import com.example.contactapp.model.Contact;
import com.example.contactapp.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

    private List<Contact> contacts = new ArrayList<>();
    private final OnItemClickListener listener;

    public ContactAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Cập nhật danh sách (gọi từ Fragment sau khi load DB)
    public void setContacts(List<Contact> list) {
        this.contacts = list != null ? list : new ArrayList<>();
        notifyDataSetChanged();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.bind(contact, listener);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    // ── ViewHolder ──────────────────────────────────────────────────────────
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView  tvName;
        private final TextView  tvPhone;
        private final ImageView imgAvatar;
        private final TextView  tvAvatarLetter;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName         = itemView.findViewById(R.id.tvContactName);
            tvPhone        = itemView.findViewById(R.id.tvContactPhone);
            imgAvatar      = itemView.findViewById(R.id.imgAvatar);
            tvAvatarLetter = itemView.findViewById(R.id.tvAvatarLetter);
        }

        void bind(Contact contact, OnItemClickListener listener) {
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhone());

            // Hiển thị ảnh nếu có, ngược lại hiện chữ cái đầu
            String base64 = contact.getPhoto();
            if (base64 != null && !base64.isEmpty()) {
                Bitmap bmp = ImageUtils.base64ToBitmap(base64);
                if (bmp != null) {
                    imgAvatar.setImageBitmap(bmp);
                    imgAvatar.setVisibility(View.VISIBLE);
                    tvAvatarLetter.setVisibility(View.GONE);
                } else {
                    showLetter(contact);
                }
            } else {
                showLetter(contact);
            }

            itemView.setOnClickListener(v -> listener.onItemClick(contact));
        }

        private void showLetter(Contact contact) {
            imgAvatar.setVisibility(View.GONE);
            tvAvatarLetter.setVisibility(View.VISIBLE);
            tvAvatarLetter.setText(ImageUtils.getAvatarLetter(contact.getName()));
            tvAvatarLetter.getBackground().setTint(ImageUtils.getAvatarColor(contact.getName()));
        }
    }
}
