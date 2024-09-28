/*
Các toán tử so sánh có thể được dùng để so sánh các biến con trỏ
dựa trên địa chỉ được lưu trữ trong con trỏ. (> < >= <= != ==)

- Trong 1 mảng thì địa chỉ phần tử 1 lớn hơn địa chỉ phần tử 0.

- ptr1 < ptr2 so sánh địa chỉ
còn *ptr1 < *ptr2 so sánh giá trị mà ptr1 và ptr2 trỏ đến.
*/
#include <iostream>
using namespace std;

int main()
{
    const int SIZE = 9;
    int arr[SIZE] = {4, 5, 2, 65, 24, 32, 22, 2433, 55};
    int *ptr = arr;
    cout << "The values int the array are: " << endl;
    while (ptr <= &arr[1])
    {
        cout << *ptr << "    ";
        ptr++;
    }

    return 0;
}