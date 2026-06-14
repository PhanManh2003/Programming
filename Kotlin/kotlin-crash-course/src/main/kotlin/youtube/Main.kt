package youtube

fun main() {
    // readln ko trả về null như readLine

//    println("enter a number:")
//    val input = readLine()
//    val value  = input?.toIntOrNull()?.rem(3) ?: 0;
//    // ?. là safe call operator, nếu ko null thì gọi method , nếu null thì trả về null
//    // toán tử !! nghĩa là Tôi chắc chắn biến này không phải null
//
//    // Elvis operator ?: nếu bên trái operator null thì tôi lấy cái bên phải operator này
//    val isEven = value % 2 == 0
//    println("you entered: $isEven") // 16 false, 17 true

// if condition, when
    // when thay thế cho switch case trong java
//    print("enter a number: ")
//    val input = readln()
//    val inputAsInteger = try {
//        input.toInt()
//    } catch (e: NumberFormatException) {
//        0
//    } finally {
//        println("xong try catch")
//    }
//
//
//    val output = when (inputAsInteger) {
//        null -> "enter a number"
//        3 -> "three"
//        4 -> "four"
//        5 -> "five"
//        in 10..20 -> "number between 10 and 20"
//        else -> "unknown"
//    }
//    println(output)


    // loop
//    print("Enter amount of numbers: ")
//    val amoutOfNumbers = readln().toIntOrNull() ?: 0
//
//    var numbers = intArrayOf()
//    var i = 0
//    while (i < amoutOfNumbers) {
//        print("Enter number ${i + 1}: ")
//        val number = readln().toIntOrNull() ?: continue
//        numbers += number // tạo mảng mới rồi copy và thêm giá trị mới vào
//        i++
//    }
//    println("Numbers: ${numbers.contentToString()}")

    println("Enter a string: ")
    val input = readln()

    // Stringbuilder
    val finalString = buildString {
        for (i in input.lastIndex downTo 0) { // giống .length của java
            append(input[i]) // giống charAt(i) của java
        }
    }
    println(finalString)
}