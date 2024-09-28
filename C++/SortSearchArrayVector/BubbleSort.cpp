#include <iostream>
using namespace std;

// Nguyên mẫu
void BubbleType1(int[], int);
void BubbleType2(int[], int);
void showArray(const int[], int);

int main()
{
    const int SIZE = 6;
    int numbers[SIZE] = {17, 55, 34, 26, 89, 2};
    cout << "The unsorted array are: " << endl;
    showArray(numbers, SIZE);

    // Sorting Type 1
    BubbleType1(numbers, SIZE);
    cout << "The sorted array Type 1 are: " << endl;
    showArray(numbers, SIZE);

    // Sorting Type 2
    BubbleType2(numbers, SIZE);
    cout << "The sorted array Type 2 are: " << endl;
    showArray(numbers, SIZE);
    return 0;
}

void BubbleType1(int a[], int size)
{
    int temp;
    for (int i = 0; i < size; i++)
    // i để làm mốc cho j chạy
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}
// cách khác
void BubbleType2(int a[], int size)
{
    bool swap;
    int temp;
    do
    {
        swap = false;
        for (int i = 0; i < size - 1; i++)
        {
            if (a[i] > a[i + 1])
            {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                swap = true;
            }
        }
    } while (swap); // Dừng khi swap = false, vòng lặp for không phải hoán đổi vị trí 2 phần tử nào nữa
}

void showArray(const int a[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
}
