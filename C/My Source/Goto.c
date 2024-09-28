#include <stdio.h>

int main() {

    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    if (n % 2 == 0) {
        // jump to even
        goto even;
    } else {
        // jump to odd
        goto odd;
    }

    even:
        printf("%d is even.", n);
    odd:
        printf("%d is odd.", n);
}
