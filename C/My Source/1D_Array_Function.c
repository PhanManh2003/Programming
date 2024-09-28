#include <stdio.h>

void inputArr(int a[], int n) {
	int i;
    printf("Enter %d elements:\n", n);
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
}

void outputArr(int a[], int n) {
	int i;
    printf("Array elements: ");
    for ( i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
}

void sum(int a[], int n) {
	int i;
    int total = 0;
    for ( i = 0; i < n; i++) {
        total += a[i];
    }
    printf("Sum of elements: %d\n", total);
}

void average(int a[], int n) {
	int i;
    int total = 0;
    for ( i = 0; i < n; i++) {
        total += a[i];
    }
    double avg = (double)total / n;
    printf("Average of elements: %.2lf\n", avg);
}

void max(int a[], int n) {
	int i;
    int max = a[0];
    for ( i = 1; i < n; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }
    printf("Maximum element: %d\n", max);
}

void min(int a[], int n) {
	int i;
    int min = a[0];
    for ( i = 1; i < n; i++) {
        if (a[i] < min) {
            min = a[i];
        }
    }
    printf("Minimum element: %d\n", min);
}

void aveEvent(int a[], int n) {
	int i;
    int total = 0;
    int count = 0;
    for ( i = 0; i < n; i++) {
        if (a[i] % 2 == 0) {
            total += a[i];
            count++;
        }
    }
    double avg = (count > 0) ? (double)total / count : 0;
    printf("Average of even elements: %.2lf\n", avg);
}

void aveOdd(int a[], int n) {
	int i;
    int total = 0;
    int count = 0;
    for ( i = 0; i < n; i++) {
        if (a[i] % 2 != 0) {
            total += a[i];
            count++;
        }
    }
    double avg = (count > 0) ? (double)total / count : 0;
    printf("Average of odd elements: %.2lf\n", avg);
}

void avePos(int a[], int n) {
	int i;
    int total = 0;
    int count = 0;
    for ( i = 0; i < n; i++) {
        if (a[i] > 0) {
            total += a[i];
            count++;
        }
    }
    double avg = (count > 0) ? (double)total / count : 0;
    printf("Average of positive elements: %.2lf\n", avg);
}

void aveNag(int a[], int n) {
	int i;
    int total = 0;
    int count = 0;
    for ( i = 0; i < n; i++) {
        if (a[i] < 0) {
            total += a[i];
            count++;
        }
    }
    double avg = (count > 0) ? (double)total / count : 0;
    printf("Average of negative elements: %.2lf\n", avg);
}

void sort(int a[], int n) {
    // You can implement a sorting algorithm here.
    // Example: Bubble Sort
    int i,j;
    for (i = 0; i < n - 1; i++) {
        for ( j = 0; j < n - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
    printf("Array sorted in ascending order: ");
    for ( i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
}

int main() {
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    int a[n];

    inputArr(a, n);
    outputArr(a, n);
    sum(a, n);
    average(a, n);
    max(a, n);
    min(a, n);
    aveEvent(a, n);
    aveOdd(a, n);
    avePos(a, n);
    aveNag(a, n);
    sort(a, n);

    return 0;
}

