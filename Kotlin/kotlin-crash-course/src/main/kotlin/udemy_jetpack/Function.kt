package udemy_jetpack


/*

 Function trong Kotlin dc đối xử như first-class citizen:
 Một thực thể được ngôn ngữ đối xử như các giá trị thông thường (giống Int, String...)
 , nên có thể trực tiếp gán vô biến, truyền vào hàm, trả về từ hàm và lưu trữ trực tiếp trong list.
 JAVA cũng làm dc nhưng phải thông qua Functional Interface, rồi sau đó dùng lambda.


Ý là:

Kotlin: function là một kiểu dữ liệu của ngôn ngữ, gọi là Function Type

    | Function type               | Ý nghĩa                     |
| --------------------------- | --------------------------- |
| `() -> Unit`                | Không tham số, không trả về |
| `() -> Int`                 | Không tham số, trả về `Int` |
| `(Int) -> Unit`             | 1 tham số                   |
| `(Int, String) -> Boolean`  | Nhiều tham số               |
| `(Int) -> User`             | Trả về object               |
| `(Int) -> String?`          | Trả về nullable             |
| `(String?) -> Unit`         | Nhận nullable               |
| `((Int) -> String) -> Unit` | Nhận một function           |
| `(Int) -> (() -> Unit)`     | Trả về một function         |
| `String.() -> Unit`         | Extension function type     |
| `suspend (Int) -> String`   | Suspend function type       |

Java: không có kiểu dữ liệu function. Lambda chỉ là cú pháp giúp tạo
 đối tượng của một functional interface (Function, Consumer, Predicate, Supplier
  hoặc interface do bạn tự định nghĩa).

------------------------------------------------------------------
- Trong Kotlin, Lambda là "giá trị của 1 function type" còn JAVA thì
Lambda là implementation của functional interface.
--------------------------------------------------------------------



- Trong Kotlin, Function reference là cách viết ngắn gọn của lambda khi lambda
 chỉ gọi một function duy nhất và không xử lý gì thêm. ( na ná java method reference)
* */
fun sum1(a: Int, b: Int = 10): Int {
    return a + b
}

fun main() {
    var list = listOf(1, 2, 3)
    list.forEach { println(it) } // it là tên mặc định của tham số duy nhất trong lambda của Kotlin.

    println("Kiểu mới:")
    list.forEach { v: Int ->
        println(v)
        println("---")
    }

    // anonymous function truyền vô forEach thay vì lambda
    list.forEach(
        fun(v: Int) {
            println(v)
            println("---")
        }
    )

}