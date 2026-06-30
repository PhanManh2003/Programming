package com.example.hotelroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelroomdb.databinding.ItemExpenseBinding
import com.example.hotelroomdb.model.result.ClientExpense

class ExpenseAdapter : ListAdapter<ClientExpense, ExpenseAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ClientExpense) {
            binding.tvClientName.text = item.clientName
            binding.tvTotalExpense.text = "$%.2f".format(item.totalExpense)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<ClientExpense>() {
        override fun areItemsTheSame(old: ClientExpense, new: ClientExpense) =
            old.clientId == new.clientId
        override fun areContentsTheSame(old: ClientExpense, new: ClientExpense) = old == new
    }
}
