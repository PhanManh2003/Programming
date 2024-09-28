
import java.util.Scanner;

public class L2_part2 {
    
    /*
    
 Tại một thời điểm chỉ xảy ra một ngoại lệ và tại một thời điểm chỉ có một khối catch được thực thi. Khi exception đã bị bắt ở một catch thì các catch tiếp theo sẽ không được bắt.
Tất cả các khối catch phải được sắp xếp từ cụ thể nhất đến chung nhất (từ exception con đến exception cha), tức là phải khai báo khối lệnh catch để xử lý lỗi NullPointerException, ArithmeticException, … trước khi khai báo catch để xử lý lỗi Exception.
Khối lệnh finally luôn được thực thi dù chương trình có xảy ra ngoại lệ hay không (ngay cả sử dụng lệnh return).
Đối với mỗi khối try, có thể không có hoặc nhiều khối catch, nhưng chỉ có một khối finally.
Khối finally sẽ không được thực thi nếu chương trình bị thoát bằng cách gọi System.exit() hoặc xảy ra một lỗi (Error) không thể tránh khiến chương trình bị chết.
    */

    public static String inputString() throws Exception {
        String pattern = "SE\\d{3}";
        String s = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a string: ");
        s = sc.nextLine();
        if (!s.matches(pattern)) {
            throw new Exception();
        }
        return s;
    }

    public static void main(String[] args) {
        boolean cont = false;
        do {
            try {
                String s = inputString();
                System.out.println("the string is " + s);
                cont = false;
            } catch (Exception e) {
                System.out.println("the string is invalid");
                cont = true;
            }
        } while (cont);
    }
}

//
//public static void main(String[] args) {
//        boolean cont = false;
//        do {
//            try {
//                Scanner sc = new Scanner(System.in);
//                System.out.print("Enter a string: ");
//                String pattern = "SE\\d{3}";
//                String s = "";
//                s = sc.nextLine();
//                if (!s.matches(pattern)) {
//                    throw new Exception();
//                }
//                System.out.println("the string is " + s);
//                cont = false;
//            } catch (Exception e) {
//                System.out.println("the string is invalid");
//                cont = true;
//            }
//        } while (cont);
//    }
