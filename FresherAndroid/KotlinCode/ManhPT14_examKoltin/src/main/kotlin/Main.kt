suspend fun main() {
    val userManager = UserManager()


    var choice = 0;
    do {
        println(
            """ user management
            1. add user
            2. display user
            3. find user by name
            4. sort user
            5. exit
        """.trimIndent()
        )
        print("Enter choice: ")
        choice = readln()?.toInt() ?: 5
        when (choice) {
            1 -> addUser(userManager)
            2 -> displayUsers(userManager)
            3 -> findUserByName(userManager)
            4 -> sortUser(userManager)
            5 -> return
            else -> println("Not valid choice ")
        }
    } while (choice != 5)


}

suspend fun addUser(userManager: UserManager) {
    print("Enter name: ")
    val name = readLine()!!
    print("Enter age: ")
    val age = readln()?.toInt() ?: 0
    print("Enter email: ")
    val email = readLine()!!
    val newUser = User(name, age, email)
    userManager.addUser(newUser)
}

//
fun displayUsers(userManager: UserManager) {
    if(userManager.getSize() == 0){
        println("No users found")
    }
    userManager.displayUsers()
}

// find user
fun findUserByName(userManager: UserManager) {
    print("Enter name: ")
    val name = readLine()!!
    var found : List<User> = listOf()
     found = userManager.findUsersByName(name)
    if(found.size == 0) {
        println("No users found")
    } else{
        println("Found ${found.size} users")
        println(found)
    }
}

// display sort User
fun sortUser(userManager: UserManager) {
    userManager.sortUser()
    userManager.displayUsers()
}