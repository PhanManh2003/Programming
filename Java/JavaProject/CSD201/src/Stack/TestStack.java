package Stack;

public class TestStack {

//    public static void main(String[] args) {
//        // Tạo một stack với dung lượng tối đa là 5
//        ArrayStack stack = new ArrayStack(5);
//
//        // Kiểm tra xem stack có rỗng không
//        System.out.println("Stack rỗng: " + stack.isEmpty());  // true
//
//        // Thực hiện push các phần tử vào stack
//        stack.push("Java");
//        stack.push("Maven");
//        stack.push("Stack");
//
//        // Kiểm tra phần tử ở đỉnh stack
//        System.out.println("Phần tử trên đỉnh: " + stack.top());  // "Stack"
//
//        // Thực hiện pop một phần tử và in ra
//        System.out.println("Lấy phần tử ra: " + stack.pop());  // "Stack"
//
//        // Kiểm tra phần tử mới trên đỉnh stack
//        System.out.println("Phần tử trên đỉnh sau khi pop: " + stack.peek());  // "Maven"
//
//        // Thực hiện thêm các phần tử vào stack
//        stack.push("Spring");
//        stack.push("Hibernate");
//
//        // Lấy ra tất cả các phần tử còn lại từ stack
//        while (!stack.isEmpty()) {
//            System.out.println("Lấy phần tử ra: " + stack.pop());
//        }
//
//        // Kiểm tra lại stack sau khi đã lấy hết phần tử
//        System.out.println("Stack rỗng sau khi lấy hết phần tử: " + stack.isEmpty());  // true
//    }
    public static void main(String[] args) {
        SelfLinkedListStack s = new SelfLinkedListStack();

        System.out.println(s.isEmpty()); // true
        s.push(new Person("A", 10));
        s.push(new Person("B", 20));
        s.push(new Person("C", 30));

        System.out.println("element on top: " + s.peek());

        System.out.println("remove element on top " + s.pop());
    }
}
