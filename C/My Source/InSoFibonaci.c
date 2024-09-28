#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void printFibonacci(int n) {
    int first = 0, second = 1;
    int i;

    if (n >= 1) {
        printf("%d ", first);
    }

    if (n >= 2) {
        printf("%d ", second);
    }

    for (i = 3; i <= n; i++) {
        int next = first + second;
        printf("%d ", next);
        first = second;
        second = next;
    }

}


int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:
int n;
scanf("%d",&n);
  
  
  
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
 //@STUDENT: EDIT THIS LINE TO HAVE DESIRED OUTPUT
printFibonacci(n);






  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  printf("\n");
  system ("pause");
  return(0);
}
