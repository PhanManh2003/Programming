#include <iostream>
using namespace std;

// Nguyên mẫu hàm: ko cần định nghĩa hàm trước khi gọi hàm (tập trung vào viết hàm main)
void showSum(int, int, int); // chỉ cần kiểu dữ liệu của tham số

int main()
{
    int value1, value2, value3;
    cout << "Enter three numbers, you'll get the sum: ";
    cin >> value1 >> value2 >> value3;

    showSum(value1, value2, value3);
    return 0;
}

// Định nghĩa hàm 
void showSum(int num1, int num2, int num3) // Biến tham số là 1 biến cục bộ
{
    cout << "\nSum: " << (num1 + num2 + num3) << endl;
}
// Phạm vi của tham số dc giới hạn trong phần thân của hàm sử dụng nó.
