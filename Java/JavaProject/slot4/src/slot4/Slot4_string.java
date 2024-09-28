 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slot4;

import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class Slot4_string {

    // String 
    public static void main(String[] args) {

//        1. indexOf(): returns the starting position of the first occurrence of a String1 in String2.
//        >< lastIndexOf() returns the last occurrence of String1 in String2.
        String s1 = "Codelearn";
        System.out.println(s1.indexOf("learn"));
        System.out.println(s1.indexOf("black"));
        // còn contains() trả về boolean
        String str = "Hello, World!";
        boolean contains = str.contains("World");
        System.out.println(contains);

//        2. startsWith(), endsWidth()
        String s2 = "Codelearn";
        System.out.println(s2.startsWith("Code"));
        System.out.println(s2.startsWith("abc"));
        System.out.println(s2.endsWith("rn"));
        System.out.println(s2.endsWith("z"));

//        3. replace()
        System.out.println("Cod3l3arn".replace('3', 'e'));
        System.out.println("Blackcat".replace("Black", "White"));

//        4. toLowerCase(), toUpperCase()
        String s4 = "CoDeLeArN";
        System.out.println(s4.toUpperCase());
        System.out.println(s4.toLowerCase());
        System.out.println(s4);

//        5. substring(begin,end) [begin,end)
        String s5 = "Codelearn";
        System.out.println(s5.substring(0, 2));
        System.out.println(s5.substring(0, 4));
        System.out.println(s5.substring(4));

//        6. split()
        String s6 = "Welcome to codelearn!";
        String[] words = s6.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

//        7. toCharArray()
        String s7 = "Hello, World!";

        // Convert the string to a character array
        char[] charArray = s7.toCharArray();

        // Print each character in the array
        for (char c : charArray) {
            System.out.print(c + " ");
        }
//        8. compareTo(a,b) return số âm nếu chuỗi a nhỏ hơn chuỗi b 
        String s81 = "hello";
        String s82 = "hello";
        String s83 = "meklo";
        String s84 = "hemlo";
        System.out.println(s81.compareTo(s82)); // output: 0
        System.out.println(s81.equals(s82)); // output: true
        System.out.println(s81.compareTo(s83)); // output: -5
        System.out.println(s81.compareTo(s84)); // output: -1

//        9. equals(), equalsIgnoreCase()
        String s91 = "java";
        String s92 = "Java";
        System.out.println(s91.equals(s92));  // output: false
        System.out.println(s91.equalsIgnoreCase(s92)); // output: true

//        10. concat(String x)
        String s10 = "java string";
        System.out.println(s10);
        s10 = s10.concat(" is immutable so assign it explicitly");
        System.out.println(s10);

//        11. join()
        String joinString1 = String.join("-", "welcome", "to", "java");
        System.out.println(joinString1);

//        12. format()  được sử dụng để định dạng chuỗi theo một mẫu cụ thể.
        String sf3 = String.format("value is %32.12f", 32.33434);
        System.out.println(sf3);

//        13. Phương thức getBytes() trả về mảng byte của chuỗi.
        String s13 = "ABCDEFG";
        byte[] barr = s13.getBytes();
        for (int i = 0; i < barr.length; i++) {
            System.out.println(barr[i]);
        }
//        14. getchars() được sử dụng để sao chép một phần của chuỗi vào mảng ký tự khác
//    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
//    srcBegin: Vị trí bắt đầu trong chuỗi nguồn.
//    srcEnd: Vị trí kết thúc trong chuỗi nguồn.
//    dst: Mảng ký tự đích - nơi dữ liệu từ chuỗi nguồn được sao chép đến.
//    dstBegin: Vị trí bắt đầu trong mảng ký tự đích.
        String sourceString = "Hello, World!";
        // Tạo một mảng ký tự có độ dài bằng độ dài của chuỗi nguồn
        char[] destinationArray = new char[sourceString.length()];

        // Sao chép 1 phần của chuỗi nguồn vào mảng ký tự đích
        sourceString.getChars(0, sourceString.length(), destinationArray, 0);
        System.out.println(destinationArray);

//        15. intern()
        /* Trong Java, khi bạn sử dụng new String("hello"), Java tạo một đối tượng
    chuỗi mới bằng cách sử dụng từ khoá new. Dù chuỗi "hello" đã tồn tại trong String Pool
    hay không, new String("hello") sẽ luôn tạo một đối tượng mới trong bộ nhớ heap.

    String Pool là một phần của bộ nhớ JVM được sử dụng để lưu trữ những chuỗi được 
    tạo ra bằng cách sử dụng literal (ví dụ: "hello") hoặc khi bạn gọi phương thức 
    intern() trên một đối tượng chuỗi. 

   !!! Phương thức intern() trong Java được sử dụng để thêm chuỗi hiện tại vào String Pool
    nếu chuỗi đó chưa tồn tại trong pool rồi trả về tham chiếu đến chuỗi đó trong Pool 
    , hoặc trả về tham chiếu đến chuỗi có giá trị giống nó trong String Pool nếu chuỗi đã tồn tại.
         */
        String s1a = new String("hello");  // Tạo đối tượng mới (không trong String Pool)
        String s2a = "hello";               // Kiểm tra và tham chiếu đến chuỗi trong String Pool (nếu đã tồn tại)
        String s3a = "hello";               // Tham chiếu đến chuỗi trong String Pool (đã tồn tại)
        String s4a = s1a.intern();
        System.out.println(s1a == s2a);      // false, vì s1a tham chiếu đến đối tượng không trong String Pool
        System.out.println(s2a == s3a);      // true, vì s2a và s3a đều tham chiếu đến cùng một đối tượng trong String Pool
        System.out.println(s4a == s3a);     // true vì s4a tham chiếu đến cùng 1 đối tượng như s2a, s3a

//        16. isEmpty()
        String s16a = "";
        String s16b = "hello java";

        System.out.println(s16a.isEmpty());
        System.out.println(s16b.isEmpty());

//        17. trim():  xóa khoảng trẳng ở đầu và cuối chuỗi
        String s17 = "  hello string   ";
        System.out.println(s17 + "java");
        System.out.println(s17.trim() + "java");

//        18. static valueOf(): chuyển đối kiểu dữ liệu khác thành kiểu String
        int value = 30;
        String s18 = String.valueOf(value);
        System.out.println(s18 + 10);

//        baitap 
//        Scanner sc = new Scanner(System.in);
//        String s7 = sc.next();
//        for (char c = '0'; c < '9'; c++) {
//            s7 = s7.replace(c + "", "");
//        }
//        System.out.println(s7);
//
//        // reverse chuỗi
//        String s8 = sc.next();
//        String answer = "";
//        for (int i = s8.length() - 1; i >= 0; i--) {
//            answer += s8.charAt(i);
//        }
//        System.out.print(answer);
    }

}
