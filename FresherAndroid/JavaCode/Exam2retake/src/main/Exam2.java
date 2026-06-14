
package main;

/*
Write a program to list the integers with 5 to 7 digits that satisfy:
a) Being a prime number.
b) Being a palindrome number. (ex 77377, 3223223...)
c) Having all digits as prime numbers.
d) Having a prime number as the sum of its digits. (ex The sum of 5-digit prime numbers is: 8363)
* */
public class Exam2 {
    public static void main(String[] args) {
        for (int i = 10000; i <= 9999999; i++) {
            if (isPrime(i) && isPalindrome(i) && hasAllDigitPrime(i) && hasSumPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // check prime function
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        // check n = 2
        if (n % 2 == 0) return false;
        // check n từ 3 trở đi , chỉ tính số lẻ
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // check being a palindrome number
    public static boolean isPalindrome(int n) {
        String numStr = String.valueOf(n);
        // reverse string == string ?
        return numStr != null
                && new StringBuilder(numStr).reverse().toString().equals(numStr);
    }

    // check having all digits as prime numbers
    public static boolean hasAllDigitPrime(int n) {
        // chuyển n ->   chuỗi -> duyệt chỗi rồi check value ở giá trị đó
        String numStr = String.valueOf(n);
        int length = numStr.length();

        // duyệt
        for (int i = 0; i < length; i++) {
            // lấy giá trị tại index
            String digit = numStr.substring(i, i + 1);
            int value = Integer.parseInt(digit);
            // check prime digit value
            if (!isPrime(value)) {
                return false;
            }

        }
        return true;
    }

    // check having sum is a prime
    public static boolean hasSumPrime(int n) {
        int s = 0;
        String numStr = String.valueOf(n);
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            String digit = numStr.substring(i, i + 1);
            int value = Integer.parseInt(digit);
            s += value;
        }
        return isPrime(s);
    }
}
