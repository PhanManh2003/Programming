package com.example.couroutineudemy

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
import com.example.couroutineudemy.ui.theme.CouroutineudemyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        * Khi bạn gọi GlobalScope.launch { ... }:

Main thread gọi launch → launch chỉ làm việc "đóng gói + gửi coroutine vào dispatcher" → việc này
* cực nhanh (submit vào queue của thread pool).
launch return ngay lập tức cho main thread, không chờ.
Main thread tiếp tục chạy code phía dưới ngay lập tức — tức là dòng Log.i("TAG", "End").
Trong khi đó, ở một thread khác (thread pool Default), việc "nhận coroutine từ queue rồi
 bắt đầu chạy" cần thêm một chút thời gian: tạo/lấy thread từ pool, schedule task...
        * */
        Log.i("TAG", "Start")
//        GlobalScope.launch {
//            Log.i("TAG", "Start GlobalScope")
//            delay(1000)
//            Log.i("TAG", "End GlobalScope") // output: start -> end -> ...
//        }
//        GlobalScope.launch {
//            Log.i("TAG", "Start GlobalScope 2")
//            delay(1000)
//            Log.i("TAG", "End GlobalScope 2")
//        }


//        GlobalScope.launch {
//            Log.i("TAG", "Start GlobalScope")
//            var job = launch {
//                Log.i("TAG", "Start launch")
//                delay(3000)
//                Log.i("TAG", "End launch")
//            }
//            //job.join()
//
//            var a = async {
//                Log.i("TAG", "Start async")
//                delay(2000)
//                Log.i("TAG", "End async")
//                compute()
//            }
//            //Log.i("TAG", "async ${a.await()}")
//            joinAll(job, a)
//
//            Log.i("TAG", "End GlobalScope")
//        }

//        CoroutineScope(Dispatchers.IO).launch {
//            Log.i("TAG", "Start io")
//            delay(1000)
//            withContext(Dispatchers.Main) {
//                //update ui
//            }
//            Log.i("TAG", "End io")
//        }

//        GlobalScope.launch { // coroutine cha
//            val job = launch { // coroutine con , kế thừa scope
//                try {
//                    for (i in 0..10) {
//                        println(i)
//                        //Thread.sleep(1000)
//                        delay(1000)    //cancel by check job.isActive to exit or ensureActive ()
//                        //compute()
//                    }
//                } finally {
//                    println("cancelled")
//                }
//            }
//            delay(1500)
//            println("Cancel job")
//            job.cancel()
//        }

//        runBlocking {
//            var job = launch {
//                Log.i("TAG", "Start launch")
//                delay(2000)
//                Log.i("TAG", "End launch")
//            }
//
//            var job2 = launch {
//                Log.i("TAG", "Start launch2")
//                delay(1000)
//                Log.i("TAG", "End launch2")
//            }
//            Log.i("TAG", "End runBlocking")
//        }

        runBlocking { // runBlocking chạy trên main thread
            var job = launch {
                launch {
                    Log.i("TAG", "Start launch")
                    delay(1000)
                    Log.i("TAG", "End launch")
                }
                launch {
                    Log.i("TAG", "Start launch2")
                    delay(2000)
                    Log.i("TAG", "End launch2")
                }

                GlobalScope.launch { // chạy trên thread riêng ( thường là Default)
                    Log.i("TAG", "Start launch g")
                    delay(2000)
                    Log.i("TAG", "End launch g")
                }
            }
            delay(500)
            job.cancel() // end launch và end launch 2 ko dc in ra
            Log.i("TAG", "End runBlocking")
        }

        //viewmodelscope..

        Log.i("TAG", "End")
    }


    suspend fun compute() {
        Log.i("TAG", "Start compute")
        //delay(1000)
        Log.i("TAG", "End compute")
        1
    }

}



