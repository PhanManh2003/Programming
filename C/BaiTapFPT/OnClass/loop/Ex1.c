#include <stdio.h>
#include <math.h>

int main() {
    int k;
    printf("Enter k: ");
    scanf("%d", &k); // Use %d for integer input

    float s = 0;
    int i;
    for (i = 1; i <= k; ++i) {
        int j;
        float denominator = 0; // Use float for the denominator
        for (j = 1; j <= i; ++j) {
            denominator += pow(j, 2);
        }

        if (i % 2 != 0) {
            s += 1 / denominator; 
        } else {
            s -= 1 / denominator; 
        }
    }
    
    printf("Result: %.4f\n", s); 

    return 0;
}

