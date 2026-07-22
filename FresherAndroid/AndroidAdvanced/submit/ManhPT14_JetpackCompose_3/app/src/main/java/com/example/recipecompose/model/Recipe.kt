package com.example.recipecompose.model

data class Recipe(
    val id: Int,
    val title: String,
    val isLiked: Boolean = false,
    val images: List<Int>
)