fun filterByIp(configs: List<HostConfig>): List<HostConfig> {
    print("Enter IP to search: ")
    val ip = readLine()?.trim() ?: ""
    return configs.filter { it.ip == ip }
}

fun filterByPort(configs: List<HostConfig>): List<HostConfig> {
    print("Enter Port to search: ")
    val port = readLine()?.trim()?.toIntOrNull() ?: -1
    return configs.filter { it.port == port }
}

fun filterByType(configs: List<HostConfig>): List<HostConfig> {
    print("Enter Type Connection to search: ")
    val type = readLine()?.trim() ?: ""
    return configs.filter {
        it.typeConnection.equals(type, ignoreCase = true)
    }
}

fun filterByHostConfig(configs: List<HostConfig>): List<HostConfig> {
    print("Enter IP: ")
    val ip = readLine()?.trim() ?: ""

    print("Enter Port: ")
    val port = readLine()?.trim()?.toIntOrNull() ?: -1

    print("Enter Type Connection: ")
    val type = readLine()?.trim() ?: ""

    return configs.filter {
        it.ip == ip &&
                it.port == port &&
                it.typeConnection.equals(type, ignoreCase = true)
    }
}

fun filterConfigs(configs: List<HostConfig>, choice: Int): List<HostConfig> {
    return when (choice) {
        1 -> filterByIp(configs)
        2 -> filterByPort(configs)
        3 -> filterByType(configs)
        4 -> filterByHostConfig(configs)
        else -> configs
    }
}