#include <stdio.h>
// Truyen dia chi cua bien cho 1 tham so con tro
void swap(int *n1, int *n2)
{
    int temp;
    temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}

int main()
{
    int num1 = 1, num2 = 2;
	
    swap(&num1, &num2);

    printf("num1 = %d\n", num1);
    printf("num2 = %d", num2);
    return 0;
}

