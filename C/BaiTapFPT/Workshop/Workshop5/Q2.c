#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>

int main() {
  system("cls");
  //INPUT - @STUDENT:ADD YOUR CODE FOR INPUT HERE:

  char a[100];
  int i;
  fgets(a, sizeof(a), stdin);

  for(i=0; a[i]!='\0'; i++) {
    if(islower(a[i])) {
      a[i] = toupper(a[i]); 
    }
  }
  
  // Fixed Do not edit anything here.
  printf("\nOUTPUT:\n");
  //@STUDENT: WRITE YOUR OUTPUT HERE:
	printf("%s", a);
	


  
  
  //--FIXED PART - DO NOT EDIT ANY THINGS HERE
  system ("pause");
  return(0);
}
