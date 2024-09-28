#include <stdio.h>

//  Nhap so nguyen duong n. Dem xem co bao nhieu so hoan thien nho hon n

unsigned long long factorial(int);
int main() {
    int n;

    printf("Nhap so nguyen duong n: ");
    scanf("%d", &n);

    double sum = 0.0;
	int i;
    for (i = 1; i <= n; i++) {
        sum += 1.0 / factorial(i);
    }

    printf("Tong nghich dao cua %d! là %.15lf\n", n, sum);

    return 0;
}

unsigned long long factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
