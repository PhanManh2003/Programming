/*
- 1 con trỏ có thể được sử dụng như 1 tham số hàm.
Nó cung cấp cho hàm quyền truy cập vào đối số ban đầu giống như biến tham chiếu
- Các loại tham số con trỏ:
    + Biến con trỏ thường: void ...(int *ptr)
    + Biến con trỏ tới hằng: void... (const int *ptr) (trỏ đến 1 mục không đổi )
    + Biến con trỏ hằng: void .... (int * const ptr) (con trỏ giữ địa chỉ không thay đổi)
    + Biến con trỏ hằng tới hằng (kết hợp 2 loại trước)
*/

#include <iostream>
#include <iomanip>
using namespace std;

void getSales(double *, int);
double totalSales(double *, int);

int main()
{
    const int SIZE = 5;
    double monthlyRevenue[SIZE];

    // Lấy doanh số từng tháng
    getSales(monthlyRevenue, SIZE);

    // Hiến thị tổng doanh số
    cout << fixed << setprecision(2) << showpoint;
    cout << "The total sales for the months are $";
    cout << totalSales(monthlyRevenue, SIZE) << endl;
    return 0;
}

void getSales(double *arr, int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << "Enter the sales figure for month " << i + 1 << ": ";
        cin >> arr[i];
    }
}
double totalSales(double *arr, int size)
{
    double sum = 0;
    for (int i = 0; i < size; i++)
    {
        sum += *arr;
        arr++;
    }
    return sum;
}

// Cách khác
// double totalSales(double arr[], int size)
// {
//     double sum = 0;
//     for (int i = 0; i < size; i++)
//     {
//         sum += arr[i];
//     }
//     return sum;
// }