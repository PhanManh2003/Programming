#include <iostream>
using namespace std;

// Nguyên mẫu hàm
int binarySearch(const int[], int, int);

int main()
{
    const int SIZE = 10;
    int tests[SIZE] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // mảng phải được sắp xếp thì thuật toán mới cho kết quả chính xác được

    // Tìm kiếm mảng để tìm ra số 89
    int result = binarySearch(tests, SIZE, 7);

    // Thông báo
    if (result == -1)
        cout << "Not found";
    else
        cout << "7 is at postion " << (result + 1) << "th in the array" << endl;
    return 0;
}

// Định nghĩa hàm
int binarySearch(const int array[], int size, int value)
{
    int first = 0, last = size - 1;
    int middle; // Phần tử đầu, giữa và cuối
    int position = -1;
    bool found = false;
    while (first <= last && !found) // vẫn chia làm đôi được và chưa tìm thấy value  ~ while True
    {
        middle = (first + last) / 2;
        if (array[middle] == value)
        {
            found = true;
            position = middle;
        }
        else if (array[middle] > value)
            last = middle - 1;
        else
            first = middle + 1;
    }
    return position;
}