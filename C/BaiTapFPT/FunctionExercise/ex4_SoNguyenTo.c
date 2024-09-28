#include <stdio.h>
#include <stdbool.h>

// Nhap so nguyen duong n. In ra cac so nguyen to nho hon n
bool isPrime(int num) {
    if (num <= 1) {
        return false;
    }
    int i;
    for (i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int n,i;

    printf(" Nhap so nguyen duong n>0: ");
    scanf("%d", &n);

    printf("\nOutput:\n");

    for (i = 2; i < n; i++) {
        if (isPrime(i)) {
            printf("%d ", i);
        }
    }

    printf("\n");
    return 0;
}

