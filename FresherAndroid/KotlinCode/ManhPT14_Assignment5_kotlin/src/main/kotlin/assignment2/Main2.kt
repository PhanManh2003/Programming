package assignment2

import kotlinx.coroutines.*

// Custom exceptions
class InvalidNumberException :
    Exception("Username must not contain numbers")

class InvalidSpecialCharacterException :
    Exception("Username must not contain special characters")

class InvalidLengthException :
    Exception("Username must be longer than 4 characters")

class InvalidUsernameException :
    Exception("Invalid username")

suspend fun checkNumber(username: String) = withContext(Dispatchers.Default) {
    if (username.any { it.isDigit() }) throw InvalidNumberException()
}

suspend fun checkSpecialChar(username: String) = withContext(Dispatchers.Default) {
    val specialChars = "!@#\$%^&*()_"
    if (username.any { it in specialChars }) throw InvalidSpecialCharacterException()
}

suspend fun checkLength(username: String) = withContext(Dispatchers.Default) {
    if (username.length <= 4) throw InvalidLengthException()
}

suspend fun validateUsername(username: String): Boolean {
    return try {
        coroutineScope {

            if (username.length > 16)
                throw InvalidUsernameException()

            if (username.any { it.isUpperCase() })
                throw InvalidUsernameException()

            val numberCheck = async {
                checkNumber(username)
            }

            val specialCheck = async {
                checkSpecialChar(username)
            }

            val lengthCheck = async {
                checkLength(username)
            }

            numberCheck.await()
            specialCheck.await()
            lengthCheck.await()

            true
        }
    } catch (e: Exception) {
        println(e.message)
        false
    }
}

fun main() = runBlocking {
    val testCases = listOf(
        "an",           // quá ngắn
        "validusername", // hợp lệ
        "user123",      // có số
        "user@name",    // có ký tự đặc biệt
        "UserName",     // có chữ hoa
        "thisusernameiswaytoolong"  // quá dài
    )

    testCases.forEach { username ->
        val result = validateUsername(username)
        println("'$username' → ${if (result) " Valid" else " Invalid"}\n")
    }
}