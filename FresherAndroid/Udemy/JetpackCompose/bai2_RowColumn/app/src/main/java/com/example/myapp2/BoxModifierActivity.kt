package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.LightGray
import com.example.myapp2.ui.theme.Myapp2Theme

class BoxModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(20.dp) // tạo khoảng cách giữa box và parent
            .background(color = LightGray)
            .size(500.dp)
            .padding(20.dp) // tạo khoảng cách giữa box và nội dung bên trong box
    ) {
        Box(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
                .border(
                    border = BorderStroke(4.dp, Color.Blue),
                    shape = RoundedCornerShape(30.dp)
                )
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomStart = 70.dp,
                        bottomEnd = 30.dp
                    )
                )
//                .background(color = Red)
            ,
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .size(100.dp)
                    .shadow(
                        elevation = 50.dp,
                        shape = RoundedCornerShape(12.dp), // nếu muốn bo góc
                        spotColor = Color.Green,
                        ambientColor = Color.Green
                    )
                    .background(
                        color = Color.White,
                    )
            )
            Box(
                Modifier
                    .size(50.dp)
                    .background(
                        color = Color.Yellow,
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Myapp2Theme {
        Greeting4("Android")
    }
}