import kotlin.reflect.full.*
import kotlin.reflect.jvm.isAccessible

fun main() {
    // tạo object để tí nữa lấy từ reflection
    val person = People(
        age = 24,
        gender = "Male"
    )
    val rClass = People::class

    println("PROPERTIES:")
    rClass.declaredMemberProperties.forEach { prop ->
        prop.isAccessible = true  // bypass private field
        println("${prop.name} = ${prop.getter.call(person)}")
    }

    println("\nFUNCTIONS:")
    rClass.declaredMemberFunctions.forEach { func ->
        func.isAccessible = true  // bypass private field
        println("${func.name}() = ${func.call(person)}")
    }
}