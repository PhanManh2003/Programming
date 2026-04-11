package staticc;

public class Entry {

    public static void main(String[] args) {
        /* BIẾN STATIC
   - biến static có thể truy cập mà không cần tạo đối tượng 
   - Biến static được chia sẻ bởi tất cả các object của cùng một class
         */

 /* PHƯƠNG THỨC STATIC
- Phương thức static có để được gọi mà không cần phải khởi tạo đối tượng.
- Trong cùng 1 lớp , phương thức static chỉ có thể gọi tới thuộc tính/ phương thức là static
         */
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
    }
}
