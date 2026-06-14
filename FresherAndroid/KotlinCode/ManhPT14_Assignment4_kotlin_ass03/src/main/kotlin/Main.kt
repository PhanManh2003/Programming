fun main() {
    val configs = inputHostConfigs()

    while (true) {
        val choice = showMenu()
        val filtered = filterConfigs(configs, choice)
        showConfigs(filtered)

        print("\nFind more? (y/n): ")
        if (readLine()?.trim()?.lowercase() != "y") break
    }

    println("Exit.")
}