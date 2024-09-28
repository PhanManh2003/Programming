
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manhpthe172481
 */
public class part3 {

    public static void main(String[] args) {
        // Initialize the list
        String[] list = new String[10];
        
        // input name
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter name of student" + (i+1) + ": ");
            Scanner sc = new Scanner(System.in);
            list[i] = sc.nextLine().trim().replaceAll("\\s+", " ");
        }
        // convert name to uppercase
        for (int i = 0; i < 10; i++) {
            list[i] = list[i].toUpperCase();
        }
        
        // print result
        System.out.println("\nList of student names in uppercase:");
        for (String name : list) {
            System.out.println(name);
        }
    }
}


