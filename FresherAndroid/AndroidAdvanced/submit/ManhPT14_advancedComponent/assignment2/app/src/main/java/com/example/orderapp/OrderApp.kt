package com.example.orderapp

import android.app.Application
import com.example.orderapp.viewmodel.CartViewModel

class OrderApp : Application() {
    val cartViewModel: CartViewModel by lazy { CartViewModel() }
}