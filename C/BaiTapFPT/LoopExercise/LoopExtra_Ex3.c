#include <stdio.h>
// In day Fibonacci
int main() {
    int i, n, first = 1, second = 1, next;

    printf("Enter a positive integer n: ");
    scanf("%d", &n);

    printf("First %d Fibonacci numbers: \n", n);

    for (i = 1; i <= n; i++) {
        if (i == 1) {
            printf("%d ", first);
            continue;
        }
        if (i == 2) {
            printf("%d ", second);
            continue;
        }
        next = first + second;
        first = second;
        second = next;
        printf("%d ", next);
    }

    return 0;
}

