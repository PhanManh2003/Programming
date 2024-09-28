// Chương trình này thể hiện một mảng được truyền làm đối số cho một hàm
#include <iostream>
using namespace std;

// Nguyên mẫu hàm 
void showValues(const int [], int); 


int main(){
    const int size = 8;
    int numbers[size] = {5,10,15,20,25,30,35,40};

    showValues(numbers, size);

    return 0;
}

void showValues(const int array[] /*không cần size*/, int size) // const để hàm không sửa được phần tử mảng
{
    for (int i = 0; i < size; i++)
    {
        cout << array[i] << " ";
    }
}