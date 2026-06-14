import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class UserManager {
    // use arraylist
    private val users: ArrayList<User> = ArrayList()

    // add user
    suspend fun addUser(user: User) {
        val job = GlobalScope.launch {
            val delayMs = Random.nextLong(500, 2001)
            println("  Wait  ${delayMs}ms before adding user ${user.name} ")
            delay(delayMs)
            users.add(user)
        }

        job.join() // wait
    }

    // display user
    fun displayUsers() {
        users.forEachIndexed { index, user ->
            println("User ${index + 1}: $user")
        }
    }

    // find user by name
    fun findUsersByName(name: String): List<User> {
        return users.filter { it.name.equals(name, ignoreCase = true) }
    }

    //use lambda to sort list users by name
    fun sortUser(): Unit {
        this.users.sortBy { it.name }
    }

    // length
    fun getSize() : Int {
        return this.users.size
    }

}