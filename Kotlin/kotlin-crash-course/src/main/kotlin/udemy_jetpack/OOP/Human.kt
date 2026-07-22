package udemy_jetpack.OOP

open class Human {
    lateinit var name: String
    var year = 0

    constructor(name: String, year: Int) {
        this.year = year
        this.name = name
    }

    open fun printInfo() {
        println("Name: $name, Year: $year")
    }
}

class Human2(var name: String, var year: Int) {

    fun printInfo() {
        println("Name: $name, Year: $year")
    }
}

class Student(var id: Int, name: String, year: Int) : Human(name, year) {
    override fun printInfo() {
        println("ID: $id, Name: $name, Year: $year")
    }
}

interface People {
    var name: String
    var year: Int
    fun printInfo()
}

class Teacher(name: String, year: Int) : People {
    override var name: String = name
        //field chính là biến lưu trữ giá trị thực của một property, dc dùng trong getter, setter để tránh đệ quy vô hạn
        get() = field
        set(value) {
            field = value
        }
    override var year: Int = year
        get() = field
        set(value) {
            field = value
        }

    override fun printInfo() {
        println("Name: $name, Year: $year")
    }

    // companion object giống static java
    companion object {
        fun doubleYear(t: Teacher): Teacher {
            return Teacher(t.name, t.year * 2)
        }
    }
}

enum class LoadingStatus {
    LOADING, FINISHED, ERROR
}

// là abstract class
sealed class Human3(val name: String, val year: Int) {
    class DefaultValue() : Human3("Default", 0)
}


// data class
data class Human4(val name: String, val year: Int) {
    // data class tự sinh ra equals(), hashCode(), toString(), copy() và componentN(), class thường thì ko
    // componentN() là hàm trả về giá trị của thuộc tính thứ N trong data class
    // vd: component1() trả về name, component2() trả về year
}