package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
Write a program to input a positive integer n and perform the following functions:
a) Calculate the sum of the digits of n.
b) Factorize n into prime factors.
c) List the divisors of n.
d) List the prime divisors of n.
 */
public class Exam1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Input Positive integer n: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("number must > 0!  ");
            } else {
                System.out.println("a) Sum of digits: " + sumDigits(n));
                System.out.println("b) Factorize: " + n + " = " + factorizeIntoPrimes(n));
                System.out.println("c) List the divisors of n: " + listDivisors(n) );
                System.out.println("d) List the prime divisors of n: " + listPrimeDivisor(n));
            }

        } catch (NumberFormatException e) {
            System.out.println("please enter a valid integer number ");
        }
        scanner.close();
    }

    // a.Calculate the sum of the digits of n.
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

    // b. Factorize n into prime factors.
    static String factorizeIntoPrimes(int n) {
        StringBuilder result = new StringBuilder("");
        if (n <= 1) {
            return "n ko có ước nguyên tố";
        }
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            // nếu n chia hết cho i và i là số nguyên tố
            if (isPrime(i) && (n % i == 0)) {
                int time = 0;
                while (n % i == 0) {
                    time += 1;
                    n /= i; // lọc hết n
                }
                // đưa ước và số lần vào map
                primeFactors.put(i, time);
            }
        }
        // trả về kết quả
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            result.append(key + "^" + value + " . ");
        }
        return result.toString();
    }

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

    // c. list divisor
    static String listDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors.toString();
    }

    // d. list prime divisor
    static String listPrimeDivisor(int n) {
        List<Integer> primeDivisors = new ArrayList<>();
        if (n <= 1) {
            return n + " has no prime divisor.";
        }
        // check xem 2 có thuộc prime divisor ko 
        if (n % 2 == 0) {
            primeDivisors.add(2);
            while (n % 2 == 0) {
                n /= 2; // chia n hết đi cho 2 để loại 2 ra
            }
        }

        // check từ 3 trở đi , chỉ check số lẻ , cho đến căn n
        for (int i = 3; i * i <= n; i++) {
            if (n % i == 0) {
                primeDivisors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        // nếu n là số nguyên tố
        if (n >= 2) {
            primeDivisors.add(n);
        }

        return primeDivisors.toString();

    }
}
