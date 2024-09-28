  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toString;

/**
 *
 * @author manhpthe172481
 */
public class Student {

    private String name;
    private String address;
    private double gpa;

    public Student(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

// bạn hoàn toàn có thể sử dụng phương thức toString() để thay thế cho phương thức display() 
    @Override
    public String toString() {
        return "Name: " + name + ", address: " + address + ", gpa: " + gpa;
    }

}
