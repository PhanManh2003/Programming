#include<stdio.h>
#include <stdbool.h>

int sumOfArray(int arr[], int n){
    int sum = 0;
    int i;
    for(i = 0; i < n; i++){
        sum += arr[i];
    }
    return sum;
}

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void sortArray(int arr[], int n){
    int i, j;
    bool swapped; // kiem tra xem co su thay doi nao dien ra hay khong, giup giam so lan lap
    for (i = 0; i < n - 1; i++) {
        swapped = false;
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
                swapped = true;
            }
        }
        if (swapped == false)
            break;
    }
}

// Function to print an array
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
}

int main(){
    int arr[5] = {5, 4, 2, 8, 9};
    int sum = sumOfArray(arr, 5);
    
    printf("Sum of array: %d\n", sum);

    sortArray(arr, 5);
    printf("Sorted array: ");
    printArray(arr, 5);

    return 0;
}

