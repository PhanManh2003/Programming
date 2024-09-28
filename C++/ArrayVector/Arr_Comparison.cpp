#include <iostream>
using namespace std;

int main()
{  
    const int size = 5;
    int firstArray[size] = {7,7,8,8,10};
    int secondArray[size] = {7,7,8,8,11};
    bool equalArray = true;
    int count = 0;
    while (equalArray && count < size) // không dùng for vì phải duyệt qua tất cả các phần tử một cách không cần thiết
    {
        if (firstArray[count] != secondArray[count])
        {
            equalArray = false;
        }
        count++;
        
    }

    if (equalArray)
        cout << "equal";
    else
        cout << "not equal";
        
    return 0;
}