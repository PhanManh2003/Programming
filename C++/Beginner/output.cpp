#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main()
{
    // 1. setw(x) ( tạo khoảng trống dài x đơn vị và căn lề phải)
    int value = 23;
    cout << '(' << setw(5) << value << ')' << endl;
    cout << '(' << setw(5) << 112378998437598 << ')' << endl; // giá trị dài hơn setw(x) thì ghi đè lun
    cout << "-------------------\n";

    // 2. left, right
    double a = 148.454, b = 43.559;
    cout << left << setw(10) << a << endl;
    cout << right << setw(10) << b << endl; // Watch Out!: mỗi giá trị sử dụng 1 setw(), ko dùng chung
    cout << "-------------------\n";

    // 3. setprecision(x): hiển thị x chữ số có nghĩa trước và sau dấu thập phân
    // 4. fixed : tránh in số dưới dạng kí tự khoa học

    double salary;
    salary = 23449892388740543;
    cout << "Print only: ";
    cout << salary << endl;
    cout << "Print with fixed: " << fixed << salary << endl;
    cout << "-------------------\n";

    // 5. showpoint: Đệm các số 0 và dấu thập phân vào cuối mỗi số (nếu chưa có) ~ (fixed + setprecision)
    double x = 123.4, y = 456.0;
    cout << showpoint << x << endl;
    cout << y << endl;

    string state = "VietNam";
    cout << "The length of the word state is: " << state.length() << endl;
    return 0;
}
