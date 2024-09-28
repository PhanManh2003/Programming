#include <iostream>
#include <string>
using namespace std;

int main(){

    // syntax: cin.ignore(n,c) : bỏ qua n kí tự tiếp theo cho đến khi gặp kí tự c
        
        char ch;
        int number;
        cout << "Enter a number: ";
        cin >> number;
        cin.ignore(); // Bỏ qua kí tự khoảng trắng (enter)
        cout << "Enter a character: ";
        ch = cin.get();
        cout << "You entered character: " << ch << ".Thank you!";

        return 0;

}
