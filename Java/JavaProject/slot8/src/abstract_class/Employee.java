/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstract_class;

/**
 *
 * @author manhpthe172481
 */
public class Employee extends Person {

    private int salary;

    public Employee(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public void display() {
        System.out.println("Employee name: " + super.getName());
        System.out.println("Employee address: " + super.getAddress());
        System.out.println("Employee salary: " + salary);
    }
}
