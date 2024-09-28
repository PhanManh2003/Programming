#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    // Ghi 1 mảng vào 1 tệp
    int numbers[5] = {1, 54, 34, 42, 59};

    // Tạo đối tượng luồng
    ofstream outputFile;

    // Mở 1 tệp bất kì
    outputFile.open("SavedNumbers.txt");

    // Ghi mảng vào tệp
    for (int i = 0; i < 5; i++)
    {
        outputFile << numbers[i] << endl;
    }

    // Đóng tệp
    outputFile.close();
    cout << "Numbers saved succesfully" << endl;

    return 0;
}
