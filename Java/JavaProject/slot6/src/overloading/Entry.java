/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package overloading;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
        Student s2 = new Student("Quang");
        s2.display();
        Student s3 = new Student('m');
        s3.display();
        Student s4 = new Student("Thu", 'f');
        s4.display();
    }
}
