/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package down_casting;

/**
 *
 * @author manhpthe172481
 */
public class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Bark");
    }

    void fetch() {
        System.out.println("Fetching...");
    }
}
