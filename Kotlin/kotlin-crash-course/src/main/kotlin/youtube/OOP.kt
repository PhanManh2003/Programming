package youtube

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val rec1 = Rectangle(
        width = 5f,
        height = 7f
    )

    val rec2 = Rectangle(
        width = 5f,
        height = 7f
    )
//    rec1.inc()
    println(rec1 == rec2) // true'
    println("sum area ${sumArea(rec1, rec2)}") // 70

    val rec3 = rec1.copy(width = 10f)

    val circle = Circle(radius = 20f)
    printShapes(rec1, rec2, rec3, circle)
    println(rec3)


    // enum
    println(greetMe(Country.USA))

    for (country in Country.entries) {
        println("${country.name} - ${country.code}")
    }
}

fun printShapes(vararg shapes: Shape) {
    for (shape in shapes) {
        when (shape) {
            is Rectangle -> println("a rectangle")
            is Circle -> println("a circle")
            is FixSizedSquare -> println("a fixed sized square")
            // ko cần else vì đã có sealed interface
        }
    }
}
// sealed class/ interface để giới hạn phạm vi kế thừa, giúp compiler biết trước tất cả các lớp con có thể có.
// Các subclass/implementors của sealed có thể nằm ở cùng package nhưng khác file,


// class bình thường ko có open hoặc abstract thì ko cho phép kế thừa

//open class
//open class Shape {
//
//    var counter = 0;
//    fun inc() {
//        counter++
//    }
//
//    open val area: Float = 0f
//    open val circumference: Float = 0f
//}


// abstract class Shape
//abstract class Shape {
//
//    var counter = 0;
//    fun inc() {
//        counter++
//    }
//
//    abstract val area: Float
//    abstract val circumference: Float
//}


// interface
sealed interface Shape {
    val area: Float
    val circumference: Float
}

fun sumArea(vararg shapes: Shape): Double {
    return shapes.sumOf { cur -> cur.area.toDouble() }
}


data class Rectangle(val width: Float, val height: Float) : Shape {
    val diagonal = sqrt(width * width + height * height)
    override val circumference: Float
        get() = 2 * (width + height)
    override val area = width * height
}

data class Circle(val radius: Float) : Shape {
    override val area = radius * radius * PI.toFloat()
    override val circumference: Float
        get() = 2 * PI.toFloat() * radius
    val diameter = 2 * radius
}

// function
fun maxArea(rec1: Rectangle, rec2: Rectangle): Float {
    val area1 = rec1.area
    val area2 = rec2.area
    return maxOf(area1, area2)
}


// enum class
enum class Country(val code: String) {
    GERMANY("DE"), USA("US"), FRANCE("FR")
}

fun greetMe(country: Country): String {
    return when (country) {
        Country.USA -> "hello from USA"
        Country.GERMANY -> "hello from Germany"
        Country.FRANCE -> "hello from France"
    }
}


// sigleton
object FixSizedSquare : Shape {
    override val area = 25f
    override val circumference = 20f
}


// TRONG KOTLIN ko có từ khoá static như JAVA, thay vào đó nó dùng singleton và companion object để thay thế
/*
* Companion:
* class User {
    companion object {
        const val MAX_USERS = 100 // Tương đương static final trong Java

        fun getTableName(): String {
            return "Users"
        }
    }
}

 Cách gọi: User.getTableName() hoặc User.MAX_USERS
* */


/*
* Acess modifier
*
*
* private (Riêng tư): Chỉ có thể truy cập được bên trong chính class khai báo nó hoặc cùng file nếu là top level
* protected (Được bảo vệ): Có thể truy cập trong class hiện tại và tất cả các class kế thừa (class con).
* internal (Nội bộ): Chỉ có thể truy cập được bên trong cùng một dự án/module (assembly).
* public (Công khai): Có thể truy cập được từ mọi nơi, không bị giới hạn.
*
* */

