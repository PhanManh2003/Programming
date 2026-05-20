package main;


/*
Lambda Expression (biểu thức Lambda) có thể được định nghĩa là một hàm ẩn danh,
là cách viết function ngắn gọn mà không cần tạo class hay method đầy đủ.

Lambda Expression là một hàm không có tên và không thuộc bất kỳ lớp nào,
không có phạm vi truy cập (private, public hoặc protected),
không khai báo kiểu trả về.

Cú pháp: (parameters) -> expression hoặc (parameters) -> { statements;}
Ý nghĩa: Lambda = "Với X → làm Y"

Lambda chỉ dùng được với Functional Interface! FI là interface có duy nhất 1 phương thức abstract.
Chính vì chỉ có 1 phương thức abstract, nên lambda function ko cần tên.

Các Functional Interface có sẵn:

Interface           |       Method          |       Lambda Example

Runnable            |   void run()          |       () -> System.out.println("Run")
Consumer<T>         | void accept(T t)              s -> System.out.println(s)
Supplier<T>             T get()                     () -> "Hello"
Function<T,R>           R apply(T t)                x -> x * 2
Predicate<T>            boolean test(T t)           x -> x > 5
Comparator<T>           int compare(T t1, T t2)     (a, b) -> a - b


-----Ý nghĩa ra đời : Lambda giải quyết 2 vấn đề cực khó là truyền behavior và closure -------




 */
public class Lambda {

    public static void main(String[] args) {
        // Dùng Lambda để cài đặt interface
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println(add.calculate(3, 5)); // Output: 8
        System.out.println(multiply.calculate(3, 5)); // Output: 15
    }
}

