package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp2.ui.theme.Myapp2Theme

class WeightRowColActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box {
        Row(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red).weight(1f, false)
            )
            // weight trong Row hoặc Col hiểu đơn giản giống flex-grow bên css web,
            // fill = false nghĩa là không chiếm được không gian vượt quá size đc chỉ định
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Green).weight(1f, false)
            )
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Blue).weight(1f, false)
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Myapp2Theme {
        Greeting2("Android")
    }
}