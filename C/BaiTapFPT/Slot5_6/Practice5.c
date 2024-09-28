#include <stdio.h>

int main() {
  int a;
  
  printf("Enter an integer: ");
  scanf("%d", &a);
  
  if(a >= 10 && a <= 100) {
    printf("%d is in range (10, 100)\n", a);
  } else {
    printf("%d is not in range (10, 100)\n", a);
  }

  return 0;
}
