package assignment1

// Enter an array of integer numbers a0, a1, a2, ..., an-1. Do not use any other array, print
//the above array screen in ascending order.

// bubble
fun sortArray(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun main() {
    print("Nhap n: ")
    val n = readLine()!!.trim().toInt()
    val arr = IntArray(n)

    for (i in 0 until n) {
        print("a[$i] = ")
        arr[i] = readLine()!!.trim().toInt()
    }

    sortArray(arr)

    println("Mang sau khi sap xep: ${arr.contentToString()}")
}