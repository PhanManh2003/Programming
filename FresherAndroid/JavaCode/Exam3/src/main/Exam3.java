package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        try {
            System.out.print("Input array size: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("number must > 0!  ");
            } else {
                int[] a = new int[n];
                // cho người dùng nhập
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter a[" + i + "]" + " : ");
                    a[i] = Integer.parseInt(scanner.nextLine().trim());
                    list.add(a[i]);
                }

                System.out.println("Input: " + Arrays.toString(a));

                // sort ascending 
                Collections.sort(list);

                // Input element to be inserted
                int x = getInt("The element to be inserted is ",
                        "Out of range", "Invalid number", Integer.MIN_VALUE,
                        Integer.MAX_VALUE);


                // Insert x at the correct position to keep sorted order
                int insertIndex = 0;
                while (insertIndex < list.size() && list.get(insertIndex) < x) {
                    insertIndex++;
                }
                list.add(insertIndex, x);
                System.out.println("after doing the sort");
                // Output result
                System.out.println("Output: " + list);
            }

        } catch (NumberFormatException e) {
            System.out.println("please enter a valid integer number ");
        }
        scanner.close();
    }

    // hàm nhập số nguyên
    public static int getInt(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (Exception e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
