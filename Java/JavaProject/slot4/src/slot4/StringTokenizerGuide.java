package slot4;

import java.util.StringTokenizer;

public class StringTokenizerGuide {

    /*
    Constructor                                                                   Mô tả
StringTokenizer(String str)                                      tạo ra một lớp StringTokenizer với chuỗi chỉ định.
StringTokenizer(String str, String delim)                        tạo ra một lớp StringTokenizer dựa trên chuỗi chỉ định và dấu phân cách.
StringTokenizer(String str, String delim, boolean returnValue)	 tạo ra một lớp StringTokenizer dựa trên chuỗi định, dấu phân cách và cờ hiệu. Nếu cờ hiệu là true, dấu phân cách được xem như là các phần tử token.
                                                                 Nếu là false, dấu phân cách không được tính là các phần tử token.
!delimiter là Chuỗi chứa các ký tự phân tách (delimiters), mặc định là khoảng trắng
!Tham số boolean xác định xem các ký tự phân tách có được trả về như các token hay không.
     */
 /*
  Phương thức Public                        Mô tả
1. boolean hasMoreTokens()         Trả về true nếu còn nhiều token trong chuỗi.
2. String nextToken()              Trả về token tiếp theo khi duyệt đối tượng StringTokenizer.
3. String nextToken(String delim)	Trả về token tiếp theo dựa trên dấu phân tách.
4. boolean hasMoreElements()	Giống như phương thức hasMoreTokens().
5. Object nextElement()            Giống như nextToken() nhưng nó trả về một đối tượng.
6. int countTokens()               Trả về tổng số lượng của các token.        
     */
    public static void main(String[] args) {
        // 1. default 
        StringTokenizer st1 = new StringTokenizer("Toi ten la Tien Manh");
        System.out.println("Tổng số token: " + st1.countTokens()); // Output : 5
        while (st1.hasMoreTokens()) {            
            System.out.println(st1.nextToken());
        }

        // 2. Chỉ định dấu phân cách delim
        StringTokenizer st2 = new StringTokenizer("Toi-ten- -la-Tien-Manh", "-");
        System.out.println("Tổng số token: " + st2.countTokens()); // Output: 6
        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }
        // 3. Chỉ định tham số thứ 3 (returnValue) là false thì dấu phân cách
        // không được tính là các phần tử token.
        StringTokenizer st3 = new StringTokenizer("Toi-ten-,la-Tien-Manh", "-,", false);
        System.out.println("Tổng số token: " + st3.countTokens());  // Output: 5
        while (st3.hasMoreTokens()) {
            System.out.println(st3.nextToken());
        }
        //4. Chỉ định tham số thứ 3 (returnValue) là true thì dấu phân cách được tính là các phần tử token.
        StringTokenizer st4 = new StringTokenizer("Toi-ten-,la-Tien-Manh", "-,", true);
        System.out.println("Tổng số token: " + st4.countTokens());  // Output: 10
        while (st4.hasMoreTokens()) {
            System.out.println(st4.nextToken());
        }
    }

}
