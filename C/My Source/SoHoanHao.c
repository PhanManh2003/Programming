#include <stdio.h>

//  Nhap so nguyen duong n. Dem xem co bao nhieu so hoan thien nho hon n
int isPerfectNumber(int num) {
    int sum = 0;
    int i;
    for (i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }
    return sum == num;
}

int main() {
    int n;
    printf("Nhap so nguyen duong n: ");
    scanf("%d", &n);

    int count = 0;

    // Count
    int i;
    for (i = 1; i < n; i++) {
        if (isPerfectNumber(i)) {
            count++;
        }
    }

    printf("Co %d so hoan thien nho hon %d.\n", count, n);

    return 0;
}

