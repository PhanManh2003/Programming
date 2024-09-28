#include <stdio.h>

int getUserChoice();
void f1();
void f2();
int main() {

    int userChoice;
	do {
		userChoice = getUserChoice();
		switch (userChoice) {
        case 1:
            f1();
            break;
        case 2:
            f2();
            break;    
        default:
    		printf("Goodbye!");	
    	}
    	
    } while(userChoice > 0 && userChoice < 3);
    	
    return 0;
}

int getUserChoice(){
	int choice;
	printf("1 - Operation 1");
	printf("\n2 - Operation 2");
	printf("\nOther - Quit\n");
	printf("Enter your choice: ");
	scanf("%d", &choice);
	return choice;
};

void f1(){
	int a,b,sum=0;
	printf("Nhap a: ");
	scanf("%d",&a);
	printf("Nhap b: ");
	scanf("%d",&b);
	sum = a + b;
	printf("%d + %d = %d\n\n", a, b, sum);
};

void f2(){
	char a, b;
	printf("\nNhap ki tu a: ");
	// Tranh bo dem buffer voi ki tu khoang trang
	scanf(" %c",&a);
	printf("\nNhap ki tu b: ");
	scanf(" %c",&b);
	
	// Cach lay ma so cua 1 ki tu
	int start = a < b? a : b;
	int end  = a > b? a : b;
	
	int i;
	printf("ASCII table: \n");
	for(i = start; i<= end; ++i){
		printf("%d\t%c\n", i, i);
	}
};
