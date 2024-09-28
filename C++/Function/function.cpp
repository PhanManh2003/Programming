/*
     Tất cả định nghĩa hàm đều có:
     - Kiểu trả về
     - Tên hàm
     - Danh sách tham số
     - Thân hàm
    
    Tuy nhiên ko nhất thiết các hàm phải return 1 giá trị, loại hàm này gọi là hàm "void".
    
    Hàm main được gọi tự động khi một chương trình khởi động, nhưng tất cả hàm khác phải được thực thi 
    bằng câu lệnh gọi hàm.

    Lệnh return; khiến 1 hàm kết thúc ngay lập tức.
*/
#include <iostream>
using namespace std;

void displayMessage()
{
    cout << "Happy New Year." << endl;
}

int main()
{
    cout << "Welcome to this program, ";
    cout << "I'm ManhAlex" << endl;
    displayMessage();
    return 0;
}