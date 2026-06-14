
// show menu
fun showMenu(): Int {
    println(
        """
Show information of host configs
1. by IP
2. by Port
3. by Type Connection
4. by Host Config (IP + Port + Type)
5. Display all
"""
    )
    print("Choose: ")
    return readLine()?.trim()?.toIntOrNull() ?: 5
}

// show configs
fun showConfigs(configs: List<HostConfig>) {
    println("\n---- Result (${configs.size} items) ----")
    if (configs.isEmpty()) {
        println("Not found.")
    } else {
        configs.forEachIndexed { i, config ->
            println("${i + 1}. IP: ${config.ip} | Port: ${config.port} " +
                    "| Type: ${config.typeConnection}")
        }
    }
}