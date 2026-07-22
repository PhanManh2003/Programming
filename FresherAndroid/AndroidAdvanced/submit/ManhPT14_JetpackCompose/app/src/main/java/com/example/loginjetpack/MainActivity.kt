package com.example.loginjetpack

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginjetpack.ui.screen.CreateAccountScreen
import com.example.loginjetpack.ui.theme.CreateAccountTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CreateAccountTheme {
                CreateAccountScreen()
            }
        }

    }
}