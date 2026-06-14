package assignment2

// OBJECT DECLARATION
object ContactManager {
    private val contacts = mutableListOf<Contact<ContactInformation>>()

    init {
        contacts.addAll(SampleDirectory.contacts) // ← dùng SampleDirectory thay vì sampleDirectory
    }

    fun addContact(contact: Contact<ContactInformation>) {
        contacts.add(contact)
        println("Added contact: ${contact.name}")
    }

    fun displayAll() {
        println("\n===== CONTACT LIST (${contacts.size} contacts) =====")
        contacts.forEachIndexed { i, c ->
            print("[${i+1}] ")
            c.display()
        }
    }

    fun findByName(name: String) =
        contacts.find { it.name.equals(name, ignoreCase = true) }
}