package com.example.orderapp.adapter

import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.R

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.orderapp.model.CartItem

class CartAdapter(
    private val onRemoveClick: (CartItem) -> Unit
) : ListAdapter<CartItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvCartFoodName)
        val tvQty: TextView = view.findViewById(R.id.tvCartQty)
        val tvSubtotal: TextView = view.findViewById(R.id.tvCartSubtotal)
        val btnRemove: Button = view.findViewById(R.id.btnRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text = item.food.name
        holder.tvQty.text = "x${item.quantity}"
        holder.tvSubtotal.text = "${(item.food.price * item.quantity).toInt()} đ"
        holder.btnRemove.setOnClickListener { onRemoveClick(item) }
    }
}

class CartDiffCallback : DiffUtil.ItemCallback<CartItem>() {
    override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem.food.id == newItem.food.id
    }

    override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem == newItem
    }
}