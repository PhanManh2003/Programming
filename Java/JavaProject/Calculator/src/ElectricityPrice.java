
import java.util.Scanner;

public class ElectricityPrice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Moi ban nhap so kWh cua minh:");
            int kwh = sc.nextInt();
            double totalPrice = calculateTotalPrice(kwh);
            System.out.println("Gia: " + totalPrice);
            System.out.println("quit ?:  ");
            sc.next();
            String ans = sc.nextLine();
            if (ans.equals("y")) {
                break;
            }
        }
        sc.close();
    }

    public static double calculateTotalPrice(double kwh) {
        double totalPrice = 0;
        if (kwh < 0) {
            System.out.println("Nhap >=0!");
            return 0;
        }
        if (0 <= kwh && kwh <= 500) {
            totalPrice = kwh * 1000;
        } else if (501 <= kwh && kwh <= 1000) {
            totalPrice = kwh * 1500;
        } else if (1001 <= kwh && kwh <= 1500) {
            totalPrice = kwh * 2000;
        } else if (1501 <= kwh) {
            totalPrice = kwh * 3000;
        } else {
        }
        return totalPrice;
    }
}
