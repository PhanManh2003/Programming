#include <stdio.h>


int isSymmetric(int n) {
  int a = n / 10000;
  int b = (n % 10000) / 1000;
  int c = (n % 1000) / 100; 
  int d = (n % 100) / 10;
  int e = n % 10;

  if (a == e && b == d)
    return 1;
  else
    return 0;
}

int main() {
  int n;

  printf("Nhap vao so nguyen duong 5 chu so: ");
  scanf("%d", &n);

  if (isSymmetric(n)) {
    printf("%d la so doi xung\n", n); 
  } else {
    printf("%d khong phai la so doi xung\n", n);
  }

  return 0;
}
