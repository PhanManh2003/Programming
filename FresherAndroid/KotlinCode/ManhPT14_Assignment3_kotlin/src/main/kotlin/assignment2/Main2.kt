package assignment2

// Enter an string. Count the number of words in the string. Capitalize the first letter of the
//word if it begins for a sentence

fun main() {
    print("Nhap chuoi: ")
    val input = readLine()!!.trim()

    // Dem so tu
    val words = input.split(Regex("\\s+")).filter { it.isNotEmpty() }
    println("So tu: ${words.size}")

    // Viet hoa chu cai dau moi cau (sau dau . ! ?)
    val result = input
        .split("(?<=[.!?])".toRegex()) // split after . ! ?
        .map { sentence ->
            sentence.trimStart().replaceFirstChar {
                if (it.isLowerCase()) it.titlecase()
                else it.toString()
            }
        }
        .joinToString(" ")

    println("Result:")
    println(result)
}