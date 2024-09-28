#include <stdio.h>

int main() {
    // Add your code in here:
	int n, sum_digit;
	sum_digit = 0;
	printf("Nhap n: ");
	scanf("%d",&n);
	while(n != 0) {
		sum_digit += n % 10;
		n /= 10;
		
	}

    // Fixed Do not edit anything here.
    printf("\nOUTPUT:\n");
    // Write your output here:
	printf("Sum digit is: %d", sum_digit);

    return 0;
}
