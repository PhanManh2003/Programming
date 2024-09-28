/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staticc;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    public static void main(String[] args) {
        /*
   -  biến static có thể truy cập mà không cần tạo đối tượng 
    - biến static được chia sẻ bởi tất cả các đối tượng trong chương trình
         */

 /* Một số tính chất của phương thức static:
- Phương thức static có để được gọi mà không cần phải khởi tạo đối tượng.
- Trong cùng một lớp, phương thức static chỉ có thể gọi tới phương thức static khác,
    không thể gọi tới phương thức không phải là static.
- Trong cùng một lớp, phương thức static không thể gọi tới các thuộc tính không phải là static.
         */
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
    }
}
