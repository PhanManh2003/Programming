package main;

import operatorOverload.MyKotlinFunctionsKt;

public class Main {
    public static void main(String[] args) {
        long a = 6;
        long b = 2;

        System.out.println("Cong: " + MyKotlinFunctionsKt.add(a, b));

        System.out.println("Tru: " + MyKotlinFunctionsKt.subtract(a, b));

        System.out.println("Nhan: " + MyKotlinFunctionsKt.multiply(a, b));

        System.out.println("Chia: " + MyKotlinFunctionsKt.divide(a, b));
    }
}
