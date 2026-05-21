package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReference {

    /*
**** 1. ĐỊNH NGHĨA: Method Reference = Cách viết NGẮN GỌN HƠN của Lambda khi
    lambda CHỈ GỌI 1 method duy nhất và không làm gì thêm.
    
VD:
    // ✅ Dùng được Method Reference
list.forEach(n -> System.out.println(n));
list.forEach(System.out::println);  // NGẮN HƠN!
    
  TH Lambda xử lí thêm:
// ❌ 2 methods (chain)
s -> s.toUpperCase().trim()
     ↑            ↑
   method 1    method 2 - 2 methods!    
    
// ❌ KHÔNG dùng được Method Reference (có xử lý thêm)
list.forEach(n -> {
    System.out.println("Number: " + n);  // Ghép string trước
    System.out.println(n);
});

// ❌ KHÔNG dùng được
list.stream().map(n -> n * 2);  // Có xử lý: nhân 2

// ❌ KHÔNG dùng được
calculate(5, 3, (a, b) -> a + b);  // Có xử lý: cộng
    
    
**** 2. CÁC LOẠI METHOD REFERENCE
 1. Static Method Reference  (Syntax: ClassName::staticMethod)
 2. Instance Method Reference (Object cụ thể. object::instanceMethod) 
    
            // Lambda
        Function<String, String> greet1 = name -> prefix.concat(name);

            // Method Reference
        Function<String, String> greet2 = prefix::concat;
 3. Instance Method Reference (Arbitrary Object. ClassName::instanceMethod)
    List<String> names = Arrays.asList("An", "Binh", "Cuong");

        // Lambda
            names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        // Method Reference
            names.sort(String::compareToIgnoreCase);
 4. Constructor Reference (ClassName::new)
    
    // Constructor Reference
        Supplier<List<String>> list2 = ArrayList::new;

    // Sử dụng
        List<String> myList = list2.get();  // Tạo ArrayList mới
     */
    public static void main(String[] args) {
 
    }
}
