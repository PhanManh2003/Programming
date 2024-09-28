#include <iostream>
using namespace std;

// Function prototype
bool isEvenOrNot(int); // hàm trả về kiểu bool

int main()
{
    int val;
    cout << "Enter an integer: ";
    cin >> val;

    if (isEvenOrNot(val))
        cout << "Even number" << endl;
    else
        cout << "Odd number" << endl;
    return 0;
}

// Definition
bool isEvenOrNot(int number)
{
    bool status;
    if (number % 2 == 0)
        return true;
    else
        return false;
}
