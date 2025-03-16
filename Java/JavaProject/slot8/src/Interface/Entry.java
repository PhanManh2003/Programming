package Interface;

public class Entry {

    /* interface được dùng để lưu trữ các phương thức trừu tượng và các biến hằng số.
    
    1. Giống với lớp trừu tượng, bạn không thể khởi tạo được đối tượng của interface
    mà chỉ có thể khởi tạo được đối tượng của lớp được kế thừa từ interface.
    
    2. Tất cả các phương thức trong interface đều được trình biên dịch hiểu là các 
    phương thức trừu tượng và tất cả các biến trong interface đều được trình biên 
    dịch hiểu là các hằng số. Cụ thể, các thuộc tính luôn luôn mặc định là
    public static final và ko thể thay đổi. Phương thức có thể thuộc các loại sau:
        - phương thức trừu tượng : luôn luôn mặc định là public abstract
        - phương thức default: khai báo với default, có thân, có thể override
        - phương thức static : có thân, ko cần đối tượng để gọi
    
    3. Một lớp có thể kế thừa nhiều interface. Như bạn đã biết, Java là ngôn ngữ được thiết kế 
    với mục đích đơn giản nên không hỗ trợ đa kế thừa với class, nhưng do bản chất interface
    chỉ chứa các phương thức rỗng nên Java cho phép một lớp kế thừa nhiều interface. 
    
    4. Interface khác abstract class ở chỗ là 1 lớp có thể implement nhiều 
    interface => mục đích sử dụng khác nhau :
    - interface sử dụng khi bạn cần định nghĩa các hành vi mà các lớp
    không có quan hệ kế thừa, nhưng vẫn có hành vi chung.
    
    - abstract class sử dụng khi bạn có các lớp có quan hệ kế thừa.
    
     */
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.eat();
        bird.defaultMethod();
        bird.fly();
    }
}

/* achieve loose coupling with interface

interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started");
    }
}

class Car {
    private Engine engine;  // variable with type interface ( polymorphism)

    public Car(Engine engine) {  // Dependency Injection
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}

*/

