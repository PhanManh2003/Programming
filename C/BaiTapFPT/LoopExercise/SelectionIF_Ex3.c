#include <stdio.h>

int main() {
  int number, result;
  char choice;

  printf("Enter a number: ");
  scanf("%d", &number);

  printf("Enter choice (A/B/C): ");
  scanf(" %c", &choice);

  switch(choice) {
    case 'A':
      result = number * 10;
      break;
    case 'B':
      result = number * 100;
      break;
    case 'C':
      result = number * 1000;
      break;
    default:
      printf("Invalid choice\n");
  }

  printf("Result is: %d", result);

  return 0;
}
