/* 
Vòng lặp for dựa trên phạm vi được thiết kế để hoạt động với 1 biến phạm vi.
Tại lần lặp i của vòng lặp này, biến phạm vi sẽ chứa giá trị của phần tử i  

Syntax: 
    for (dataType rangeVariable: array)
        statement;
*/
#include <iostream>
using namespace std;

int main()
{
    const int size = 5;
    int numbers[size];

    // Sửa nội dung mảng bằng biến phạm vi tích hợp tham chiếu 
    for (int &val: numbers)
    {
        cout << "Enter a value: ";
        cin >> val;
    }
    
    // Hiển thị các giá trị trong mảng vừa nhập
    for (int val: numbers)
    {
        cout << val << " ";
    }
    return 0;
}