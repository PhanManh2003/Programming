import java.util.Scanner;


public class QuadraticEquationSolver {

    // 1. Biến không sử dụng
    private int unusedVar = 5;

    public static void main(String[] args) {
        QuadraticEquationSolver solver = new QuadraticEquationSolver();
        solver.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        // 2. Không kiểm tra null
        System.out.println("Enter coefficient a: ");
        String inputA = scanner.nextLine();
        double a = Double.parseDouble(inputA);  // Không kiểm tra đầu vào có hợp lệ hay không

        System.out.println("Enter coefficient b: ");
        String inputB = scanner.nextLine();
        double b = Double.parseDouble(inputB);  // Không kiểm tra lỗi NumberFormatException

        System.out.println("Enter coefficient c: ");
        String inputC = scanner.nextLine();
        double c = Double.parseDouble(inputC);  // Không kiểm tra lỗi NumberFormatException

        // 3. Chia cho 0 (nếu a = 0 không được xử lý)
        double discriminant = b * b - 4 * a * c;

        // 4. Đã loại bỏ phương thức lỗi thời Thread.stop()

        // 5. Lỗi khi tính sqrt với số âm (nếu discriminant < 0)
        double sqrtDiscriminant = Math.sqrt(discriminant);

        // 6. Không xử lý trường hợp a = 0 (không phải phương trình bậc 2)
        if (a == 0) {
            System.out.println("This is not a quadratic equation");
        } else {
            // 7. Biến không sử dụng
            int unusedVariable = 100;

            // 8. Lỗi off-by-one khi in kết quả
            double root1 = (-b + sqrtDiscriminant) / (2 * a);
            double root2 = (-b - sqrtDiscriminant) / (2 * a);
            System.out.println("Root 1: " + root1);  // Chỉ in ra 1 nghiệm
            System.out.println("Root 2: " + root2);

            // 9. Vòng lặp không cần thiết
            for (int i = 0; i < 1; i++) {
                System.out.println("Looping once unnecessarily");
            }
        }

        // 10. Chia cho 0 có thể xảy ra nếu a = 0
        double result = 10 / a;

        // 11. Biến toàn cục không an toàn trong môi trường đa luồng
        globalCount++;

        // 12. Không kiểm tra giá trị đầu vào của hàm squareRoot
        double value = squareRoot(-25);  // Số âm không thể có căn bậc hai thực

        // 13. Sử dụng StringBuilder mà không đồng bộ trong môi trường đa luồng
        StringBuilder sb = new StringBuilder();
        sb.append("Unsafe in multithreading");

        // 14. Không đóng Scanner gây ra resource leak
        // scanner.close();

        // 15. Bắt tất cả ngoại lệ chung chung
        try {
            int res = divide(10, 0);  // ArithmeticException
        } catch (Exception e) {
            e.printStackTrace();  // In stack trace mà không xử lý lỗi
        }

        // 16. Mật khẩu hardcoded
        String password = "password123";

        // 17. Biến không sử dụng
        int x = 10;

        // 18. Sử dụng vòng lặp vô hạn mà không có điều kiện thoát
        while (true) {
            break;  // Phá vỡ vòng lặp ngay lập tức mà không có lý do
        }

        // 19. So sánh chuỗi sai cách
        String str1 = "hello";
        String str2 = new String("hello");
        if (str1 == str2) {  // Sử dụng == thay vì equals()
            System.out.println("Strings are equal");
        }

        // 20. Lỗi khi so sánh số thực (vấn đề độ chính xác)
        double d1 = 0.1 + 0.2;
        if (d1 == 0.3) {  // Có thể xảy ra sai số
            System.out.println("Số thực bằng nhau");
        }
    }

    // Hàm hỗ trợ
    public int divide(int a, int b) {
        return a / b;  // Có thể xảy ra chia cho 0
    }

    // 12. Hàm tính căn bậc hai không kiểm tra giá trị đầu vào
        public double squareRoot(double x) {
            return Math.sqrt(x);  // Sẽ ném IllegalArgumentException nếu x < 0
        }

    // Biến toàn cục không an toàn trong môi trường đa luồng
    private static int globalCount = 0;
}
