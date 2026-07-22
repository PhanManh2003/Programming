package com.example.textcompose

import android.R.style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.textcompose.ui.theme.TextcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextcomposeTheme {
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

// tạo custom font từ resource
val playfairfont = FontFamily(
    Font(R.font.playfair_italic, weight = FontWeight.Medium),
    Font(
        R.font.playfair_variable, weight = FontWeight.Bold,
    )
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()) {
        Text(
//            "Hello World fun Greeting(name: String, modifier: Modifier = Modifier)" +
//                    "fun Greeting(name: String, modifier: Modifier = Modifier)" +
//                    "fun Greeting(name: String, modifier: Modifier = Modifier)"
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append("H")
                }
                append("ello")
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("World")
                }
            },
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            softWrap = false, // ko xuống dòng
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            fontStyle = FontStyle.Italic,
            fontFamily = playfairfont,
            textDecoration = TextDecoration.LineThrough,
            color = Color.Blue,
//            modifier = modifier
//                .background(Color.Yellow)
//                .rotate(90f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextcomposeTheme {
        Greeting("Android")
    }
}