
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
-  Annotations trong Java là một cơ chế cung cấp siêu dữ liệu cho mã nguồn,
cho phép lập trình viên thêm thông tin hoặc hướng dẫn bổ sung vào các lớp,
phương thức, biến, và các phần tử khác của mã nguồn

- @WebServlet là một ví dụ của annotation, được dùng để định nghĩa một Servlet 
mà không cần khai báo trong file web.xml như cách làm cũ trước đây.
Annotation này được giới thiệu từ Servlet 3.0 trở đi.

- Dấu @ đại diện cho Annotation trong Java.
- Trong ví dụ bạn đưa ra, @WebServlet là một annotation giúp ánh xạ một Servlet đến một hoặc nhiều URL.
- Annotation là một cách cấu hình hiện đại, thay thế các file cấu hình XML truyền 
thống trong các ứng dụng Java như JSP hoặc Servlet.
*/
@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Day la trang hello servlet");
    }

}
