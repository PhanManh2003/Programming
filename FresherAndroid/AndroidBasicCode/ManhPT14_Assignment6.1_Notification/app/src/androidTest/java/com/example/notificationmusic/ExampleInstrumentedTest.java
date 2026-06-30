package com.example.notificationmusic; // Khai báo tên package của ứng dụng

import android.content.Context; // Import Context để lấy thông tin ngữ cảnh ứng dụng khi chạy test

import androidx.test.platform.app.InstrumentationRegistry; // Import để lấy đối tượng Instrumentation khi chạy test trên thiết bị thật
import androidx.test.ext.junit.runners.AndroidJUnit4; // Import runner JUnit4 dành riêng cho môi trường Android

import org.junit.Test; // Import annotation @Test để đánh dấu phương thức kiểm thử
import org.junit.runner.RunWith; // Import annotation @RunWith để chỉ định runner thực thi test

import static org.junit.Assert.*; // Import tất cả các phương thức kiểm tra như assertEquals, assertTrue, v.v.

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class) // Chỉ định sử dụng AndroidJUnit4 runner để chạy test trực tiếp trên thiết bị Android
public class ExampleInstrumentedTest { // Khai báo lớp kiểm thử tích hợp, chạy trực tiếp trên thiết bị hoặc máy ảo Android
    @Test // Đánh dấu đây là một phương thức test case sẽ được JUnit thực thi
    public void useAppContext() { // Phương thức kiểm tra rằng context của ứng dụng được trả về đúng
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext(); // Lấy context của ứng dụng đang được kiểm thử trên thiết bị
        assertEquals("com.example.notificationmusic", appContext.getPackageName()); // Kiểm tra tên package ứng dụng phải đúng là "com.example.notificationmusic"
    }
}
