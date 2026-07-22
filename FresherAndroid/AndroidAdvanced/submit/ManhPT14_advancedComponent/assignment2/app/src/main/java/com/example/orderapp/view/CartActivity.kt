package com.example.orderapp.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orderapp.OrderApp
import com.example.orderapp.R
import com.example.orderapp.adapter.CartAdapter

class CartActivity : AppCompatActivity() {

    private val cartViewModel by lazy { (application as OrderApp).cartViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cart)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        val adapter = CartAdapter { cartItem ->
            cartViewModel.removeFromCart(cartItem)
        }

        findViewById<RecyclerView>(R.id.recyclerViewCart).apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            this.adapter = adapter
        }

        cartViewModel.cartItems.observe(this) { list ->
            adapter.submitList(list.toList())
        }

        cartViewModel.totalPrice.observe(this) { total ->
            tvTotal.text = "Tổng: ${total.toInt()} đ"
        }

        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
            .setNavigationOnClickListener { finish() }

        findViewById<android.widget.Button>(R.id.btnConfirm).setOnClickListener {
            android.widget.Toast.makeText(
                this,
                "Đặt hàng thành công!",
                android.widget.Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}