#include <iostream>
#include <string>
using namespace std;

int main(){
                    // So sánh các kí tự
    char ch;
        // Nhận 1 kí tự từ người dùng
    cout << "Enter a digit or a letter: ";
    ch = cin.get();

        // Xác định những gì người dùng đã nhập
    if (ch >= '0' && ch <= '9')
        cout << "You entered a digit.\n";
    else if (ch >= 'A' && ch <= 'Z')
        cout << "You entered an uppercase letter.\n";
    else if (ch >= 'a' && ch <= 'z')
        cout << "You entered a lowercase letter.\n";
    else 
        cout << "That is not a digit or a letter.\n"; 
    
                    // So sánh các đối tượng string
    /*Từng kí tự trong toán hạng đầu tiên đc so sánh với kí tự ở vị trí tương ứng của toán hạng thứ 2.
    Toán tử a < toán tử b nếu kí tự không khớp đầu tiên của a nhỏ hơn kí tự tương ứng ở b
    */
    string str1 = "ABC";
    string str2 = "XAB";
    if (str1 < str2) 
        cout << "str1 < str2" << endl;
    else 
        cout << "str1 > str2" << endl;




    return 0;
}