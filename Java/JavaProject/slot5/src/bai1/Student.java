/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class Student {

    String name;
    int age;

    public Student() {
    }

    public void getInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.nextLine();
        do {
            System.out.print("Enter age: ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age < 0) {
                    System.out.println("Tuoi phai > 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai kieu du lieu");
                sc.next(); // xóa kí tự enter trong bộ đệm
            }
        } while(true);
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

}
