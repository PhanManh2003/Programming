#include <stdio.h>

int * square(int *p, int n){
	// return a pointer
	int i;
    for(i = 0; i < n ;i++){
        *(p + i) *= *(p + i);
    }
    return p;
}

// Function to print an array
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
}

int main()
{
    int arr[5] = {1,2,3,4,5};
    int *p = &arr[0]; 
    p = square(&arr[0],5);
    printArray(arr,5);
}
