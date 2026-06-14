package assignment2

class Contact<T : ContactInformation>(val name: String)  {
    val list: MutableList<T> = mutableListOf()

    fun addInfo(info: T) = list.add(info)

    fun display() {
        println(" $name")
        list.forEach { println("   - ${it.display()}") }
    }
}