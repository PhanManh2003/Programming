// Chương trình cho phép người dùng nhập tên tệp
#include <iostream>
#include <string>
#include <fstream>
using namespace std;
int main()
{
    ifstream inputFile;
    string filename;
    int number; // để đọc dữ liệu kiểu số từ tệp văn bản

    // Nhận tên tệp từ người dùng 
    cout << "Enter the filename: ";
    cin >> filename;

    // Mở tệp
    inputFile.open(filename.c_str());

    // Kiểm tra mở tệp
    if (inputFile)
    {
        // Đọc các số từ tệp và hiển thị
        while (inputFile >> number) 
        // Toán tử >> ko chỉ đọc dữ liệu từ tệp mà còn trả về giá trị để biết đọc thành công hay ko
        {
            cout << number << endl;
        }
        inputFile.close();
    }
    else
    {
        // Hiển thị thông báo lỗi
        cout << "Error: File not found";
    }


    return 0;
}
