class UserManager {
    // use arraylist
    private val users: ArrayList<User> = ArrayList()

    // add user
    fun addUser(user: User) {
        users.add(user)
        println("Added $user successfully.")
    }

    // display user
    fun displayUsers() {
        users.forEachIndexed { index, user ->
            println("User ${index + 1}: $user")
        }
    }

    // find user by name
    fun findUserByName(name: String): User? {
        return users.find { it.name.equals(name, ignoreCase = true) }
    }

    //use lambda to sort list users by name
    fun getSortedUsers(): List<User> {
        return users.sortedBy { it.name }
    }

    // display sorted user
    fun displaySortedUsers() {
        getSortedUsers().forEachIndexed { index, user ->
            println("${index + 1}: $user")
        }
    }


}