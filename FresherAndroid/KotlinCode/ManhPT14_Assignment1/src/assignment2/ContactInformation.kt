package assignment2

sealed class ContactInformation {
    abstract fun display(): String

    data class PhoneNumber(val number: String, val label: String = "Mobile") : ContactInformation() {
        override fun display() = "Phone ($label): $number"
    }

    data class EmailAddress(val email: String, val label: String = "Personal") : ContactInformation() {
        override fun display() = "Email ($label): $email"
    }

    data class SocialMediaAccount(val platform: String, val username: String) : ContactInformation() {
        override fun display() = "$platform: $username"
    }
}