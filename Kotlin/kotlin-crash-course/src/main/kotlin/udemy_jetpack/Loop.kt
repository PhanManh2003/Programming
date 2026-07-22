package udemy_jetpack

fun main() {
    println("for")
    var list = listOf(10, 20, 30, 40, 50, 60, 70, 80)
    for (i in 0 until list.size) { //until hoặc donwto , kết hợp thêm step nếu muốn
        println("${list[i]} ")
    }


    println("for each")
    for (i in list) {
        println("${i} ")
    }
    // hoặc .forEach
    list.forEach {
        println("$it")
    }

}