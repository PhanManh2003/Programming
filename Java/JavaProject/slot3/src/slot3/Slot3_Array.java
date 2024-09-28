/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slot3;

import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class Slot3_Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Declare array a of 10 integers
        int[] a = new int[n];

        // Use for loop to enter the values of elements in array
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Use for loop to display the entered values of elements in array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        // MẢNG 2 CHIỀU
        // Khai báo và khởi tạo mảng 2 chiều có kích thước cố định
        int[][] twoDArray1 = new int[3][4]; // Mảng 2 chiều có 3 hàng và 4 cột

        // Khai báo và khởi tạo mảng 2 chiều với các giá trị ban đầu
        int[][] twoDArray2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Khai báo mảng 2 chiều
        int[][] twoDArray;
        // Khởi tạo mảng với kích thước cụ thể
        twoDArray = new int[3][];
        // Khởi tạo từng hàng riêng lẻ
        twoDArray[0] = new int[]{1, 2, 3};
        twoDArray[1] = new int[]{4, 5, 6};
        twoDArray[2] = new int[]{7, 8, 9};

    }

}
