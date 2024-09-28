/*
    Định nghĩa
    - "Biến cục bộ" là biến đc định nghĩa bên trong 1 hàm và ko truy cập dc bên ngoài hàm.
      Khi hàm bắt đầu , các biến cục bộ và các biến tham số được tạo trong bộ nhớ và
      bị hủy khi kết thúc hàm.

    - "Biến cục bộ tĩnh" sinh ra để giúp hàm lưu trữ đc giá trị giữa
    các lần gọi hàm bất chấp nó được khai báo lại ở đầu hàm (tránh mất dữ liệu)

    - "Biến toàn cục" đc định nghĩa bên ngoài tất cả các hàm và tất cả các hàm đều truy cập dc.
*/

/*
    Chú ý:
    - Khởi tạo biến toàn cục mà ko gán giá trị thì mặc định auto gán = 0
    - Biến toàn cục và biến cục bộ có thể trùng tên
    - Trong 1 hàm, biến cục bộ và biến tham số phải khác tên nhau
*/

// Chương trình này sử dụng biến cục bộ tĩnh
#include <iostream>
using namespace std;

void showStatic();

int main()
{
    for (int i = 0; i < 5; i++)
        showStatic();
    return 0;
}

void showStatic()
{
    static int startNum; // Giống như biến toàn cục, tất cả biến cục bộ static (tĩnh) dc khởi tạo = 0 mặc định
    cout << "statNum is " << startNum << endl;
    startNum++;
}