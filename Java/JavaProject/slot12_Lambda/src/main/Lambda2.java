package main;

import java.util.function.BiFunction;

public class Lambda2 {
    /* truyền logic như parameter, BiFunction = Functional Interface có sẵn 
      trong Java để xử lý 2 tham số và trả về kết quả.
    
       BiFunction ở đây có thể hiểu là 1 callback
    */
    static void calculate(int a, int b,
            BiFunction<Integer, Integer, Integer> operation) {
        System.out.println(operation.apply(a, b));
    }

    public static void main(String[] args) {

        calculate(5, 3, (x, y) -> x + y); // 8
        calculate(5, 3, (x, y) -> x - y); // 2
        calculate(5, 3, (x, y) -> x * y); // 15
        calculate(5, 3, (x, y) -> x * x + y); // 28
    }

}
