package main;

public class AnonymousClass {

    public static void main(String[] args) {
/* Anonymous class (lớp ẩn danh) là một class không có tên, 
   được tạo ngay tại chỗ để dùng một lần.
                 
 Trước Java 8, người ta hay dùng nó để implement interface
  hoặc override method mà không cần tạo file class riêng.
*/
        Calculator add = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }

        };
        System.out.println(add.getClass().getName());
        System.out.println(add.calculate(5, 3));
    }
}
