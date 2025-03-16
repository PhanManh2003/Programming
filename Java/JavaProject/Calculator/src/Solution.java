
import java.util.Arrays;

public class Solution {
//    //1. plusOne
//  public static int[] plusOne(int[] digits) {
//        for(int i = digits.length-1; i>=0;i--){
//            if(digits[i]==9){
//                digits[i] =0;
//            } else {
//                digits[i] +=1;
//                return digits;
//            }
//
//        }
//        // Truong hop: 9 -> 10; 99-> 100
//        digits = new int[digits.length+1]; // 
//        digits[0] =1;
//        return digits;
//    }
//    
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
//    }

    // 2. addBinary
//    public static String addBinary(String a, String b) {
//        // need a carry variable,
//        // need to make 2 string equals length
//        // loop through the length and use StringBuilder to create a result string
//
//        // make 2 string equal in length
//        int aLength = a.length();
//        int bLength = b.length();
//        StringBuilder builder;
//        if (aLength > bLength) {
//            builder = new StringBuilder(b);
//            for (int i = 1; i <= aLength - bLength; i++) {
//                builder.insert(0, "0");
//            }
//            b = builder.toString();
//        } else if (a.length() < b.length()) {
//            builder = new StringBuilder(a);
//            for (int i = 1; i <= bLength - aLength; i++) {
//                builder.insert(0, "0");
//            }
//            a = builder.toString();
//        }
//
//        // 
//        StringBuilder result = new StringBuilder();
//        int carry = 0;
//        for (int i = a.length() - 1; i >= 0; i--) {
//            switch (Character.getNumericValue(a.charAt(i))
//                    + Character.getNumericValue(b.charAt(i)) + carry) {
//                case 0:
//                    result.append("0");
//                    carry = 0;
//                    break;
//                case 1:
//                    result.append("1");
//                    carry = 0;
//                    break;
//                case 2:
//                    result.append("0");
//                    carry = 1;
//                    break;
//                case 3:
//                    result.append("1");
//                    carry = 1;
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        }
//        if (carry == 1) {
//            result.append("1");
//        }
//        return result.reverse().toString();
//    }
//  
    public static String addBinary(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int c = 0, base = 2;
        StringBuilder result = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || c == 1) {
            // t1 và t2 lần lượt là chữ số hiện tại từ chuỗi a và b. ( reset = 0 sau mỗi lần lặp )
            int t1 = 0, t2 = 0; 
            // Khi thực hiện phép trừ giữa hai ký tự, Java chuyển ký tự đó thành
            // giá trị số nguyên tương ứng trong bảng mã ASCII.
            if (n1 >= 0) {
                t1 = a.charAt(n1--) - '0'; // -
            }
            if (n2 >= 0) {
                t2 = b.charAt(n2--) - '0';
            }

            int sum = t1 + t2 + c; // Compute sum of current digits + carry
            c = sum / base; // Update carry
            result.append(sum % base); // Append the remainder (0 or 1) to result
        }

        return result.reverse().toString();
    }
//    public static void main(String[] args) {
//        System.out.println("ketqua: " + addBinary("11", "1"));
//        System.out.println("ketqua: " + addBinary("1010", "1011"));
//    }
}
