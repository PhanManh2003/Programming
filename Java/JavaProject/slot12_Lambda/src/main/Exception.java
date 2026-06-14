 
package main;
 
public class Exception {
    /**
     * Throwable
├── Error (Không nên catch - Lỗi hệ thống nghiêm trọng)
│   ├── OutOfMemoryError              (Hết bộ nhớ RAM)
│   ├── StackOverflowError            (Recursion quá sâu, stack bị đầy)
│   └── VirtualMachineError           (JVM gặp lỗi nghiêm trọng)
│
└── Exception
    ├── RuntimeException (Unchecked - Không bắt buộc handle - Lỗi lập trình)
    │   ├── NullPointerException ⭐⭐⭐               (Truy cập object/method của null)
    │   ├── ArrayIndexOutOfBoundsException ⭐⭐⭐    (Truy cập index ngoài phạm vi array)
    │   ├── ArithmeticException ⭐⭐⭐               (Chia cho 0 với integer)
    │   ├── ClassCastException ⭐⭐                 (Cast object sai kiểu)
    │   ├── IllegalArgumentException ⭐⭐           (Tham số truyền vào không hợp lệ)
    │   ├── NumberFormatException ⭐⭐              (Parse string không phải số)
    │   ├── InputMismatchException ⭐⭐             (Scanner nhận input sai kiểu)
    │   └── IllegalStateException ⭐               (Object ở trạng thái không hợp lệ)
    │
    └── Checked Exceptions (Bắt buộc handle - Lỗi ngoài tầm kiểm soát)
        ├── IOException ⭐⭐⭐                       (Lỗi đọc/ghi file, network)
        ├── FileNotFoundException ⭐⭐⭐            (File không tồn tại)
        ├── SQLException ⭐⭐⭐                     (Lỗi kết nối/truy vấn database)
        ├── ClassNotFoundException ⭐⭐            (Không tìm thấy class khi load động)
        ├── InterruptedException ⭐⭐              (Thread bị interrupt khi sleep/wait)
        └── ParseException ⭐                      (Parse date/time/format sai)
     */
}
