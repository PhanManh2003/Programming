package exercise2;

import java.util.Scanner;

/*
Write a program to input 2 real numbers. Catch the exception so that when input
is not a number.

Write a function that divides 2 real numbers, which catches an exception 
if the divisor is 0, then the division
is invalid, and the program terminates.
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // cho nhập hết 2 số đến khi nào cả 2 đều hợp lệ thì mới tính 

        // khai báo 2 biến,
        double a, b, q;

        try {
            System.out.print("Nhập số bị chia: ");
            a = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập số chia: ");
            b = Double.parseDouble(scanner.nextLine());
            q = divideTwoNumber(a, b);
            System.out.println("Kết quả của phép chia: " + a + " / " + b + " = " + q);
        } catch (NumberFormatException e) {
            System.out.println("   LỖI: Vui lòng nhập số hợp lệ!");
            System.out.println("   Bạn đã nhập: không phải số");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(0); // terminate program
        } catch (Exception e) {
            System.out.println("  LỖI: Đã xảy ra lỗi không mong muốn!");
            System.out.println("   Chi tiết: " + e.getMessage());
        }

    }

    public static double divideTwoNumber(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Không được chia cho 0, Lỗi rồi !");
        }
        return a / b;

    }
}
