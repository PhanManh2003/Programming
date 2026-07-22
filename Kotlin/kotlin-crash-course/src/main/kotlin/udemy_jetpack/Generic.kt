package udemy_jetpack

// generic là kiểu dữ liệu được tham số hoá
class MyClass<A, B>(var a: A, var b: B) {
    override fun toString(): String {
        return "MyClass data ${a!!::class.simpleName} - ${b!!::class.simpleName}"
    }

    fun doSomething(): A {
        return a
    }
}


/*
in và out trong Kotlin là variance của generic. Chúng quy định kiểu generic được phép sử dụng theo hướng nào.

Có một mẹo rất dễ nhớ:

out = chỉ xuất  dữ liệu ra ngoài.
in = chỉ nhận  dữ liệu từ bên ngoài.
* */
interface I<out T> {
    fun doSomething(): T
}

class O : I<String> {
    override fun doSomething(): String {
        return "O do something"
    }
}
// where trong Kotlin dùng để đặt ràng buộc (constraints)
// cho generic khi một kiểu generic phải thỏa nhiều điều kiện cùng lúc.
//fun <T> foo(value: T)
//        where T : Constraint1,
//              T : Constraint2 {
//    // ...
//}


/*
extension property :

 val ReceiverType.propertyName: Type
    get() = ...
* */
val <T> T.mySize: Int where T : String
    get() = this.length

fun main() {
    var list = listOf(1, 2, 3)
    var myClass: MyClass<String, Int> = MyClass("hello", 25)
    println(myClass)

    val str: I<String> = O()
    val obj: I<Any> = str
    println("helloworld".mySize)
}

/*
 :: class là reflection. Reflection cho phép chương trình truy cập thông tin về class, object, thuộc tính , ...
 trong lúc runtime vì ở compile time chương trình ko biết bạn sẽ làm việc với class nào. Ví dụ :
 fun printInfo(obj: Any) {
    println(obj::class.simpleName)
}
*/

