#include <stdio.h>

void swap_nums(int* a, int* b) {
  	int temp = *a; // swap value of a
  	*a = *b; 
  	*b = temp;
}

void swap_pointers(int** a, int** b) {
  int* temp = *a; // *a o day la gia tri ma con tro cap 2 'a' tro toi
  *a = *b; 
  *b = temp;
}

int main() {
  	int a,b;
  	char *s1, *s2;
  	
  	a = 3, b=4;
  	swap_nums(&a,&b);
  	printf("a is %d\n",a);
  	printf("b is %d\n",b);
  	
  	s1 = "I should print second"; // 1 mang ki tu
  	s2 = "I should print first";
  	swap_pointers(&s1, &s2);
  	printf("s1 is %s\n", s1);
  	printf("s2 is %s\n", s2);
  	return 0;
}
