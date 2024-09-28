#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void sort(int a[], int n) {
    int i,j;
    for (i = 0; i < n - 1; i++) {
        for ( j = 0; j < n - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

void printEven(int a[], int n) {
	int i;
    for ( i = 0; i < n; i++) {
        if (a[i] % 2 != 0) {
            printf("%d\n", a[i]);
        }
    }
}
int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:
	int n,i;
	scanf("%d", &n);
	int a[n];
	 for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
  	sort(a,n);
  	
  
  
  
  
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
	printEven(a,n);







  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
