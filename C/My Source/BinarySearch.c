// Binary Search
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>


#define N 10

int binarySearch(const int [], int , int);

int main(){
	int arr[N];
	srand(time(0));
	int i;
	for (i = 0; i < N; ++i) {
        arr[i] = rand() % 100 + 1;
    }
    
    printf("Mang ngau nhien ban nhap:\n");
    for ( i = 0; i < N; i++) {
    printf("%d ", arr[i]);
    }
	
	int x;
	printf("\nNhap so ban can tim: ");
	scanf("%d",&x);
	int result = binarySearch(arr, N, x);
	if(result == -1){
		printf("Khong tim thay %d", x);
	}
	else{
		printf("%d o vi tri %d trong mang", x, result);
	}
    
	return 0;
}


int binarySearch(const int a[], int size , int x){
	int position = -1;
	int first = 0, last = size - 1, middle;
	bool found = false;
	
	while(first <= last && !found){
		middle = (first + last) / 2;
		if(a[middle] == x){
			position = middle;
			found = true;
		}
		else if(a[middle] > x){
			last = middle - 1;
		}
		else{
			first = middle + 1;
		}
	}
	return position;
}
