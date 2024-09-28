/*  Các hàm có thể trả về biến con trỏ, nhưng phải chắc chắn rằng mục mà con trỏ tham chiếu tới vẫn tồn tại.

    Chỉ nên trả về 1 con trỏ từ 1 hàm nếu nó là :
        - Một con trỏ đến một mục được truyền vào hàm dưới dạng 1 đối số
        - Một con trỏ đến một đoạn bộ nhớ được cấp phát động
         ( bộ nhớ này vẫn được cấp phát cho đến khi toán tử delete dc sử dụng hoặc chương trình kết thúc)
*/

// TODO: Viết hàm trả về 1 con trỏ đến một mảng các điểm của sinh viên nhập vào từ bàn phím. Sau đó in điểm ra màn hình
#include <iostream>
using namespace std;

// Hàm nguyên mẫu
double *getStudentMark(int);

int main()
{

    // Lấy 1 mảng gồm điểm của 5 sinh viên, con trỏ trả về từ hàm được gán cho con trỏ mark
    double *mark = nullptr;
    mark = getStudentMark(5);

    // Hiển thị điểm của sinh viên
    for (int i = 0; i < 5; i++)
    {
        cout << "Điểm sinh viên thứ " << i + 1 << " là: ";
        cout << mark[i] << endl;
    }

    // Giải phóng bộ nhớ cấp phát động
    delete[] mark;
    mark = nullptr;

    return 0;
}

double *getStudentMark(int size)
{
    // Tạo con trỏ để lưu điểm
    double *arr = nullptr;

    // Cấp phát động 1 mảng chứa điểm
    arr = new double[size];

    // Nhập điểm cho từng sinh viên
    for (int i = 0; i < size; i++)
    {
        cout << "Nhập điểm cho sinh viên thứ " << i + 1 << ": ";
        cin >> arr[i];
    }

    // Trả về con trỏ
    return arr;
}
