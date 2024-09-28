#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
int sumOdd(int a[], int n){
	int i;
    int total = 0;
    for ( i = 0; i < n; i++) {
        if (a[i] % 2 != 0) {
            total += a[i];
        }
    }
    return total;
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
  	int sum = sumOdd(a,n);
  
  
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
	printf("%d",sum);







  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
