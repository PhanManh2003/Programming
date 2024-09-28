/*
    - Con trỏ (pointer) là một biến chứa "địa chỉ bộ nhớ" của một biến khác

    - Con trỏ cho phép bạn làm việc với dữ liệu mà chúng trỏ tới.

    - Biến con trỏ tương tự như biến tham chiếu, nhưng hoạt động ở mức độ thấp hơn

    - Con trỏ hữu ích cho việc cấp phát bộ nhớ động, các thuật toán thao tác với mảng và chuỗi, lập trình OPP
*/
#include <iostream>
using namespace std;

int main()

{
    int x = 25, y = 50, z = 75; // 3 biến int
    int *ptr = nullptr;         // Khởi tạo biến con trỏ tên "ptr", để trỏ tới 1 biến int

    // Hiển thị nội dung của x, y, z
    cout << "Here are the values of x, y, z:" << endl;
    cout << x << "  " << y << "  " << z << endl;

    // Sử dụng biến con trỏ để sửa x, y, z

    ptr = &x;    // Lưu trữ địa chỉ của biến x trong biến ptr
    *ptr += 100; // Thêm 100 vào giá trị trong x

    ptr = &y;    // Lưu trữ địa chỉ của biến y trong biến ptr
    *ptr += 100; // Thêm 100 vào giá trị trong y

    ptr = &z;    // Lưu trữ địa chỉ của biến z trong biến ptr
    *ptr += 100; // Thêm 100 vào giá trị trong z

    // Hiển thị nội dung của x, y, z
    cout << "Once again, Here are the values of x, y, z:" << endl;
    cout << x << "  " << y << "  " << z << endl;
    return 0;
}