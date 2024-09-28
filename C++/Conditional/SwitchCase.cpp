/*
    switch(IntegerExpression  = 1 biến của bất kì kiểu dữ liệu số nguyên nào kể cả char)
    {
        case ConstantExpression:
        (phải là 1 hằng số nguyên hoặc hằng số(dc định nghĩa), ko thể là biến hoặc biểu thức như x < 50)
            commands;
            break;
        case ConstantExpression:
            commands;
            break;
        case ConstantExpression:
            commands;
            break;
        default:
            commands;
    } 
    Nếu không có break, chương trình sẽ thông qua tất cả câu lệnh case dưới câu lệnh case thích hợp
*/
#include <iostream>
using namespace std;

int main(){
    char food;
    cout    << "Input the kind of food class you want to "
            << "A, B or C. Which do you want?: ";
    cin >> food;

    // Hiển thị giá
    switch (food)
    {
    case 'a':
    case 'A':   cout << "30000 VND per kg.";
        break;
    case 'b':
    case 'B':   cout << "20000 VND per kg.";
        break;
    case 'c':
    case 'C':   cout << "10000 VND per kg.";
        break;
    default:    cout << "That is an invalid choice.";
    }
        
    // phạm vi biến sẽ nằm giữa phần định nghĩa biến và dấu ngoặc nhọn } của khối


    return 0;
}





