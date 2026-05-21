package main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SomeFunctionalInterface {

    public static void main(String[] args) {
        // 1. Runnable - Không tham số, không trả về ( return)
        Runnable task = () -> System.out.println("Task chạy!");
        task.run();

        // 2. Consumer - Nhận tham số, không trả về
        Consumer<String> printer = s -> System.out.println("In: " + s);
        printer.accept("Hello Lambda");

        // 3. Supplier - Không tham số, có trả về
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println("Số random: " + randomNum.get());

        // 4. Function - Nhận 1 tham số, có trả về 1 kq
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("5^2 = " + square.apply(5));

        // 5. Predicate - Nhận tham số, trả về boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("4 chẵn? " + isEven.test(4));

        // 6. Xử lý List
        List<String> names = Arrays.asList("Manh", "An", "Binh", "Cuong");

        // Lọc tên có 4 ký tự
        names.stream()
                .filter(name -> name.length() == 4)
                .forEach(name -> System.out.println("Tên 4 ký tự: " + name));

        // Sắp xếp
        names.sort((n1, n2) -> n1.compareTo(n2));
        System.out.println("Sau khi sắp xếp: " + names);
    }
}
