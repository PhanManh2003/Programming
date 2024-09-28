/*
- Mỗi biến được cấp phát 1 phần bộ nhớ tùy theo kiểu dữ liệu của biến
- Mỗi byte bộ nhớ có 1 địa chỉ duy nhất
- Địa chỉ của 1 biến là địa chỉ của byte đầu tiên được cấp phát cho biến đó.
*/
#include <iostream>
using namespace std;
int main()
{
    // Lấy địa chỉ của một biến bằng toán tử & (Lưu ý: Đừng nhầm lẫn với kí tự & để xác định biến tham chiếu)
    int a = 2;
    int b = 3;
    int c = 4;
    int d = 5;
    cout << &a << endl;
    cout << &b << endl;
    cout << &c << endl;
    cout << &d << endl;

    return 0;
}