package assignment3

fun main() {
    print("Nhap thang (1-12): ")
    val month = readLine()!!.trim().toInt()

    print("Nhap nam: ")
    val year = readLine()!!.trim().toInt()

    if (month < 1 || month > 12) {
        println("Thang khong hop le!")
        return
    }

    println("Thang $month nam $year co ${daysInMonth(month, year)} ngay.")
}

//
fun daysInMonth(month: Int, year: Int): Int {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) 29
        else 28
        else -> -1
    }
}