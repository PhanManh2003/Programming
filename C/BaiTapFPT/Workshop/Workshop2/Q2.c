#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:
  	int n, i, j, num = 2, flag = 0;
    scanf("%d", &n);
	int k;
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:

   for (i = n; i >= 1; i--) {
        for (j = 0; j != i;) {
            flag = 0;
            for (k = 2; k < num; k++) {
                if ((num % k) == 0) {
                	// check if num is prime
                    flag = 1;
                    break;  // Exit the loop early if not prime
                }
            }
            
            if (flag == 0) {
            	//in xong 1 so nguyen to thi tang n len
                j++;
                printf("%d ", num);
            }
            num++;
        }
        printf("\n");
    }

  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
