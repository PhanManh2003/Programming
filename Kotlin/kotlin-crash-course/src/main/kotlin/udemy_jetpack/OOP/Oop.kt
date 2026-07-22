package udemy_jetpack.OOP

fun main() {
    var human = Human("John", 25)
    human.printInfo()
    var student = Student(1, "Alice", 20)
    student.printInfo()

    var teacher = Teacher("Tâm", 23)
    teacher.printInfo()

    println(Teacher.doubleYear(teacher).year) // output: 46

    println(LoadingStatus.FINISHED)

    println(Human3.DefaultValue().name)

    var human4 = Human4("h4", 25)
    var human5 = human4.copy(name = "h5")
    println(human4.toString())
// nếu println(human.toString()) thì in ra địa chỉ object @@

}

