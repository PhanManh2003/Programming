package Recursion;

public class Main {

    /*
    There are 3 basic rules for developing recursive algorithms.
        • Know how to take one step.
        • Break each problem down into one step plus a smaller problem.
        • Know how and when to stop.
    */
    public static void main(String[] args) {
        DecToBin(11); // output: 1011
    }

    public static void DecToBin(int n) {
        int q = n / 2;	// One step
        int r = n % 2;	// One step
        if (q > 0) {
            DecToBin(q); // smaller problem
        }
        System.out.print(r); // after all recursive calls have been
        // made last remainder printed first
    }

}
