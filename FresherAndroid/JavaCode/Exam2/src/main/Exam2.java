package main;

import java.util.Scanner;

/*
Write a program to list the integers with 5 to 7 digits that satisfy:
a) Being a prime number.
b) Being a palindrome number. (ex 77377, 3223223...)
c) Having all digits as prime numbers.
d) Having a prime number as the sum of its digits. (ex The sum of 5-digit prime numbers is: 8363)
 */
public class Exam2 {

    public static void main(String[] args) {
        for (int i = 10000; i <= 9999999; i++) {
            if (isPrime(i) && isPalindrome(i) && hasAllPrimeDigit(i) && hasPrimeSumDigits(i)) {
                System.out.println(i);
            }
        }
    }

    // check số nguyên tố
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        // 3. là số chẵn thì loại
        if (n % 2 == 0) {
            return false;
        }

        // 4.  
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false; // Found a factor, not prime
            }
        }

        return true; // No factors found,  prime
    }

    // check palindrome
    static boolean isPalindrome(int n) {
        String numStr = String.valueOf(n);
        return numStr != null
                && new StringBuilder(numStr).reverse().toString().equals(numStr);
    }

    // check having all digits as primes
    static boolean hasAllPrimeDigit(int n) {
        String numStr = String.valueOf(n);

        int numLength = numStr.length();
        for (int i = 0; i < numLength; i++) {
            // lấy giá trị ở digit
            String digit = String.valueOf(numStr.charAt(i));
            int value = Integer.parseInt(digit);
            if (!isPrime(value)) {
                return false;
            }
        }
        return true;
    }

    // check has sum digits as prime numbers
    static boolean hasPrimeSumDigits(int n) {
        int s = 0;
        s = sumDigits(n);
        return isPrime(s);
    }

    // calculate sumdigits
    static int sumDigits(int n) {
        // Chuyển thành chuỗi
        String numStr = String.valueOf(n);
        // biến tổng
        int s = 0;
        // duyệt rồi cộng dồn
        int numLength = numStr.length();
        for (int i = 0; i < numLength; i++) {
            // lấy giá trị ở digit
            String digit = String.valueOf(numStr.charAt(i));
            int value = Integer.parseInt(digit);
            s += value;
        }
        // trả về
        return s;
    }
}
