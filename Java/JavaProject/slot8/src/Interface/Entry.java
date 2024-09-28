/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    /* interface được dùng để lưu trữ các phương thức trừu tượng và các biến hằng số.
    
    1. Giống với lớp trừu tượng, bạn không thể khởi tạo được đối tượng của interface
    mà chỉ có thể khởi tạo được đối tượng của lớp được kế thừa từ interface.
    
    2. Tất cả các phương thức trong interface đều được trình biên dịch hiểu là các 
    phương thức trừu tượng và tất cả các biến trong interface đều được trình biên 
    dịch hiểu là các hằng số.
    
    3. Một lớp có thể kế thừa nhiều interface. Như bạn đã biết, Java là ngôn ngữ được thiết kế 
    với mục đích đơn giản nên không hỗ trợ đa kế thừa với class, nhưng do bản chất interface
    chỉ chứa các phương thức rỗng nên Java cho phép một lớp kế thừa nhiều interface. 
    
    
     */
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.eat();
        bird.fly();
    }
}
