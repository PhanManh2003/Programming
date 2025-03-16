 
package abstract_class;
 
public class Entry {
//    Tính trừu tượng là một tính chất mà chỉ tập trung vào những tính năng của
    // đối tượng và ẩn đi những thông tin không cần thiết. 

    public static void main(String[] args) {
        Person person1 = new Employee("Trung", "HN", 3300);
        Person person2 = new Customer("Linh", "BN", 10400);
        person1.display();
        person2.display();
    }
}
