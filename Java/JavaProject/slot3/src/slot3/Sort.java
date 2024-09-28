/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot3;

import java.util.Arrays;

/**
 *
 * @author manhpthe172481
 */
public class Sort {

    public static final int NUMBERS[] = {5, 1, 2, 4, 3, 6, 7, 9, 8};

    public static void main(String[] args) {
        // Sorting Complete Array
        int arr1[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        // Sorting Part of an Array
        int arr2[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
        Arrays.sort(arr2, 2, 5);
        System.out.println(Arrays.toString(arr2));
        // Java 8 parallelSort
        int arr3[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
        Arrays.parallelSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
