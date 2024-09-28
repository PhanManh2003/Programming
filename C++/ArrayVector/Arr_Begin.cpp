// Nếu bạn để 1 phần tử chưa đc khởi tạo, thì các phần tử sau nó cũng ko dc khởi tạo : int  numbers[6] = {1,2,,8,,12} ( Lỗi)
// Không thể gán 1 mảng cho 1 mảng khác mà phải gán từng phần tử
#include <iostream>
using namespace std;

int main()
{  
    // Khởi tạo mảng (cách 1)
    
    int array[5];
    for (int i = 0; i < 5; i++)
    {
        cout << array[i] << ' ';
    }
    // Khởi tạo mảng ẩn không cần kích thước (cách 2)
    int scores[] = {3,32,45,12,56,75,100,102,99,40};
    cout << scores[2] << endl;
    cout << scores; // chỉ in địa chỉ bộ nhớ của mảng chứ không in nội dung của mảng
    return 0;
}