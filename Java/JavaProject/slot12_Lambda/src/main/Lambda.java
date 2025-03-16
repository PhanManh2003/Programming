package main;


/*
Lambda Expression (biểu thức Lambda) có thể được định nghĩa là một hàm ẩn danh,
cho phép người dùng chuyển các phương thức làm đối số. 
Điều này giúp loại bỏ rất nhiều mã soạn sẵn.

Lambda Expression là một hàm không có tên và không thuộc bất kỳ lớp nào,
không có phạm vi truy cập (private, public hoặc protected),
không khai báo kiểu trả về.

Cú Pháp: (argument-list) -> {body}

Argument-list: có thể không có, có một hoặc nhiều tham số
Arrow-token: được sử dụng để liên kết arguments-list và body của biểu thức.
Body: chứa các biểu thức và câu lệnh cho biểu thức lambda.

----------------
Functional Interface là interface chỉ có một phương thức trừu tượng.
Lambda expressions được sử dụng để triển khai các functional interface mà ko cần
phải tạo 1 lớp implement rồi override cái interface đó.

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

