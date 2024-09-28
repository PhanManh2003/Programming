#include <iostream>
using namespace std;

// Nguyên mẫu
void SelectionSort(int[], int);
void showArray(const int[], int);

int main()
{
    const int SIZE = 6;
    int values[SIZE] = {17, 55, 34, 26, 89, 2};
    cout << "The unsorted array are: " << endl;
    showArray(values, SIZE);

    // Selection Sort
    SelectionSort(values, SIZE);
    cout << "The sorted array are: " << endl;
    showArray(values, SIZE);

    return 0;
}

void SelectionSort(int a[], int size)
{
    int temp;
    for (int i = 0; i < size; i++)
    {
        // Finding the minimum element in the remaining unsorted array
        int min_idx = i;
        for (int j = i + 1; j < size; j++)
        {
            if (a[j] < a[min_idx])
                min_idx = j;
        }
        // Swap the found minimum element with the first element
        temp = a[i];
        a[i] = a[min_idx];
        a[min_idx] = temp;
    }
}

void showArray(const int a[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
}
