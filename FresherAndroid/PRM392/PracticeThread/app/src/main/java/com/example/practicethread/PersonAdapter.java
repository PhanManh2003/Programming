package com.example.practicethread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    List<Person> personList;
    Context context;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {
        Person p = personList.get(position);
        holder.tv_firstname.setText(p.getFirst_name());
        holder.tv_lastname.setText(p.getLast_name());
        holder.tv_email.setText(p.getEmail());

        // Load ảnh từ URL bằng Glide
        Glide.with(context).load(p.getAvatar()).into(holder.imv_avatar);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    static class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView imv_avatar;
        TextView tv_firstname, tv_lastname, tv_email;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_avatar = itemView.findViewById(R.id.imv_avatar);
            tv_firstname = itemView.findViewById(R.id.tv_firstname);
            tv_lastname = itemView.findViewById(R.id.tv_lastname);
            tv_email = itemView.findViewById(R.id.tv_email);
        }
    }


}
