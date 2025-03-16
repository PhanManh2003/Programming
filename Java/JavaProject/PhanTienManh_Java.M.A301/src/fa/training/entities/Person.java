package fa.training.entities;

public abstract class Person {

    private String name;
    private String gender;
    private String phone;
    private String email;
    private String birthDate;

    public Person() {
    }

    public Person(String name, String gender, String phone, String email, 
            String birthDate) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract void purchaseParkingPass();
}
