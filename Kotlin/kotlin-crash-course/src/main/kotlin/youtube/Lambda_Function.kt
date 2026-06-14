package youtube

import kotlin.text.iterator

fun main() {
    // it là tên mặc định của tham số duy nhất trong lambda của Kotlin.
    print("enter a string: ")
    val input = readln()
//    val lettersOnly = input.filter {
//        it.isLetter()
//    }

    // cách 2:
//    val lambda: (Char) -> Boolean = {
//        it.isLetter()
//    }
//
//    val lettersOnly = input.filter(lambda)

    // cách 3 : đặt tên cho tham số duy nhất
//    val lettersOnly = input.filter {
//        currentChar -> currentChar.isLetter()
//    }

    // cách 4 : extension function
    val lettersOnly = input.myFilter {
        isLetter()
    }
    println("lettersOnly: $lettersOnly")
}

// extension function: nhận tham số lambda kiểu predicate
//fun String.youtube.myFilter(predicate: (Char) -> Boolean): String {
//    return buildString {
//        for(char in this@youtube.myFilter) {
//            if (predicate(char)) {
//                append(char)
//            }
//        }
//    }
//}


/*
* (A) -> B: Là lambda thông thường, bạn phải truyền tham số A vào.
*
* A.() -> B: Là lambda có receiver, bạn không cần truyền tham số mà có
*  thể thao tác trực tiếp với A thông qua từ khóa this.
* */

// predicate là 1 biến kiểu function
fun String.myFilter(predicate: Char.() -> Boolean): String {
    return buildString {
        for (char in this@myFilter) {
            if (char.predicate()) { // char là receiver, đứng trước dấu chấm
                append(char)
            }
        }
    }
}

// .() để tạo lambda extension, mục địch extension lambda để làm gì
//
//Extension lambda sinh ra để viết DSL — code đọc như ngôn ngữ tự nhiên.