/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package down_casting;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    /*
    Toán tử instanceof kiểm tra xem 1 đối tượng(thông qua biến tham chiếu)
    có phải là thực thế của 1 lớp hay không.
     */
    
    /**
     * d = 3.5
     * int i = (int) d  ~ downcasting
     *
     */

 /*
    1. Downcasting trong Java thường được sử dụng khi bạn có một biến tham chiếu 
    của lớp cha trỏ tới một đối tượng của lớp con và "bạn muốn chuyển đổi biến
    tham chiếu này về lớp con tương ứng" để có thể truy cập vào các phương thức
    và thuộc tính của lớp con đó.
    
    2.
    Downcasting trong Java áp dụng cho biến tham chiếu, không phải cho đối
    tượng mà biến tham chiếu đang trỏ tới. Tuy nhiên, kiểu dữ liệu của biến tham 
    chiếu không thay đổi sau khi downcasting.
    
    Animal a = new Dog(); // Tạo một đối tượng Dog và gán cho biến a kiểu Animal
    Dog d = (Dog) a; // Downcasting từ Animal thành Dog
    => Sau khi down casting thì biến tham chiếu a vẫn có kiểu dữ liệu là Animal.
    
     */
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting

        if (animal instanceof Dog) { // ~ bien double d = 3 thì d trỏ đến 1 số nguyên nên áp dụng int i = (int) d dc
            // nếu animal trỏ đến Cat() thì lỗi ClassCastException
            // nên mới cần toán tử instanceof
            Dog dog = (Dog) animal; // Safe downcasting
            dog.makeSound(); // Output: Bark
            dog.fetch(); // Output: Fetching...
        } else {
            System.out.println("The object is not a Dog");
        }
        /*
        Ví dụ:
        double d = 3;
        int i = (int) d; // downcasting
        
        
        nếu d= 3.1,... thì downcasting không thành công(trong trường hợp i
        và d có kiểu dữ liệu khác)
         */
        Animal anotherAnimal = new Animal();
        if (anotherAnimal instanceof Dog) {
            Dog anotherDog = (Dog) anotherAnimal; // This block will not be executed
            anotherDog.makeSound();
        } else {
            System.out.println("The object is not a Dog"); // Output: The object is not a Dog
        }
    }
}
