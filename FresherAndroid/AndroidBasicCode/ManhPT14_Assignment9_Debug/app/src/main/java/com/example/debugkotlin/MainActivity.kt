package com.example.debugkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       //  Xem logcat với tag:Assignment
        // Chạy Assignment 1
        val ketQua = binarySearch(23, arrayOf(12, 3, 24, 5, 10, 23, 9))
        Log.d("Assignment1", "Vị trí của 23 trong mảng: $ketQua")

        // Chạy Assignment 2
        giaiPhuongTrinhBac2()
    }

    // ASSIGNMENT 1
    /**
     * LỖI TÌM THẤY:
     * - Dòng: index = center + 2
     * - Lỗi: Phải là center + 1, không phải center + 2
     * - Lý do: Binary Search cần dịch index sang phải 1 bước (center + 1).
     *          Nếu nhảy 2 bước sẽ bỏ sót phần tử, dẫn đến trả về -1
     *          dù phần tử đó tồn tại trong mảng.
     * - CÁCH SỬA: index = center + 1
     */
    fun binarySearch(element: Int, array: Array<Int>): Int {
        array.sort()
        var index: Int = 0
        var end = array.size - 1
        while (index <= end) {
            val center: Int = (index + end) / 2
            if (element == array[center]) {
                return center
            } else if (element < array[center]) {
                end = center - 1
            } else if (element > array[center]) {
                index = center + 1  // ĐÃ SỬA: trước đó là center + 2
            }
        }
        return -1
    }

    // ASSIGNMENT 2
    /**
     * LỖI 1 TÌM THẤY:
     * - Dòng: root2 = (b - Math.sqrt(determinant)) / (2 * a)
     * - Lỗi: Thiếu dấu âm trước b
     * - Lý do: Công thức nghiệm bậc 2 là (-b ± √Δ) / 2a.
     *          Thiếu dấu âm làm root2 ra kết quả sai.
     * - CÁCH SỬA: root2 = (-b - Math.sqrt(determinant)) / (2 * a)
     *
     * LỖI 2 TÌM THẤY:
     * - Dòng: val imaginaryPart = Math.sqrt(determinant) / (2 * a)
     * - Lỗi: Math.sqrt() nhận vào số âm (determinant < 0 trong nhánh else)
     * - Lý do: Khi determinant < 0, Math.sqrt(determinant) trả về NaN.
     *          Phần ảo phải được tính từ √(-determinant).
     * - CÁCH SỬA: val imaginaryPart = Math.sqrt(-determinant) / (2 * a)
     */
    fun giaiPhuongTrinhBac2() {
        val a = 2.3
        val b = 4.0
        val c = 5.6
        val output: String
        val determinant = b * b - 4.0 * a * c

        if (determinant > 0) {
            val root1 = (-b + Math.sqrt(determinant)) / (2 * a)
            val root2 = (-b - Math.sqrt(determinant)) / (2 * a)  // ĐÃ SỬA: trước đó là (b - ...)
            output = "root1 = %.2f and root2 = %.2f".format(root1, root2)
        } else if (determinant == 0.0) {
            val root = -b / (2 * a)
            output = "root1 = root2 = %.2f".format(root)
        } else {
            val realPart = -b / (2 * a)
            val imaginaryPart = Math.sqrt(-determinant) / (2 * a)  // ĐÃ SỬA: trước đó là sqrt(determinant)
            output = "root1 = %.2f+%.2fi and root2 = %.2f-%.2fi"
                .format(realPart, imaginaryPart, realPart, imaginaryPart)
        }

        Log.d("Assignment2", output)
    }
}