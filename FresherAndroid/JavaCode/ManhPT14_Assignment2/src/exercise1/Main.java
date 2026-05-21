package exercise1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("  GIẢI PHƯƠNG TRÌNH BẬC 2: ax² + bx + c = 0");
        System.out.println("========================================");

        // Nhập hệ số
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();

        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();

        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();

        solveQuadratic(a, b, c);
        scanner.close();
    }

    /**
     *
     * method giải pt bậc 2 với 3 tham số
     *
     * @param: 3 tham số a , b, c
     * @return void : kết quả
     */
    public static void solveQuadratic(double a, double b, double c) {
        System.out.println("\n========== KẾT QUẢ ==========");
        // Trường hợp 1: a = 0 → Không phải phương trình bậc 2
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình vô số nghiệm (0 = 0)");
                } else {
                    System.out.println("Phương trình vô nghiệm (" + c + " = 0 vô lý)");
                }
            } else {
                // Phương trình bậc 1: bx + c = 0
                double x = -c / b;
                System.out.println("Phương trình bậc 1: " + b + "x + " + c + " = 0");
                System.out.printf("Nghiệm: x = %.4f\n", x);
            }
            return;
        }

        // Trường hợp 2: a ≠ 0 → Phương trình bậc 2
        // Tính delta
        double delta = b * b - 4 * a * c;

        System.out.printf("Delta = b^2 - 4ac = (%.2f)^2 - 4*(%.2f)*(%.2f) = %.2f\n",
                b, a, c, delta);

        if (delta < 0) {
            // Delta < 0: Vô nghiệm
            System.out.println("\nDelta < 0");
            System.out.println("Phương trình VÔ NGHIỆM (không có nghiệm thực)");

        } else if (delta == 0) {
            // Delta = 0: Nghiệm kép
            double x = -b / (2 * a);
            System.out.println("\nDelta = 0");
            System.out.println("Phương trình có NGHIỆM KÉP:");
            System.out.printf("   x1 = x2 = %.4f\n", x);

        } else {
            // Delta > 0: Hai nghiệm phân biệt
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);

            System.out.println("\nDelta > 0");
            System.out.println("Phương trình có HAI NGHIỆM PHÂN BIỆT:");
            System.out.printf("   x1 = (-b + √Δ) / 2a = (%.2f + %.4f) / %.2f = %.4f\n",
                    -b, sqrtDelta, 2 * a, x1);
            System.out.printf("   x2 = (-b - √Δ) / 2a = (%.2f - %.4f) / %.2f = %.4f\n",
                    -b, sqrtDelta, 2 * a, x2);
        }
    }
}
