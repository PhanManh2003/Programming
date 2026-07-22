package com.example.hiltcrypto.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltcrypto.R
import com.example.hiltcrypto.data.model.Cryptocurrency

class CryptoAdapter : ListAdapter<Cryptocurrency,
        CryptoAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName    = view.findViewById<TextView>(R.id.tvName)
        val tvSymbol  = view.findViewById<TextView>(R.id.tvSymbol)
        val tvPrice   = view.findViewById<TextView>(R.id.tvPrice)
        val tvChange  = view.findViewById<TextView>(R.id.tvChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crypto, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text   = item.name
        holder.tvSymbol.text = item.symbol
        holder.tvPrice.text  = "$${item.price}"
        holder.tvChange.text = "${item.changePercent}%"
        // Đổi màu theo tăng/giảm
        holder.tvChange.setTextColor(
            if (item.changePercent >= 0) Color.GREEN else Color.RED
        )
    }

    class DiffCallback : DiffUtil.ItemCallback<Cryptocurrency>() {
        override fun areItemsTheSame(a: Cryptocurrency, b: Cryptocurrency) =
            a.symbol == b.symbol
        override fun areContentsTheSame(a: Cryptocurrency, b: Cryptocurrency) =
            a == b
    }
}