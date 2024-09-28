#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
int isPowerOfTwo(int a, int *n) {
  if(a == 0) {
    return 0;
  }

  while(a != 1) {
    if(a % 2 != 0) {
      return 0;
    }
    a = a / 2;
    *n += 1;
  }
  
  return 1;
}

int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:

 	int a;
 	int n = 0;
  scanf("%d", &a);

  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
	if(isPowerOfTwo(a, &n)) {
    	printf("%d", n);
  	} else {
    printf("%d is not a power of 2", a);
  	}
	


  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
