/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package up_casting;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    public static void main(String[] args) {
   
/* khi biến của lớp cha tham chiếu tới đối tượng của lớp con thì 
biến này chỉ có thể gọi tới các thuộc tính và phương thức 
có ở lớp cha và nếu lớp con ghi đè thì phương thức được gọi sẽ ở lớp con */

 /* Khi thực hiện downcasting chúng ta cần kiểm tra kiểu dữ liệu của object 
            trước khi gán giá trị để tránh lỗi ClassCastException.*/
        Animal animal1 = new Cat();
        animal1.sound();

    }
}
