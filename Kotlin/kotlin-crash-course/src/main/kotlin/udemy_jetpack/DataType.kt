package udemy_jetpack

/*


1. Primitive types (được  JVM tối ưu thành primitive khi có thể, vẫn chỉ là reference type)
Int
Long
Short
Byte
Float
Double
Char
Boolean

2. Reference types
String
Array
List
MutableList
Set
MutableSet
Map
MutableMap
Any ( mọi class đều kế thừa tu Any)
Enum
Interface
Class
Function types (() -> Unit, (Int) -> String, ...)
Data class
Object declaration
Sealed class
Sealed interface
Annotation class
Companion Object

Pair
Triple
Result
Sequence

-couroutine reference type:
Flow
StateFlow
SharedFlow
Channel
 */

fun main() {
    var j: Byte = 10
    println("$j")

    val b = true
    println("$b")

    // pair
    var p = Pair(1, "one")
    var p2 = Pair<Int, String>(1, "one")
    var p3 : Pair<Int, String>? = Pair(1, "one") // ? để p3 có thể null

    var (e1, e2) = p3!! // chắc chắn p3 ko null để có thể destructuring dc
    // triple
    var tr = Triple(1, "one", "two")
    var tr2 = Triple<Int, String, String>(1, "one", "two")
    var tr3 : Triple<Int, String, String>? = Triple(1, "one", "two")
    println("$e1 $e2 ${tr.second}")

    // collection

    var l1 = listOf(1,2)
    var l2 = mutableListOf("one","two")
    l2.removeIf { it == "two" }
    println("$l1 $l2")

    var set1 = setOf(1,2,3)
    var set2 = mutableSetOf(1,2,3)

    var map1 = mapOf(1 to "one",2 to "two")
    var map2 = mutableMapOf(1 to "one",2 to "two")
    map2.put(3, "three")
    print("$map1 ${map2.containsKey(4)}")
}