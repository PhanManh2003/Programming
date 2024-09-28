/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

/**
 *
 * @author manhpthe172481
 */
public class Bird implements IFlyable, IEatable {

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }

    @Override
    public void eat() {
        System.out.println("Bird eats");
    }
}
