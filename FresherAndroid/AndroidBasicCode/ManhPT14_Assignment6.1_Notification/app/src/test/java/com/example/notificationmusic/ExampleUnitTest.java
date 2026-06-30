package com.example.notificationmusic; // Khai báo tên package của ứng dụng

import org.junit.Test; // Import annotation @Test để đánh dấu phương thức kiểm thử

import static org.junit.Assert.*; // Import tất cả các phương thức kiểm tra như assertEquals, assertTrue, v.v.

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest { // Khai báo lớp kiểm thử đơn vị, chạy trên máy phát triển mà không cần thiết bị Android
    @Test // Đánh dấu đây là một phương thức test case sẽ được JUnit thực thi
    public void addition_isCorrect() { // Phương thức kiểm tra phép cộng cơ bản để xác nhận môi trường test hoạt động đúng
        assertEquals(4, 2 + 2); // Kiểm tra kết quả 2 + 2 phải bằng 4, nếu sai thì test thất bại
    }
}
