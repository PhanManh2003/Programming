#include <stdio.h>

int main() {

  int choice, num1, num2, result;  

  do {
    printf("\n*****MENU*****");
    printf("\n1. Enter two integers");
    printf("\n2. Add two integers");
    printf("\n3. Subtract two integers"); 
    printf("\n4. Multiply two integers");
    printf("\n5. Divide two integers");
    printf("\n6. Exit");

    printf("\n\nEnter your choice: ");
    scanf("%d", &choice);

    switch(choice) {
      case 1: 
        printf("Enter two integers: ");
        scanf("%d%d", &num1, &num2);
        break;
      case 2:
        result = num1 + num2;
        printf("Sum = %d", result);
        break;
      case 3:
        result = num1 - num2;
        printf("Difference = %d", result);
        break;
      case 4:
        result = num1 * num2;
        printf("Product = %d", result);
        break;
      case 5:
        result = num1 / num2;
        printf("Quotient = %d", result);
        break;
      case 6:
        break;
      default:
        printf("Invalid choice");
    }
  } while(choice != 6);

  return 0;
}
