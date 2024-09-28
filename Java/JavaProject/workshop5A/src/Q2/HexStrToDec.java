/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class HexStrToDec {

    public static int hexValue(char c) {
        int value = 0;
        switch (c) {
            case '1':
                value = 1;
                break;
            case '2':
                value = 2;
                break;
            case '3':
                value = 3;
                break;
            case '4':
                value = 4;
                break;
            case '5':
                value = 5;
                break;
            case '6':
                value = 6;
                break;
            case '7':
                value = 7;
                break;
            case '8':
                value = 8;
                break;
            case '9':
                value = 9;
                break;
            case 'A':
                value = 10;
                break;
            case 'B':
                value = 11;
                break;
            case 'C':
                value = 12;
                break;
            case 'D':
                value = 13;
                break;
            case 'E':
                value = 14;
                break;
            case 'F':
                value = 15;
                break;
        }
        return value;
    }

    public static int hexStringToDecimal(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            value = value * 16 + hexValue(str.charAt(i));
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a hexadecimal string: ");
        String hexString = sc.nextLine();
        int decimalValue;
        if (isHexString(hexString)) {
            decimalValue = hexStringToDecimal(hexString);
            System.out.println("Base-10 value: " + decimalValue);
        } else {
            System.out.println("Error: Not a valid hexadecimal string.");
        }
    }

    public static boolean isHexString(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toUpperCase(str.charAt(i));
            if (!isHexDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F');
    }
}
