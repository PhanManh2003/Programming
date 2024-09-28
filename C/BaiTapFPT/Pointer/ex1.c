#include <stdio.h>

int main(){
	char charVar = 'a';
  	int intVar = 10;
  	double doubleVar = 3.14;

  	char* charPtr = &charVar;
  	int* intPtr = &intVar;
  	double* doublePtr = &doubleVar;
  	
  	printf("The address of char charVar is 0x%x\n", &charVar);
  	printf("The address of int intVar is 0x%x\n", &intVar);
  	printf("The address of double doubleVar is 0x%x\n", &doubleVar);
  	printf("The address of char* charPtr is 0x%x\n",&charPtr);
  	printf("The address of int* intPtr is 0x%x\n",&intPtr);
  	printf("The address of double* doublePtr is 0x%x\n\n",&doublePtr);
  	
  	printf("The value of char charVar is %c\n", charVar);
  	printf("The value of int intVar is %d\n", charVar);
  	printf("The value of double doubleVar is %.2f\n", doubleVar);
  	printf("The value of char* charPtr is %p\n", charPtr);
  	printf("The value of int* intPtr is %p\n", intPtr);
  	printf("The value of double* doublePtr is %p\n\n",doublePtr);
  	
  	printf("The size of char charVar is %d bytes\n", sizeof(charVar));
  	printf("The size of int intVar is %d bytes\n", sizeof(intVar));
  	printf("The size of double doubleVar is %d bytes\n", sizeof(doubleVar));
  	printf("The size of char* charPtr is %d bytes\n", sizeof(charPtr));
  	printf("The size of int* intPtr is %d bytes\n", sizeof(intPtr));
  	printf("The size of double* doublePtr is %d bytes\n", sizeof(doublePtr));
	
	return 0;
}
