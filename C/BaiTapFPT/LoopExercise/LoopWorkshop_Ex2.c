#include <stdio.h>
#include <math.h>
int main() {

  int n, i, j, flag, total = 0;

  printf("Enter a positive integer: ");
  scanf("%d", &n);

  for(i=2; i<=n; i++) {
   
    flag = 1;
    
    // Check prime or not prime
    for(j=2; j<= sqrt(i); j++) {
      if(i%j == 0) {
        flag = 0;
        break;
      }
    }
    
    if(flag == 1) {
      total += i; 
    }
  }

  printf("Total of prime numbers from 1 to %d is %d", n, total);

  return 0;
}
