/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
/* An anagram is a word or a phrase made by transposing the letters of another word or phrase; 
for example, "parliament" is an anagram of "partial men," and "software" is an anagram of "swear oft." 
Write a program that figures out whether one string is an anagram of another string. 
The program should ignore white space and punctuation. */
public class Anagram {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str_1, str_2;
        System.out.println("Enter string 1: ");
        str_1 = sc.nextLine();
        System.out.println("Enter string 2: ");
        str_2 = sc.nextLine();

        // Đưa về in thường
        str_1 = str_1.toLowerCase();
        str_2 = str_2.toLowerCase();

        // Loại bỏ khoảng trắng và dấu chấm câu
        str_1 = str_1.replaceAll("[\\s.,;'\"]", "");
        str_2 = str_2.replaceAll("[\\s.,;'\"]", "");

        // Tạo mảng kí tự
        char[] words_1 = str_1.toCharArray();
        char[] words_2 = str_2.toCharArray();

        // Sort 2 mảng
        Arrays.sort(words_1);
        Arrays.sort(words_2);

        // So sánh 2 mảng
        boolean isAnagram = Arrays.equals(words_1, words_2);
        System.out.println("isAnagram: " + isAnagram);

    }
}
