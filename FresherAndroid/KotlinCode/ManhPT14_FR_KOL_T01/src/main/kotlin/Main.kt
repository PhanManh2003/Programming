import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() {
    val userManager = UserManager()


    val demoUsers = listOf(
        User("Manh", 20, "manhpt20@fpt.com"),
        User("Long", 21, "longpt21@fpt.com"),
        User("Nam", 55, "nampt55@fpt.com"),
        User("Binh", 23, "binhpt23@fpt.com"),
    )

     // add asrynchronous
    suspend fun addUserWithDelays(userManager: UserManager, usersToAdd: List<User>) {
        // trả về list job quản lí các couroutine rồi đợi các couroutine hoàn thành
        val jobs = usersToAdd.map { user ->
            GlobalScope.launch {
                val delayMs = Random.nextLong(500, 2001)
                println("  Wait  ${delayMs}ms before adding user ${user.name} ")
                delay(delayMs)
                userManager.addUser(user)
            }
        }
        // đợi tất cả couroutine complete
        jobs.forEach {
            it.join()
        }
    }



    // Add users asynchronously using coroutines
    addUserWithDelays(userManager, demoUsers)

    // hiển thị user sau khi add
    println("\nUsers after added:")
    userManager.displayUsers()

    // Find a user by name : Manh
    val userToFind = userManager.findUserByName("Manh")
    if (userToFind != null) {
        println("Finded: $userToFind")
    } else {
        println(" not found.")
    }

    // hiện thị sau khi sort
    println("\nUsers after sorted:")
    userManager.displaySortedUsers()



}
