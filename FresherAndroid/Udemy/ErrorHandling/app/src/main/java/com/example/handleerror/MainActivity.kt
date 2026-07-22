package com.example.handleerror

import android.os.Bundle
import android.util.Log
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
import com.example.handleerror.ui.theme.HandleErrorTheme
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var l = listOf(1,2,3)
//        try {
//            var r = l[5]
//        } catch (e: IllegalAccessException) {
//
//        } catch (e: Exception){
//            when (e) {
//                is ArrayIndexOutOfBoundsException -> Log.i("TAG","catch $e")
//                is AssertionError -> Log.i("TAG","catch 2 $e")
//                else -> throw e
//            }
//        } finally {
//            Log.i("TAG","finally")
//        }

        // CoroutineExceptionHandler là nơi xử lý các exception không được bắt (try-catch) trong coroutine.
        val handler = CoroutineExceptionHandler { c, t ->
            Log.i("TAG", "Catch error from handler $t")
        }
        CoroutineScope(Dispatchers.Default).launch(handler) {
//            supervisorScope dùng để cô lập lỗi giữa các coroutine con. coroutine 1 lỗi thì co2 vẫn chạy
            supervisorScope {
                launch {
                    //try catch for each launch
                    Log.i("TAG", "Start 1")
                    delay(100)
                    throw Exception("test ex")
                    Log.i("TAG", "End 1")
                }
                launch {
                    Log.i("TAG", "Start 2")
                    delay(200)
                    Log.i("TAG", "End 2")
                }
            }
        }
    }

}
}

