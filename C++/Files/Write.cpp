#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    // Tạo đối tượng luồng
    ofstream outputFile;

    // Mở tệp
    outputFile.open("demo.txt");
    cout << "Writing the data to the file\n";

    // Ghi vào tệp
    outputFile << 10 << endl;
    outputFile << 12 << endl;
    outputFile << 15 << endl;

    // Đóng tệp
    outputFile.close();
    cout << "Well Done!\n";

    return 0;
}
