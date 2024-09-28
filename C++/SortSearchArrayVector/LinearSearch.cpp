#include <iostream>
using namespace std;

// Nguyên mẫu hàm
int linearSearch(const int[], int, int);

int main()
{
    const int SIZE = 5;
    int tests[SIZE] = {67, 45, 89, 12, 63};

    // Tìm kiếm mảng để tìm ra số 89
    int result = linearSearch(tests, SIZE, 89);

    // Thông báo
    if (result == -1)
        cout << "Not found";
    else
        cout << "89 is at postion " << result << "th in the array" << endl;
    return 0;
}

// Định nghĩa hàm
int linearSearch(const int array[], int size, int value)
{
    int i = 0; // Chỉ số dưới để tìm kiếm mảng
    int position = -1;
    bool found = false;
    while (i < size && !found) // he loop will continue to run as long as index is less than numElements and !found is true.
    {
        if (array[i] == value)
        {
            found = true;
            position = i + 1;
        }
        i++;
    }
    return position;
}