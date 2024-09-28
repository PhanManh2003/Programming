#include <iostream>
#include <iomanip>
using namespace std;
int main() {
                        // For là vòng  lặp kiểm tra trước
    int x ;
    for (x = 1; x <= 10; x++) // Thực hiện xong câu lệnh rồi nó mới tăng x
    {
        cout << x << endl;
    }


    cout << "------------\n";
    for (int i = 0; i < 10; i+=2) // Định nghĩa luôn biến đếm trong for , nhưng biến này ko sd dc ngoài for
    {
        cout << i << endl;
    }


    cout << "------------\n";
    for (int a = 1, b = 2; a <= 5 , b <= 4; a++, b++)
        // Đặt nhiều câu lệnh trong Initialization, test, update expression
    {
        cout << a << " plus " << b
            << " equals " << (a+b) << endl;  
    }
    

    cout << "------------\n";
    int num = 1;
    for (; num <= 5; ) // Bỏ qua initialization, update expression
    {
        cout << num << "\t\t" << (num * num) << endl;
        num++;
    }




    // Chương trình đồng hồ
    cout << fixed << right;
    cout.fill('0'); // Hàm fill làm thay đổi kí tự điền(kí tự điền mặc định là khoảng trắng)
    for (int hour = 0; hour < 12; hour ++)
    {
        for (int minute = 0; minute < 60; minute ++)
        {
            for (int second = 0; second < 60; second ++)
            {
                cout << setw(2) << hour << ":";
                cout << setw(2) << minute << ":";
                cout << setw(2) << second << endl;
            }
        }
    }




    return 0;
}