#include <stdio.h>

const size = 10;

void BubbleSort(int a[]){
	int i,j,temp;
	for (i = 0; i < size - 1; i++)
    {
        for (j = 0; j < size - i - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
};

void showArr(int a[]){
	int i;
	for(i = 0; i < size; ++i){
		printf("%d ", a[i]);
	}
}

int main() {
    // Add your code in here:
	int arr[size];
	int i;
	printf("Enter the 10 elements of array: ");
	for(i = 0; i < size; ++i){
		scanf("%d", &arr[i]);
	}
	
	

    // Fixed Do not edit anything here.
    printf("\nOUTPUT:\n");
    // Write your output here:
	printf("Unsorted Array: ");
	showArr(arr);
	BubbleSort(arr);
	printf("\nSorted Array: ");
	showArr(arr);

    return 0;
}
