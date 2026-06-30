package com.example.hotelroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelroomdb.databinding.ItemRoomBinding
import com.example.hotelroomdb.model.relation.RoomWithType

class RoomAdapter(
    private val onClick: (RoomWithType) -> Unit = {}
) : ListAdapter<RoomWithType, RoomAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RoomWithType) {
            binding.tvRoomNumber.text = "Room ${item.room.roomNumber}"
            binding.tvTypeName.text = item.roomType.typeName
            binding.tvPricePerNight.text = "$${item.roomType.pricePerNight}/night"
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<RoomWithType>() {
        override fun areItemsTheSame(old: RoomWithType, new: RoomWithType) =
            old.room.roomNumber == new.room.roomNumber
        override fun areContentsTheSame(old: RoomWithType, new: RoomWithType) = old == new
    }
}
