#include <stdio.h>

int main()
{
    int n;

    printf("Enter a 3-digit integer: ");
    scanf("%d", &n);

    if (n < 100 || n > 999)
    {
        printf("Not valid, please enter again (100-999).\n");
        return 0;
    }

    int c = n % 10;
    int b = (n / 10) % 10;
    int a = n / 100;

    // Sort  Min to a, Max to c
    int temp;
    if (a > b)
    {
        temp = a;
        a = b;
        b = temp;
    }

    if (a > c) 
    {
        temp = a;
        a = c;
        c = temp;
    }
	// Now a is min, sort b and c only!
    if (b > c)
    {
        temp = b;
        b = c;
        c = temp;
    }
    printf("Output: %d%d%d\n", a, b, c);

    return 0;
}

