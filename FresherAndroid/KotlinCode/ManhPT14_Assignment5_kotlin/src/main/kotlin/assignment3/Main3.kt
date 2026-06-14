package assignment3

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Tính tổng 0 đến N
suspend fun sumToN(n: Int): Int = withContext(Dispatchers.Default) {
    (0..n).sum()
}

// Flow trả về kết quả 10 lần, delay 500ms giữa mỗi lần
fun sumFlow(): Flow<Int> = flow {
    for (n in 0..10) {
        val result = sumToN(n)
        emit(result)
        delay(500)
    }
}

fun main() = runBlocking {
    sumFlow().collect { result ->
        println("Result: $result")
    }
}