package main;


/*
Lambda Expression (biểu thức Lambda) có thể được định nghĩa là một hàm ẩn danh,
là cách viết function ngắn gọn mà không cần tạo class hay method đầy đủ. Thực chất
lambda là "1 object implement cái functional interface" đó. 

Lambda Expression là một hàm không có tên và không thuộc bất kỳ lớp nào,
không có phạm vi truy cập (private, public hoặc protected),
không khai báo kiểu trả về.

Cú pháp: (parameters) -> expression hoặc (parameters) -> { statements;}
Ý nghĩa: Lambda = "Với X → làm Y"

Lambda chỉ dùng được với Functional Interface! FI là interface có duy nhất 1 phương thức abstract.
Chính vì chỉ có 1 phương thức abstract, nên lambda function ko cần tên.

Các Functional Interface có sẵn:

Interface           |       Method              |       Lambda Example

Runnable            |   void run()              |       () -> System.out.println("Run")
Consumer<T>         | void accept(T t)                 s -> System.out.println(s)
Supplier<T>         |    T get()                         () -> "Hello"
Function<T,R>       |    R apply(T t)                   x -> x * 2
Predicate<T>        |    boolean test(T t)              x -> x > 5
Comparator<T>       |   int compare(T t1, T t2)       (a, b) -> a - b


-----Ý NGHĨA RA ĐỜI : Lambda giải quyết 2 vấn đề cực khó là truyền behavior và closure -------
********1. TRUYỀN LOGIC ĐƯỢC VÀO PARAMETER THAY VÌ CHỈ TRUYỀN ĐƯỢC DATA.

// Truyền LOGIC như một parameter!
void calculate(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
    System.out.println(operation.apply(a, b));
}

// Truyền LOGIC CỘNG
calculate(5, 3, (x, y) -> x + y);      // 8

// Truyền LOGIC TRỪ
calculate(5, 3, (x, y) -> x - y);      // 2

// Truyền LOGIC NHÂN
calculate(5, 3, (x, y) -> x * y);      // 15

// Truyền BẤT KỲ LOGIC NÀO!
calculate(5, 3, (x, y) -> x * x + y);  // 28
→ 1 method, VÔ SỐ cách xử lý! thay vì phải viết nhiều method 

********2. CLOSURE - BẮT BIẾN TỪ CONTEXT XUNG QUANH

# Trước Java 8: Anonymous class PHẢI khai báo biến final:

int threshold = 100;
// final int threshold = 100;  // Phải thêm final!

List<Integer> result = new ArrayList<>();
for (Integer n : numbers) {
    if (new Predicate<Integer>() {
        @Override
        public boolean test(Integer num) {
            return num > threshold;  // ❌ LỖI nếu threshold không final!
        }
    }.test(n)) {
        result.add(n);
    }
}

# Với Lambda: Tự động bắt biến (effectively final):

int threshold = 100;  // Không cần viết final!

List<Integer> result = numbers.stream()
    .filter(n -> n > threshold)  // ✅ Lambda "bắt" threshold tự động!
    .collect(Collectors.toList());
Lambda "nhớ" biến từ bên ngoài!

 */
public class Lambda {

    public static void main(String[] args) {
        // Dùng Lambda để cài đặt interface
        Calculator add = (a, b) -> a + b; // add là 1 biến tham chiếu tới object do lambda expression tạo ra.
        Calculator multiply = (a, b) -> a * b;

        /*
        -> Khi bạn viết:
            Calculator add = (a, b) -> a + b;
        
        -> Compiler tự động chuyển thành:
        
            Calculator add = new Calculator() {
                @Override
                    public int calculate(int a, int b) {
                        return a + b;
            }
};      Lambda là cú pháp ngắn gọn để implement Functional Interface, và thường thay thế Anonymous Class.
         */
        System.out.println(add.calculate(3, 5)); // Output: 8
        System.out.println(multiply.calculate(3, 5)); // Output: 15
    }
}
