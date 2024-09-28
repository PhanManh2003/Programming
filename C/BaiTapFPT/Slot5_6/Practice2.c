#include <stdio.h>

int main() {
  int n;
  
  printf("Enter an integer: ");
  scanf("%d", &n);
  
  if(n > 0) {
    printf("%d is a positive number\n", n);
  } else if(n < 0) {
    printf("%d is a negative number\n", n);
  } else {
    printf("%d is equal to 0\n", n);
  }

  return 0;
}
