#include <stdio.h>

// Dem chu so chan , chu so le
void countDigits(int n, int k, int *even, int *odd) {
	int i;
  for(i = 0; i < k; i++) {
    int digit = n % 10;
    if(digit % 2 == 0) {
      (*even)++; 
    }
    else {
      (*odd)++;
    }
    n /= 10;
  }
}

int main() {
  int n, k, even = 0, odd = 0;
  
  do {
    printf("Nhap so luong chu so k (0 < k <= 5): ");  
    scanf("%d", &k);
  } while(k <= 0 || k > 5);

  printf("Nhap so nguyen duong n co %d chu so: ", k);
  scanf("%d", &n);

  countDigits(n, k, &even, &odd);

  printf("So luong chu so chan la: %d\n", even);
  printf("So luong chu so le la: %d\n", odd);

  return 0;
}
