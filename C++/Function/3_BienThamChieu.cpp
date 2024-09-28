/*
    Khi 1 đối số được truyền vào 1 tham số của 1 hàm, chỉ 1 bản sao của giá trị đối số đc truyền.
    Thay đổi tham số trong hàm không ảnh hưởng đến đối số đó ở bên ngoài hàm.
*/

/*
#include <iostream>
using namespace std;

void changeMe(int);

int main()
{
    cout << "This program proves that parameter's change does not affect the original argument." << endl;

    int number = 23;
    cout << "First, number is " << number << endl;
    changeMe(number);
    cout << "Finally the number is " << number << endl;
    return 0;
}

void changeMe(int val)
{
    val = 0;
    cout << "Now the number is: " << val << endl;
}
*/


/* 
    Khi tham số hàm là 1 biến tham chiếu, nó cho phép truy cập vào đối số ban đầu.
    ( tham chiếu (reference) là một loại biến hoạt động như một bí danh của biến khác)
    Ví dụ: A là tham chiếu của B thì khi A thay đổi thì B cũng thay đổi theo
*/


#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;

void doubleNum(int &); // Nguyên mẫu hàm, tham số hàm là 1 biến tham chiếu (dùng kí tự &)

int main()
{
    int value = 5;

    cout << "In main, value is " << value << endl;
    cout << "Now call the function doubleNum....." << endl;
    doubleNum(value);
    cout << "Now back in main, the value is " << value << endl;
    return 0;
}

void doubleNum(int &number)
{
    number = pow(number,3);
    // Nếu muốn kết thúc 1 chương trình trong 1 hàm khác ngoài hàm main, ta sẽ dùng hàm exit
    // exit(0);
}