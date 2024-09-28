
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manhpthe172481
 */
public class part2 {

    public static void main(String[] args) {
        float num1, num2;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number 1: ");
        num1 = sc.nextFloat();
        System.out.print("Input the number 2: ");
        num2 = sc.nextFloat();
        sc.nextLine();
        System.out.print("Input the operator(+-*/): ");
        op = sc.nextLine();

        switch (op) {
            case "+":
                System.out.println("the result of " + num1 + " " + op + " " + num2 + " = " + (num1 + num2));
                break;

            case "-":
                System.out.println("the result of " + num1 + " " + op + " " + num2 + " = " + (num1 - num2));
                break;

            case "*":
                System.out.println("the result of " + num1 + " " + op + " " + num2 + " = " + (num1 * num2));
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("");
                } else {
                    System.out.println("the result of " + num1 + " " + op + " " + num2 + " = " + (num1 / num2));
                }
                break;

            default:
                System.out.println("not valid!");
        }

      
    }
}
