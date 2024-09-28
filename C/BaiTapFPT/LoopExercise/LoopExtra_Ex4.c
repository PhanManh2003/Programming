#include <stdio.h>

int main() {

  int n, i, j, sum = 0;

  printf("Enter an even positive integer: ");
  scanf("%d", &n);

  printf("\nDouble columns:\n");

  for(i=1; i<=n; i++) {

    if(i%2 == 0) {
      printf("%d ", i/2);
    }
    else {
      printf("%d ", n/2 + i/2); 
    }

    if(i%n == 0) {
      printf("\n");
    }
  }

  for(i=2; i<=n; i+=2) {
    sum += i/2;
    sum += n/2 + i/2; 
  }

  printf("\nTotal of all elements in even rows: %d", sum);

  return 0;
}
