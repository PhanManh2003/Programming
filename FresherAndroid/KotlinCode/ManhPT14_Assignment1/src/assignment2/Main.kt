package assignment2

fun main() {
    // Thêm contact mới
    val newContact = Contact<ContactInformation>("Jerry").apply {
        addInfo(ContactInformation.PhoneNumber("0987654321"))
        addInfo(ContactInformation.EmailAddress("jerry@example.com"))
        addInfo(ContactInformation.SocialMediaAccount("Instagram", "@jerry_ig"))
    }
    ContactManager.addContact(newContact)

    // Hiển thị tất cả
    ContactManager.displayAll()

    // Tìm kiếm
    println("\n----SEARCH-----")
    val found = ContactManager.findByName("Alice")
    if (found != null) {
        println("Found:")
        found.display()
    } else {
        println("Not found.")
    }
}