package assignment2

fun main() {
    print("Nhập số nguyên có 2 chữ số (10-99): ")
    val input = readLine()?.trim()?.toIntOrNull()

    if (input == null || input < 10 || input > 99) {
        println("Số không hợp lệ! Vui lòng nhập số từ 10 đến 99.")
        return
    }
    println("Số thập phân : $input")
    println("Nhị phân     : ${Integer.toBinaryString(input)}")
    println("Thập lục phân: ${Integer.toHexString(input).uppercase()}")
}