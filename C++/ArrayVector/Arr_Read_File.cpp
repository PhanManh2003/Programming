#include <iostream>
#include <fstream>
using namespace std;

int main(){
    int numbersGet[5]; // Tạo mảng để lấy phần tử từ tệp
    int count = 0; // Biến đếm vòng lặp

    // Tạo đối tượng luồng
    ifstream inputFile;
    
    // Mở tệp
    inputFile.open("SavedNumbers.txt");

    // Đọc các số từ tệp vào mảng
    while (count < 5 && inputFile >> numbersGet[count]) 
    {
        count++;
        // Biểu thức inputFile >> numbersGet[count] đọc giá trị từ tệp và lưu trữ nó trong phần tử mảng numbersGet[count]
    }
    
    // Đóng tệp
    inputFile.close();

    // Hiển thị các số đã đọc từ tệp
    for ( count = 0; count < 5; count++)
    {
        cout << numbersGet[count] << " ";
    }
    
    return 0;

}