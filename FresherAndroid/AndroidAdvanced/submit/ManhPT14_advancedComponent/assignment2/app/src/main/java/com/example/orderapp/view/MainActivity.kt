package com.example.orderapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.view.FoodDetailActivity
import com.example.orderapp.R
import com.example.orderapp.adapter.FoodAdapter
import com.example.orderapp.viewmodel.FoodListViewModel

class MainActivity : AppCompatActivity() {

    private val foodListViewModel: FoodListViewModel by lazy {
        ViewModelProvider(this)[FoodListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = FoodAdapter { food ->
            // Mở màn hình chi tiết thay vì add thẳng vào cart
            val intent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra(FoodDetailActivity.EXTRA_FOOD_ID, food.id)
                putExtra(FoodDetailActivity.EXTRA_FOOD_NAME, food.name)
                putExtra(FoodDetailActivity.EXTRA_FOOD_DESC, food.description)
                putExtra(FoodDetailActivity.EXTRA_FOOD_PRICE, food.price)
            }
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }

        foodListViewModel.foods.observe(this) { list ->
            adapter.submitList(list)
        }

        findViewById<android.widget.ImageButton>(R.id.btnCart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}