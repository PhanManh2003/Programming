#include <stdio.h>

int main() {
  int a, b;
  
  printf("Enter two integers: ");
  scanf("%d %d", &a, &b);
  
  if(a != 0 && b != 0) {
    printf("a is not equal to 0 and b is not equal to 0\n");
  } else {
    printf("a is equal to 0 or b is equal to 0\n");
  }

  return 0;
}
