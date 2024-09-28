#include <stdio.h>

int main() {
	int a, b;
	printf("Enter a, b: ");
	scanf("%d %d", &a, &b);
	printf("a mod b = %d", a % b);
	return 0;
}
