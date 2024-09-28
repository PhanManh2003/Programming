#include <stdio.h>

int main() {

  int num, i = 1, first = 0, last = 0;
  char choice;
  
  do {
    printf("Enter number %d: ", i);
    scanf("%d", &num);

    if(num == 24) {
      if(first == 0) {
        first = i;
        last = i; 
      }
      else {
        last = i;
      }
    }

    i++;
    
    printf("Continue? (Y/N)");
    scanf(" %c", &choice);

  } while(choice == 'Y' || choice == 'y');

  if(first == 0) {
    printf("24 not found");
  }
  else {
    printf("First occurrence: %d", first); 
    printf("\nLast occurrence: %d", last);
  }

  return 0;
}
