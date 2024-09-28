// Mảng 2 chiều có thể hiểu là 1 table chứa nhiều mảng 1 chiều (mỗi mảng 1 chiều là 1 row)
#include <iostream>
#include <iomanip>
using namespace std;

// Chương trình Truyền mảng 2 chiều đến hàm    
const int COLS = 4, T1_ROWS = 3, T2_ROWS = 4;
void showArray(const int [][COLS], int); 
// C++ yêu cầu số cột phải được chỉ định trong nguyên mẫu hàm vì liên quan đến cách mảng 2 chiều được lưu trong bộ nhớ

int main()
{
    // Khởi tạo mảng 2 chiều
    int table1[T1_ROWS][COLS] = {{1,2,3,4},{5,2,8,4},{1,12,33,44}};
    int table2[T2_ROWS][COLS] = {{0,0,0,0},{5,2,8,4},{1,52,73,47}};

    // In mảng
    cout << "The contents of table 1 is:" << endl;
    showArray(table1,T1_ROWS);

    cout << "The contents of table 2 is:" << endl;
    showArray(table2,T2_ROWS);
    return 0;
}

// Định nghĩa hàm
void showArray(const int array[][COLS], int rows)
{
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < COLS; j++)
        {
            cout << setw(4) << array[i][j];
        }
        cout << endl;
    }
}  