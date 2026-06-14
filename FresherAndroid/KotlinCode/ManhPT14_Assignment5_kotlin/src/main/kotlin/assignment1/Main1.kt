package assignment1

import kotlinx.coroutines.*

// chạy trên thread tính toán nặng, find số fibo thứ n
suspend fun fibonacci(n: Int): Int = withContext(Dispatchers.Default) {
    when (n) {
        1 -> 0
        2 -> 1
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}

// chạy trong môi trường blocking
fun main() = runBlocking {
    print("Enter n: ")
    val n = readln().toIntOrNull() ?: 0
    if (n <= 0) {
        print("n > 0 please")
        return@runBlocking
    }
    //scope để gom các coroutine lại
    val scope = CoroutineScope(Dispatchers.Default)

    // async là tạo courroutine có trả về kết quả
    val result = scope.async {
        fibonacci(n)
    }.await()
    // await để tạm dừng rồi mới chạy
    println("Fibonacci($n) = $result")
}