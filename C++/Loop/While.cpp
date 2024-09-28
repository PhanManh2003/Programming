            // While là vòng lặp có điều kiện
#include <iostream>
using namespace std;

int main()
{
    int num = 4;
    cout << num++ << endl; // Hiển thị 4 sau đó cộng 1 vào num
    cout << num << endl;
    cout << ++num << endl; // Cộng 1 vào num sau đó hiển thị 6
    
    // Toán hạng của các toán tử tăng hoặc giảm (++,--) phải là một giá trị xác định


    // Sử dụng while để xác thực đầu vào
    int a;
    cout << "Enter a number in the range 1-100: ";
    cin >> a;
    while (a < 1 || a > 100)
    {
        cout << "ERROR: Enter a value in the range 1-100: ";
        cin >> a;
    }
    cout << "Your number is: " << a << endl;
    return 0;
 
}