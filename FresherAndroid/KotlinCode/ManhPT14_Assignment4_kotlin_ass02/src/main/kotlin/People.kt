class People(val age: Int, private val gender: String) {
    private fun getGender(): String {
        return gender
    }
   // getAge tự động sinh public getter
}