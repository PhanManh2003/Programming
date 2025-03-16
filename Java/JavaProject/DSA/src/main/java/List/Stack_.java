package List;

import java.util.Stack;

public class Stack_ {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        // them phan tu 
        s.push(1);
        s.push(2);
        s.push(3);   
                
        // Hiển thị phần tử ở đỉnh stack (peek)
        System.out.println("Phần tử ở đỉnh: " + s.peek()); //3

        // Lấy phần tử từ đỉnh stack (pop)
        System.out.println("Lấy phần tử ra: " + s.pop()); // 3

        // Kiểm tra stack có rỗng không
        System.out.println("Stack có rỗng không? " + s.isEmpty()); // false

        // Hiển thị phần tử còn lại trong stack
        System.out.println("Stack sau khi pop: " + s);

    }
}
