package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp2.ui.theme.Myapp2Theme


/*
* Row và Column là hai Composable layout cơ bản nhất trong Jetpack Compose,
*  dùng để sắp xếp các thành phần con theo chiều ngang hoặc chiều dọc.
* */
class RowColActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BaseItem(color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
    )
}

@Composable
fun BaseItem2(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box() {
//        Row(
//            modifier = Modifier
//                .background(color = Color.LightGray)
//                .fillMaxWidth()
//                .height(200.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BaseItem2(Modifier
//                .background(Color.Red)
//                .align(Alignment.Bottom).size(50.dp))
//            BaseItem(Color.Green)
//            BaseItem(Color.Blue)
//        }
        Column (
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .height(500.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseItem2(Modifier
                .background(Color.Red)
                .align(Alignment.End).size(50.dp))
            BaseItem(Color.Green)
            BaseItem(Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Myapp2Theme {
        Greeting("Android")
    }
}