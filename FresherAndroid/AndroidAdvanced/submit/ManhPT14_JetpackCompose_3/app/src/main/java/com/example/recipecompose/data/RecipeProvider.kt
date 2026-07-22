package com.example.recipecompose.data

import com.example.recipecompose.R
import com.example.recipecompose.model.Recipe



object RecipeProvider {

    private val allRecipes = listOf(
        Recipe(
            id = 1,
            title = "The new method to making breakfast",
            isLiked = false,
            images = listOf(R.drawable.monan1, R.drawable.monan2)
        ),
        Recipe(
            id = 2,
            title = "Banana and Mandarin Buns",
            isLiked = true,
            images = listOf(R.drawable.monan2, R.drawable.monan3, R.drawable.monan1)
        ),
        Recipe(
            id = 3,
            title = "Cardamom and Cranberry Pastry",
            isLiked = false,
            images = listOf(R.drawable.monan3, R.drawable.monan1)
        ),
        Recipe(
            id = 4,
            title = "Banana Smoothie Bowl",
            isLiked = false,
            images = listOf(R.drawable.monan1, R.drawable.monan3)
        ),
        Recipe(
            id = 5,
            title = "Classic Breakfast Burrito",
            isLiked = true,
            images = listOf(R.drawable.monan2, R.drawable.monan1)
        )
    )

    fun search(name: String): List<Recipe> {
        if (name.isBlank()) return allRecipes
        return allRecipes.filter {
            it.title.contains(name, ignoreCase = true)
        }
    }
}