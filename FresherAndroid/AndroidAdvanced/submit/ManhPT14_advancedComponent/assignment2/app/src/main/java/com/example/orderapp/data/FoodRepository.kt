package com.example.orderapp.data

import com.example.orderapp.model.FoodItem

object FoodRepository {
    fun getSampleFoods(): List<FoodItem> = listOf(
        FoodItem(1, "Phở bò", "Phở bò truyền thống, nước dùng đậm đà", 45000.0),
        FoodItem(2, "Bún chả", "Bún chả Hà Nội với nem rán", 40000.0),
        FoodItem(3, "Cơm tấm", "Cơm tấm sườn bì chả", 35000.0),
        FoodItem(4, "Bánh mì", "Bánh mì thịt nguội pate", 20000.0),
        FoodItem(5, "Gỏi cuốn", "Gỏi cuốn tôm thịt", 30000.0)
    )
}