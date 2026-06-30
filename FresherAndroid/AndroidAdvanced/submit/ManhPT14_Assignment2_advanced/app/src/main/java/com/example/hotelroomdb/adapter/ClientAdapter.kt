package com.example.hotelroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelroomdb.databinding.ItemClientBinding
import com.example.hotelroomdb.model.Client

class ClientAdapter(
    private val onClick: (Client) -> Unit = {}
) : ListAdapter<Client, ClientAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemClientBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Client) {
            binding.tvClientName.text = item.fullName
            binding.tvGender.text = item.gender
            binding.tvCountry.text = item.country
            binding.tvPhone.text = item.phone
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<Client>() {
        override fun areItemsTheSame(old: Client, new: Client) = old.clientId == new.clientId
        override fun areContentsTheSame(old: Client, new: Client) = old == new
    }
}
