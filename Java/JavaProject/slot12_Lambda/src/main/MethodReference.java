package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReference {

    public static void main(String[] args) {
//        List<String> messages = Arrays.asList("Hello", "World", "Method Reference");
//
//        // Sử dụng object::instanceMethod
//        messages.forEach(System.out::println);  

//        BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
//
//        int result = maxFunction.apply(10, 20);
//        System.out.println("Max value: " + result);  
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        names.stream()
//                .map(String::length) // Tham chiếu đến phương thức length của bất kỳ đối tượng String
//                .forEach(System.out::println); 


        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> list = listSupplier.get();
        list.add("Hello");
        list.add("World");
        System.out.println(list);  
        
        
        // Functional Interface hay dùng : Predic
    }
}
