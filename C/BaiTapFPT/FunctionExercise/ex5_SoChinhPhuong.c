#include <stdio.h>

// Nhap so nguyen duong n. In ra n so chinh phuong dau tien
int square(int);

int main() {
    int n,i;

    printf("Nhap so nguyen duong n>0: ");
    scanf("%d", &n);

    printf("\%d so chinh phuong dau tien: \n", n);

    for(i = 1; i <= n; ++i){
    	printf("%d\n", square(i));
	}

    printf("\n");
    return 0;
}
int square(int n){
	return n * n;
}
