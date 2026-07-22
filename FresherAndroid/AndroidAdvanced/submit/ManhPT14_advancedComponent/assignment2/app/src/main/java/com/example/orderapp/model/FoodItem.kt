package com.example.orderapp.model

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double
)

data class CartItem(
    val food: FoodItem,
    var quantity: Int = 1
)