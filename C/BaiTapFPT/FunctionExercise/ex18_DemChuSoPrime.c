#include <stdio.h>
#include <stdbool.h>

bool isPrime(int n) {
  if (n < 2) return false;
  int i;
  for (i = 2; i*i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}

int main() {
  int n, k, count = 0;
  
  do {
    printf("Nhap so luong chu so k (0 < k <= 5): ");
    scanf("%d", &k); 
  } while (k <= 0 || k > 5);

  printf("Nhap so nguyen duong n co %d chu so: ", k);
  scanf("%d", &n);

	int i;
  for (i = 0; i < k; i++) {
    int digit = n % 10;
    if (isPrime(digit)) {
      count++;
    }
    n /= 10;
  }

  printf("So luong chu so nguyen to la: %d", count);
  
  return 0;
}
