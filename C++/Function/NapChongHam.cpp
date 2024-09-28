// Hai hoặc nhiều hàm có thể cùng tên, miễn là danh sách tham số khác nhau ( Nạp chồng hàm)
#include <iostream>
using namespace std;

int sum(int, int);
int sum(int, int, int);
int sum(int, int, int, int);

int main()
{
    int value1, value2, value3, value4;
    cout << "Enter 4 numbers in order: ";
    cin >> value1 >> value2 >> value3 >> value4;
    cout << "The sum of the 2 first is: " << sum(value1, value2) << endl;
    cout << "The sum of the 3 first is: " << sum(value1, value2, value3) << endl;
    cout << "The sum of the 4 number is: " << sum(value1, value2, value3, value4) << endl;

    return 0;
}

// Định nghĩa hàm
int sum(int a, int b)
{
    return a + b;
}

int sum(int a, int b, int c)
{
    return a + b + c;
}

int sum(int a, int b, int c, int d)
{
    return a + b + c + d;
}