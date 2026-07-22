package com.example.scopefunc_nullsafety

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
import com.example.scopefunc_nullsafety.ui.theme.Scopefunc_nullsafetyTheme

class A {
    fun getInfo(): String = "Hello World"
}

class B {
    var a: A? = null
}

class MainActivity : ComponentActivity() {

    var s1: String = "Hello"
    lateinit var s2: String
    var s4: String? = null
    var b: B? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var s3: String
//        Log.i("TAG", "${s2.uppercase()}")
//        Log.i("TAG", "${s3.uppercase()}")

//        Log.i("TAG", "s4 ${s4?.uppercase()}")
//        val s41 = s4
//        Log.i("TAG", "s4 ${if (s41 != null) s41.uppercase() else null}")
//
//        b?.a?.getInfo()
//        var a = b?.a
//        var c = if (a != null) a.getInfo() else null

        var s5 = if (s4 == null) "" else s4!!.uppercase()
        var s6 = null
        var s7 = "Hi"

        s6?.let {
            Log.i("TAG", "s6 ${s6}")
        }
        s7?.let {
            Log.i("TAG", "s7 ${s7}")
        }

        var obj = A()

        obj.apply {
            Log.i("TAG", "apply ${getInfo()}")
        }

        obj.also {
            Log.i("TAG", "also ${it.getInfo()}")
        }

  // let và run trả về data dc
        var r = obj.let {
            Log.i("TAG", "let ${it.getInfo()}")
            "result"
        }
        Log.i("TAG", "let2 $r")

        run {
            var r = "World"
            Log.i("TAG", "run $r")
        }
        Log.i("TAG", "run2 $r")

        obj.run {
            Log.i("TAG", "run3 ${getInfo()}")
        }

        with(s1.uppercase()) {
            Log.i("TAG", "with $this")
        }

    }
}
