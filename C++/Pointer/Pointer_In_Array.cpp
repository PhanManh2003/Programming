// Tên mảng là một con trỏ (nên không gán được 2 mảng cho nhau) và con trỏ có thể dùng làm tên mảng (như chương trình dưới)
#include <iostream>
using namespace std;

int main()
{
    int arr[5] = {1, 2, 3, 4, 5};
    int *ptr = arr; // con trỏ ptr trỏ đến phần tử đầu tiên của mảng arr

    // 1
    //  (ptr + i) calculates the memory address of the element at the index i
    //  in the array relative to the base address pointed to by 'ptr'
    for (int i = 0; i < 5; i++)
    {
        cout << *(ptr + i) << " "; // tên mảng là một con trỏ
    }
    cout << endl;

    // 2
    for (int i = 0; i < 5; i++)
    {
        cout << *(arr + i) << " "; // tên mảng là một con trỏ
    }
    cout << endl;

    // 3
    for (int i = 0; i < 5; i++)
    {
        cout << ptr[i] << " "; // con trỏ dùng làm tên mảng
    }
    cout << endl;

    return 0;
}