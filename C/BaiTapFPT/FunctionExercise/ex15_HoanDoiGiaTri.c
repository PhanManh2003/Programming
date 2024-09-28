#include <stdio.h>

void swap(int *a, int *b){

	int temp = *a; 	// *a là giá tri cua bien ma con tro a tro toi
	*a = *b;
	*b = temp;
}

int main() {

	int a, b;

	printf("Nhap so nguyen a: ");
	scanf("%d", &a);

	printf("Nhap so nguyen b: ");
	scanf("%d", &b);

	swap(&a, &b);

	printf("\nOutput:\n");
	printf("a: %d\n", a);
	printf("b: %d\n", b);

return 0;
}



