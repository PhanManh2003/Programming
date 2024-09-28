#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:
 	int i, n, first = 0, second = 1, next;
    scanf("%d", &n);

  // Fixed Do not edit anything here.
  	printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
 	 for (i = 1; i <= n; i++) {
        if (i == 1) {
            printf("%d ", first);
            continue;
        }
       	else if (i == 2) {
            printf("%d ", second);
            continue;
        }
        else {
        	next = first + second;
        	first = second;
        	second = next;
        	printf("%d ", next);
		}
       
    }


  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
