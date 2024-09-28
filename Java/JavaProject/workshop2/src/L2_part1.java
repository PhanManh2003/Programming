/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class L2_part1 {
    public static void main(String[] args) {
        boolean cont = false;
        do {
            try {
                int num;
                Scanner sc = new Scanner(System.in);
                System.out.print("enter a number: ");
                num = sc.nextInt();
                if (num < 1) {
                    throw new Exception();
                }
                System.out.println("the number is " + num);
                cont = false;
            } catch (Exception e) {
                System.out.println("the number is invalid");
                cont = true;
            }
        } while (cont);
    }
}
