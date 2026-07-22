package com.example.flowchannel

import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage.MessageLevel.LOG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flowchannel.ui.theme.FlowchannelTheme
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    fun simpleFlow(): Flow<Int> {
        return flow {
            for (i in 1..5) {
                delay(1000)
                emit(i)
            }
        }
    }

    fun simpleFlow2(): Flow<Int> {
        return flow {
            try {
                for (i in 1..5) {
                    delay(1000)
                    emit(i)
                }
            } catch (e: CancellationException) {
                Log.i("TAG", "CancellationException")
            } finally {
                Log.i("TAG", "finally")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TAG", "Start Flow")

        CoroutineScope(Dispatchers.Main).launch {
//            simpleFlow().collect {
//                Log.i("TAG", "Value: $it")
//            }
            // cách 2 tạo flow
//            flowOf(1, 2, 3, 4, 5).collect {
//                Log.i("TAG", "Value: $it")
//            }

            // cách 3
//            listOf(3, 4, 5).asFlow().collect {
//                Log.i("TAG", "Value: $it")
//            }

            // chỉ lấy n phần tử
//            simpleFlow2().take(2).collect {
//                Log.i("TAG", "Value: $it")
//            }

            // transform là 1 operator tổng quát
//            simpleFlow2().transform { value ->
//                if (value % 2 == 0) {
//                    emit(value)
//                } else {
//                    emit(value + 10)
//                }
//            }.collect { Log.i("TAG", "Value: $it") }

//            simpleFlow2().map { -it }.collect { }
//           val total =  simpleFlow2().reduce { a,b -> a + b }

//            simpleFlow2().toList()
        }

        CoroutineScope(Dispatchers.Main).launch {
            val channel = Channel<Int>()
            val job = launch {
                for (i in 1..2) {
                    channel.send(i) // send là 1 suspend fun
                }
            }
            for (i in 1..2) {
                val receive = channel.receive()
                Log.i("TAG", "receive: $receive")
            }
        }

        Log.i("TAG", "End Flow")
    }
}


