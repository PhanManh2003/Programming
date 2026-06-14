package assignment2

object SampleDirectory {
    val contacts = listOf(
        Contact<ContactInformation>("Alice").apply {
            addInfo(ContactInformation.PhoneNumber("0901234567", "Mobile"))
            addInfo(ContactInformation.EmailAddress("alice@gmail.com", "Personal"))
        },
        Contact<ContactInformation>("Bob").apply {
            addInfo(ContactInformation.PhoneNumber("0912345678", "Mobile"))
            addInfo(ContactInformation.SocialMediaAccount("Facebook", "bob.fb"))
        },
        Contact<ContactInformation>("Charlie").apply {
            addInfo(ContactInformation.EmailAddress("charlie@company.com", "Work"))
            addInfo(ContactInformation.SocialMediaAccount("LinkedIn", "charlie-linkedin"))
        }
    )
}