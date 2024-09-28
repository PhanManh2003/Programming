/*
    Tệp đầu vào là tệp mà dữ liệu được đọc từ nó
    Tệp đầu ra là tệp mà dữ liệu được ghi vào nó

    1. Có 2 loại tệp: tệp văn bản và tệp nhị phân

    2. Có 2 phương thức truy cập tệp: truy cập tuần tự, truy cập ngẫu nhiên.

    3. Để chương trình hoạt động với tệp trên đĩa của máy tính, chương trình phải tạo
     đối tượng luồng trong bộ nhớ ( là đối tượng đc liên kết với một tệp và giúp chương trình làm việc
     với tệp đó) ~ cin, cout
     Tệp được coi là 1 luồng dữ liệu.

     4. Kiểu dữ liệu cho đối tượng luồng:
        - ifstream: Mở 1 tệp và đọc dữ liệu từ nó ( dùng toán tử >>)
        - ofstream: Khi tạo 1 tệp và ghi dữ liệu vào nó (dùng toán tử <<)
        - fstream: Cả đọc, ghi
    5. Trước khi dữ liệu được ghi vào 1 tệp hoặc đọc từ nó thì phải tạo 1 đối tượng luồng
    để mở tệp qua nó.

    6. Các bước thao tác với tệp nói chung
        - Tạo đối tượng luồng
        - Mở tệp
        - Xử lí tệp
        - Đóng tệp
    Hầu hết các hệ điều hành đều lưu dữ liệu trong bộ đệm tệp trước khi nó đc ghi vào tệp
*/

/*
    Tạo đối tượng tệp và mở tệp, đóng tệp.

    ifstream inputFile;
    inputFile.open('abc.txt')
    inputFile.close();

*/
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
    inputFile.open(filename);

    // Kiểm tra mở tệp thành công không
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
