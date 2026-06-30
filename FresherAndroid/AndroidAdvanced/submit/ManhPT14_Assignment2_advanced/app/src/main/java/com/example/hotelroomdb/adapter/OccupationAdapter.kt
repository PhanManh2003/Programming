package com.example.hotelroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelroomdb.databinding.ItemOccupationBinding
import com.example.hotelroomdb.model.relation.OccupationDetail

class OccupationAdapter(
    private val onClick: (OccupationDetail) -> Unit = {}
) : ListAdapter<OccupationDetail, OccupationAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemOccupationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OccupationDetail) {
            binding.tvClientName.text = item.clientName
            binding.tvRoomNumber.text = "Room ${item.roomNumber}"
            binding.tvTypeName.text = item.typeName
            binding.tvCheckIn.text = "In: ${item.checkIn}"
            binding.tvCheckOut.text = "Out: ${item.checkOut}"
            binding.tvExtraExpenses.text = "Extra: $${item.extraExpenses}"
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOccupationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<OccupationDetail>() {
        override fun areItemsTheSame(old: OccupationDetail, new: OccupationDetail) =
            old.occupationId == new.occupationId
        override fun areContentsTheSame(old: OccupationDetail, new: OccupationDetail) = old == new
    }
}
