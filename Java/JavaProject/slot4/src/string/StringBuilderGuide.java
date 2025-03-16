package string;

public class StringBuilderGuide {

    public StringBuilderGuide(String hello) {
    }
//StringBuilder is a class in Java that is used to create mutable (modifiable)
//   sequences of characters. Unlike String, which is immutable, StringBuilder 
//       can be modified after it is created,

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // append
//        sb.append("Java");//now original string is changed  
//        System.out.println(sb);//prints Hello Java  
        // insert
//        sb.insert(1, "Java");//now original string is changed  
//        System.out.println(sb);//prints HJavaello  
        // replace
//        sb.replace(1, 3, "Java");
//        System.out.println(sb);//prints HJavalo  
        // delete
//        sb.delete(1, 3);
//        System.out.println(sb);//prints Hlo  

        // reverse
        System.out.println(sb.capacity());
        sb.reverse();
        System.out.println(sb);//prints olleH  
    }

}

/*
------Các Constructor quan trọng của lớp StringBuilder trong java
StringBuilder(): Tạo ra một Builder chuỗi với dung lượng ban đầu là 16.
StringBuilder(String str): Tạo ra một Builder chuỗi với chuỗi cụ thể.
StringBuilder(int capacity): Tạo ra một Builder chuỗi với dung lượng được chỉ định như độ dài chuỗi.



------Các phương thức của lớp StringBuilder trong java
public StringBuilder append(String s): được sử dụng để nối thêm các chuỗi được chỉ định với chuỗi này. Các phương thức append() được nạp chồng như append(char), append(boolean), append(int), append(float), append(double), ...
public StringBuilder insert(int offset, String s): được sử dụng để chèn chuỗi chỉ định với chuỗi này tại vị trí quy định. Các phương thức insert() được nạp chồng như insert(int, char), insert(int, boolean), insert(int, int), insert(int, float), insert(int, double), ...
public StringBuilder replace(int startIndex, int endIndex, String str): được sử dụng để thay thế chuỗi từ vị trị startIndex đến endIndex bằng chuỗi str.
public StringBuilder delete(int startIndex, int endIndex): được sử dụng để xóa chuỗi từ vị trí startIndex đến endIndex.
public StringBuilder reverse(): được sử dụng để đảo ngược chuỗi.
public int capacity(): được sử dụng để trả về dung lượng hiện tại.
public void ensureCapacity(int minimumCapacity): được sử dụng để đảm bảo dung lượng ít nhất bằng mức tối thiểu nhất định.
public char charAt(int index): được sử dụng trả về ký tự tại vị trí quy định.
public int length(): được sử dụng trả về chiều dài của chuỗi nghĩa là tổng số ký tự.
public String substring(int beginIndex): được sử dụng trả về chuỗi con bắt đầu từ vị trí được chỉ định.
public String substring(int beginIndex, int endIndex): được sử dụng trả về chuỗi con với vị trí bắt đầu và vị trí kết thúc được chỉ định.
*/
