/*
Các phép toán với con trỏ cơ bản nhất bao gồm:

- Phép tăng giá trị của con trỏ (++): Phép toán này di chuyển con trỏ tới địa chỉ của phần tử tiếp theo trong mảng.

- Phép giảm giá trị của con trỏ (--): Phép toán này di chuyển con trỏ tới địa chỉ của phần tử trước đó trong mảng.

- Phép truy xuất giá trị mà con trỏ trỏ tới (*): Phép toán này trả về giá trị của biến mà con trỏ trỏ tới 

- Phép truy xuất địa chỉ của biến (&): Phép toán này trả về địa chỉ bộ nhớ của biến.
*/
#include <iostream>
using namespace std;

int main() {
    int arr[5] = {10, 20, 34, 46, 57};
    int* ptr = arr; // con trỏ ptr trỏ đến phần tử đầu tiên của mảng arr

    cout << "Value at ptr: " << *ptr << endl; // in giá trị của phần tử đầu tiên của mảng bằng con trỏ

    ptr++; // di chuyển con trỏ tới phần tử tiếp theo trong mảng
    cout << "Value at ptr after increment: " << *ptr << endl; // in giá trị của phần tử thứ hai của mảng bằng con trỏ

    ptr--; // di chuyển con trỏ lại tới phần tử đầu tiên của mảng
    cout << "Value at ptr after decrement: " << *ptr << endl << endl; // in địa chỉ của con trỏ

    int var = 10;
    int* var_ptr = &var; // con trỏ var_ptr trỏ đến biến var
    cout << "Value of var: " << var << endl;
    cout << "Address of var: " << var_ptr << endl;
    cout << "Value at var_ptr: " << *var_ptr << endl; // in giá trị của biến var bằng con trỏ var_ptr

    return 0;
}