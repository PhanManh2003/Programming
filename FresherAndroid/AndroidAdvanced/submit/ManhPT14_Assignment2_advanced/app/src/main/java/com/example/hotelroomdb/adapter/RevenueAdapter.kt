package com.example.hotelroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelroomdb.databinding.ItemRevenueBinding
import com.example.hotelroomdb.model.result.YearlyRevenue

class RevenueAdapter : ListAdapter<YearlyRevenue, RevenueAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemRevenueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: YearlyRevenue) {
            binding.tvYear.text = item.year.toString()
            binding.tvTotalRevenue.text = "$%.2f".format(item.totalRevenue)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRevenueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<YearlyRevenue>() {
        override fun areItemsTheSame(old: YearlyRevenue, new: YearlyRevenue) =
            old.year == new.year
        override fun areContentsTheSame(old: YearlyRevenue, new: YearlyRevenue) = old == new
    }
}
