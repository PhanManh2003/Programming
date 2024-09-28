#include <stdio.h>

int main() {
  
  int n, i, j;
  
  do {
    printf("Enter an integer between 10 and 20: ");
    scanf("%d", &n);
  } while (n < 10 || n > 20);

  for(i=1; i<=n; i++) {
    for(j=1; j<=i; j++) {
      printf("*");
    }
    printf("\n");
  }

  return 0;
}
