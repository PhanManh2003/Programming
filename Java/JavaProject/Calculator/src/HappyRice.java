
import java.util.Scanner;


public class HappyRice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so kg cua minh:");
        double kg = sc.nextDouble();
        double totalPrice = calculateTotalPrice(kg);
        System.out.println("So tien la: " + totalPrice);
        sc.close();
    }

    public static double calculateTotalPrice(double kg) {
        final double PRICE_PER_KG = 25000;
        double totalPrice = PRICE_PER_KG * kg;
        if (kg > 10 && kg <= 50) {
            totalPrice *= 0.95;  // 5% discount
        } else if (kg > 50) {
            totalPrice *= 0.90;  // 10% discount
        }
        return totalPrice;
    }
}
