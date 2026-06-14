package assignment1

fun main() {
    // dùng lambda
    val result = (10..200).filter { it % 7 == 0 && it % 5 != 0 }
    println(result.joinToString(", "))
}