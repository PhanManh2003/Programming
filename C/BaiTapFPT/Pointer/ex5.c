#include <stdio.h>

int main() {
  int n;
  printf("Enter the number of elements: ");
  scanf("%d", &n);

  int arr[n];
  
  int i;
  for(i=0; i<n; i++) {
   	 printf("Enter element %d: ", i+1);
    scanf("%d", &arr[i]);
  }

  int max = arr[0];
  int min = arr[0];
  int sum = 0;

  int *ptr  = arr;
  for(i=0; i < n; i++) {
    if(*ptr > max) {
      max = *ptr;
    }
    if(*ptr < min) {
      min = *ptr; 
    }
    sum += *ptr;
    ptr++;
  }

  printf("Maximum value = %d\n", max);
  printf("Minimum value = %d\n", min);
  printf("Sum of elements = %d\n", sum);

  return 0;
}
