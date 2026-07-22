package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp2.ui.theme.Myapp2Theme

class ScrollRowColActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    // dùng verticalScroll và horizontalScroll
//    Column(Modifier.verticalScroll(rememberScrollState())) {
//        Row(Modifier.horizontalScroll(rememberScrollState())) {
//            repeat(10) {
//                Box(
//                    modifier = Modifier
//                        .size(100.dp)
//                        .padding(10.dp)
//                        .background(color = Color.Green)
//                )
//            }
//        }
//
//        repeat(10) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(10.dp)
//                    .background(color = Color.Green)
//            )
//        }
//        Row(Modifier.horizontalScroll(rememberScrollState())) {
//            repeat(10) {
//                Box(
//                    modifier = Modifier
//                        .size(100.dp)
//                        .padding(10.dp)
//                        .background(color = Color.Green)
//                )
//            }
//        }
//    }

    /*
 mutableStateOf(x) → tạo state, để Compose biết theo dõi thay đổi.
remember { } → giữ giá trị đó không bị reset qua các lần recompose.
by → cho phép dùng biến trực tiếp (offset) thay vì .value (offset.value).
lazy { } → trì hoãn tính giá trị tới lần đọc đầu tiên, rồi cache lại.
lateinit → bạn tự gán giá trị sau, không có cơ chế tự động nào cả.
* */

    var offset by remember { mutableStateOf(0f) }
    Column(
        Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { delta ->
                    offset += delta
                    delta
                }
            )) {
        Text("$offset")
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Myapp2Theme {
        Greeting3("Android")
    }
}