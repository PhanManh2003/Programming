// InputHandler.kt
fun inputHostConfigs(): List<HostConfig> {
    val configs = mutableListOf<HostConfig>()
    println("Enter minimum 4 Host Config:")

    while (true) {
        val index = configs.size / 3 + 1
        println("\n Host Config #$index ---")

        print("IP: ")
        val ip = readLine()?.trim() ?: ""

        print("Port: ")
        val port = readLine()?.trim()?.toIntOrNull() ?: 0

        print("Type Connection (TCP/UDP/HTTP): ")
        val type = readLine()?.trim() ?: ""

        configs.add(HostConfig(ip, port, type))
        configs.add(HostConfig(ip, port + 1, type))
        configs.add(HostConfig(ip, port + 2, type))

        println("Added 3 Host Config (port $port, ${port + 1}, ${port + 2})")

        if (configs.size >= 12) {
            print("\nFull 4 input. Continue? (y/n): ")
            if (readLine()?.trim()?.lowercase() != "y") break
        }
    }

    return configs
}