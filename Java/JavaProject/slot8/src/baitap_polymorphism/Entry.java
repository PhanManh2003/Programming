/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap_polymorphism;

/**
 *
 * @author manhpthe172481
 */
public class Entry {
    // one thing in many form = polymorphism ( overiding, overloading, biến thuộc lớp cha với nhiều form)
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Animal();
        animals[1] = new Dog();
        animals[2] = new Cat();
        animals[3] = new Duck();
        for (int i = 0; i < 4; i++) {
            animals[i].sound();
        }
    }
}
