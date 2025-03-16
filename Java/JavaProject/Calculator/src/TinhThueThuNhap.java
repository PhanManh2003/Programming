
import java.util.Scanner;

public class TinhThueThuNhap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Moi ban nhap vao muc luong cua minh:");
        int salary = sc.nextInt();
        
        System.out.println("Moi ban nhap so nguoi phu thuoc:");
        int nod = sc.nextInt();
        
        double tax = TinhThueThuNhapCaNhan(nod, salary);
        System.out.println("So thue thu nhap ca nhan phai dong la: " + tax);
        
        sc.close();
    }

    public static double TinhThueThuNhapCaNhan(int nod, int salary) {
        final int STANDARD_DEDUCTION = 9000000;  // mức lương tối thiểu mà ko phải đóng thuế 
        final int DEPENDENT_DEDUCTION = 4000000;// giảm trừ cho 1 người phụ thuộc 
        
        double taxableIncome = salary - STANDARD_DEDUCTION - (nod * DEPENDENT_DEDUCTION);

        if (taxableIncome <= 0) {
            return 0;  // No tax if taxable income is less than or equal to 0
        } else if (taxableIncome <= 5000000) {
            return 0.05 * taxableIncome;  // 0.05
        } else if (taxableIncome <= 10000000) {
            return 0.1 * taxableIncome;
        } else if (taxableIncome <= 18000000) {
            return 0.15 * taxableIncome;
        } else if (taxableIncome <= 25000000) {
            return 0.2 * taxableIncome;
        } else {
            return 0.25 * taxableIncome;
        }
    }
}