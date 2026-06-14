package youtube

fun main() {
    print("enter: ")
    val input = readln().toInt()
    val reversed = input.reversed()
    println(reversed)
}

// Overloading : khác danh sách tham số hoặc receiver type đối với extension function
// khác kiểu trả về vẫn tính.
fun String.reversed(): String {
    return buildString {
        for (i in this@reversed.lastIndex downTo 0) { // giống .length của java
            append(this@reversed[i]) // giống charAt(i) của java
        }
    }
}

fun Int.reversed(): Int {
    return this.toString().reversed().toInt()
}

/*
* Extension Function là tính năng cho phép bạn thêm hàm mới vào một class
* đã tồn tại mà không cần sửa source code của class đó và không cần kế thừa.
*
* Cú pháp:
* fun ReceiverType.functionName() {
    ...
}
*
* Receiver là "thằng đứng trước dấu chấm" khi gọi hàm.
*
*
* named parameter là gọi hàm kèm tên tham số gốc
* vd: A.doSth(str = "ABC")
* */

/*
* tức là bạn có thể “thêm” thuộc tính vào một class mà
* không cần sửa code gốc của class đó.
* */