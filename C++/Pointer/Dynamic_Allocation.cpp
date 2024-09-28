/*
                Cấp phát bộ nhớ động với con trỏ

- Định nghĩa CPĐ: Các biến hoặc cấu trúc dữ liệu có thể được tạo và hủy trong khi chương trình đang chạy

- Tại sao cần con trỏ ?
  Giả sử chương trình cần tạo 1 biến int trong lúc chạy, nó sẽ yêu cầu máy tính phân bổ bộ nhớ để lưu trữ 1 int.
  Sau đó máy tính cung cấp cho chương trình địa chỉ bắt đầu của đoạn bộ nhớ này.
  Chương trình chỉ có thể truy cập đoạn bộ nhớ này thông qua địa chỉ của nó, do đó bắt buộc ta phải cần đến 1 biến con trỏ.
  Tóm lại, con trỏ dùng để truy cập và quản lí vùng nhớ đc cấp phát động cho biến hoặc cấu trúc dữ liệu

*/

// Chương trình tính tổng các số liệu bán hàng cho bất kì số lượng ngày nào.
// Những số liệu được lưu trữ trong mảng cấp phát động

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
  double *sales = nullptr,
         total = 0;
  int numDays;

  // Lấy dữ liệu về số ngày bán hàng.
  cout << "How many days of sales figure have been : ";
  cin >> numDays;

  // Tạo 1 mảng trong khi chương trình đang chạy bằng cấp phát động mà không cần khai báo từ đầu !!!
  sales = new double[numDays];
  // Toán tử new trả về địa chỉ bắt đầu của đoạn bộ nhớ vừa cấp phát động và đc gán cho con trỏ sales (dc)

  // Lấy số liệu bán hàng cho mỗi ngày.
  cout << "Enter the sales figures." << endl;
  for (int i = 0; i < numDays; i++)
  {
    cout << "Day " << i + 1 << ": ";
    cin >> sales[i];
  }

  // Tính tổng doanh số và hiển thị
  for (int i = 0; i < numDays; i++)
  {
    total += sales[i];
  }

  cout << fixed << setprecision(2) << "Total sales: " << total << endl;

  // Giải phóng bộ nhớ được cấp phát động

  delete[] sales;  // Toán tử delete dùng để giải phóng bộ nhớ đã được cấp
  sales = nullptr; // Đặt sales là một con trỏ null sau delete để ngăn không cho truy cập vào vùng bộ nhớ đã giải phóng

  return 0;
}