/*
Con trỏ thông minh hoạt động như 1 con trỏ nhưng tự động xóa bộ nhớ được cấp phát động khi không còn sử dụng. ( ko cần delete)

3 loại con trỏ thông minh: unique_ptr, shared_ptr, weak_ptr.

Ví dụ: unique_ptr<int> ptr( new int );
   - <int> : kiểu dữ liệu mà con trỏ tham chiếu tới
   - ptr: tên con trỏ
   - (new int) : cấp phát động 1 int
*/
#include <iostream>
#include <memory>
using namespace std;

int main()
{
    // Chương trình thể hiện 1 unique_ptr trỏ tới 1 mảng số nguyên dc cấp phát động
    int max; // kích cỡ mảng
    cout << "Enter the size: ";
    cin >> max;

    // Tạo con trỏ
    unique_ptr<int[]> ptr(new int[max]);

    // Lấy giá trị
    for (int i = 0; i < max; i++)
    {
        cout << "Enter an integer number: ";
        cin >> ptr[i];
    }

    // Hiển thị giá trị của mảng
    cout << "Here are the values you entered: " << endl;
    for (int i = 0; i < max; i++)
    {
        cout << ptr[i] << endl;
    }

    return 0;
}
