package exercise1;

import java.util.Random;
import java.util.Scanner;

/*
Create an array of 10 random integers

Write a Program that will let the user input an index of the array and
then output the value of that array to the console.
Functional Requirements:

Needs to catch exceptions that may occur in the program.
 */
public class Main1 {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        System.out.println("Array của bạn");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random 0-99
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        //Try-with-resources tự động close Scanner  
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("\nNhập index (0-9) hoặc -1 để thoát: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    // Kiểm tra thoát
                    if (index == -1) {
                        System.out.println("Thoát chương trình.");
                        break;
                    }

                    // Truy cập array - có thể throw ArrayIndexOutOfBoundsException
                    int value = numbers[index];
                    System.out.println(" Giá trị tại index " + index + ": " + value);

                } catch (NumberFormatException e) {
                    System.out.println("   LỖI: Vui lòng nhập số nguyên hợp lệ!");
                    System.out.println("   Bạn đã nhập: không phải số");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("   LỖI: Index không hợp lệ!");
                    System.out.println("   Index phải từ 0 đến " + (numbers.length - 1));
                    System.out.println("   Chi tiết: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("  LỖI: Đã xảy ra lỗi không mong muốn!");
                    System.out.println("   Chi tiết: " + e.getMessage());
                }
            }
        }
    }
}
