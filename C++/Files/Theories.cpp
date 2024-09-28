/*
    Tệp đầu vào là tệp mà dữ liệu được đọc từ đó
    Tệp đầu ra là tệp mà dữ liệu được ghi vào
    
    1. Có 2 loại tệp: tệp văn bản và tệp nhị phân
    
    2. Có 2 phương thức truy cập tệp: truy cập tuần tự, truy cập ngẫu nhiên.

    3. Để chương trình hoạt động với tệp trên đĩa của máy tính, chương trình phải tạo
     đối tượng luồng trong bộ nhớ ( là đối tượng đc liên kết với một tệp và giúp chương trình làm việc 
     với tệp đó) ~ cin, cout
     Tệp được coi là 1 luồng dữ liệu.

     4. Kiểu dữ liệu cho đối tượng luồng:
        - ifstream: Mở 1 tệp và đọc dữ liệu từ nó
        - ofstream: Khi tạo 1 tệp và ghi dữ liệu vào nó
        - fstream: Cả đọc, ghi
    5. Trước khi dữ liệu được ghi vào 1 tệp hoặc đọc từ nó thì phải tạo 1 đối tượng luồng
    để mở tệp qua nó.
    
    6. Các bước thao tác với tệp nói chung
        - Mở tệp
        - Xử lí 
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
#include <fstream>
using namespace std;

int main()
{
    ofstream outputFile;
    outputFile.open("demo.txt");

    cout << "Writing the data to the file\n";

    // Ghi vào tệp
    outputFile << 10 << endl;
    outputFile << 12 << endl;
    outputFile << 15 << endl;

    // Đóng tệp
    outputFile.close();
    cout << "done\n";

    return 0;
}

