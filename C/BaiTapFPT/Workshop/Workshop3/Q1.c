#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:
  int i;
  int n = 5;
  int a[n];
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
   int total = 0;
    for ( i = 0; i < n; i++) {
        if(a[i] % 3 == 0 && a[i] % 5 != 0){
        	total += a[i];
		}
    }
    
  
  
  
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
	printf("%d",total);
	


  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
