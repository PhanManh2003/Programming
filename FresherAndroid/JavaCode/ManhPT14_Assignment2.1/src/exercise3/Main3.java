package exercise3;

import java.util.Random;
import java.util.Scanner;


/*
Initialize an array with 10 elements, index from 0 to 9.

The request needs to handle the exception when we are trying 
to access the element with index 11 and print
the message to the user.

Index is received from the keyboard and displays the value according to
the index entered by the user
 */
public class Main3 {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        System.out.println("Array của bạn");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random 0-99
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Mời bạn nhập index phần từ mảng"
                    + " mà bạn muốn truy cập: ");
            int index = Integer.parseInt(scanner.nextLine());
            int value = numbers[index];
            System.out.println("Value tại index là: " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  LỖI: index ko hợp lệ. chỉ từ 0-9 thôi!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
