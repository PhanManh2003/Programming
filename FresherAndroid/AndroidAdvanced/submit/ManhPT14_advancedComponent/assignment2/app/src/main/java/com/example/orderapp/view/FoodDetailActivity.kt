package com.example.orderapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.appcompat.app.AppCompatActivity

import com.example.orderapp.OrderApp
import com.example.orderapp.R
import com.example.orderapp.model.FoodItem

class FoodDetailActivity : AppCompatActivity() {
    private val cartViewModel by lazy { (application as OrderApp).cartViewModel }

    companion object {
        const val EXTRA_FOOD_ID = "extra_food_id"
        const val EXTRA_FOOD_NAME = "extra_food_name"
        const val EXTRA_FOOD_DESC = "extra_food_desc"
        const val EXTRA_FOOD_PRICE = "extra_food_price"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_food_detail)

        val id = intent.getIntExtra(EXTRA_FOOD_ID, -1)
        val name = intent.getStringExtra(EXTRA_FOOD_NAME) ?: ""
        val desc = intent.getStringExtra(EXTRA_FOOD_DESC) ?: ""
        val price = intent.getDoubleExtra(EXTRA_FOOD_PRICE, 0.0)

        val food = FoodItem(id, name, desc, price)

        findViewById<TextView>(R.id.tvDetailName).text = food.name
        findViewById<TextView>(R.id.tvDetailDesc).text = food.description
        findViewById<TextView>(R.id.tvDetailPrice).text = "${food.price.toInt()} đ"

        findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener { finish() }

        findViewById<Button>(R.id.btnAddToCart).setOnClickListener {
            cartViewModel.addToCart(food)
            Toast.makeText(this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}