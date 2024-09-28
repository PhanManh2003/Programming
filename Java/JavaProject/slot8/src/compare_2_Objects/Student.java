/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compare_2_Objects;

/**
 *
 * @author manhpthe172481
 */
public class Student {

    public int id;
    public String name;
    public String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Student) obj).id;
    }
}
