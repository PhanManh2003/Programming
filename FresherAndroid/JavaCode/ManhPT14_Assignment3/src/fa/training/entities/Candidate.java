package fa.training.entities;
// Each candidate has flowing attributes: first name, last name, birth date, address, phone, email

import java.io.Serializable;
import java.util.Date;

public abstract class Candidate implements Serializable {
    // đặt version để khi class thay đổi thì vẫn đọc dc
    private static final long serialVersionUID = 1L;
    
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phone;
    private String email;

    // conosstructors
    public Candidate() {
    }

    public Candidate(String firstName, String lastName, Date birthDate, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //getter setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
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

    @Override
    public String toString() {
        return "Candidate{" + "firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

   

}
