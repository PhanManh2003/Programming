data class User(
    val name: String,
    val age: Int,
    val email: String,
) {
    override fun toString(): String {
        return "User(name='$name', age=$age, email='$email')"
    }
}