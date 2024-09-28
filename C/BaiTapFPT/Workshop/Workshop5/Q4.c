#include <stdio.h>

int main() {
  int num;
  printf("Enter an integer: ");
  scanf("%d", &num);

  printf("Binary: ");
  int i;
  for(i=31; i>=0; i--) {
    if(num & (1<<i)) {
      printf("1");
    } else {
      printf("0");  
    }
  }

  printf("\n");

  return 0;
}
