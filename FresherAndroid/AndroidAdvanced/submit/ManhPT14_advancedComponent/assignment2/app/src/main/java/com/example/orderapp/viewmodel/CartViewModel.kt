package com.example.orderapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.orderapp.model.CartItem
import com.example.orderapp.model.FoodItem

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<MutableList<CartItem>>(mutableListOf())
    val cartItems: LiveData<MutableList<CartItem>> get() = _cartItems

    val totalPrice: LiveData<Double> = MutableLiveData(0.0)

    fun addToCart(food: FoodItem) {
        val current = _cartItems.value ?: mutableListOf()
        val existing = current.find { it.food.id == food.id }
        if (existing != null) {
            existing.quantity++
        } else {
            current.add(CartItem(food))
        }
        _cartItems.value = current
        updateTotal()
    }

    fun removeFromCart(cartItem: CartItem) {
        val current = _cartItems.value ?: mutableListOf()
        current.remove(cartItem)
        _cartItems.value = current
        updateTotal()
    }

    private fun updateTotal() {
        val total = _cartItems.value?.sumOf { it.food.price * it.quantity } ?: 0.0
        (totalPrice as MutableLiveData).value = total
    }
}