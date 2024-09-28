/*
Khi truyền vector làm đối số cho tham số vector trong C++,
bạn cần sử dụng toán tử & để truyền địa chỉ của vector đó thay vì truyền vector trực tiếp,
vì vector được cài đặt dưới dạng một đối tượng và được quản lý bởi một con trỏ.

Bằng cách truyền địa chỉ của vector, bạn "giúp hàm truy cập trực tiếp vào vector đó" mà "không cần tạo bản sao mới",
cải thiện hiệu suất và giảm bộ nhớ sử dụng.
*/
#include <iostream>
#include <vector>
using namespace std;

// Nguyên mẫu
void showVector(vector<int> &, int);

int main()
{
    vector<int> numbers{1, 2, 3, 4, 5};
    showVector(numbers, numbers.size());
    return 0;
}

// Định nghĩa hàm
void showVector(vector<int> &vector, int size)
{
    for (int val : vector)
    {
        cout << val << " ";
    }
}
