#include <stdio.h>

int main() {
  	char name[100];  // To store the name
    int birthYear;   // To store the birth year

    // Prompt the user for input
    printf("Enter name: ");
    fgets(name, sizeof(name), stdin);  // read string

    printf("Enter the year of birth: ");
    scanf("%d", &birthYear);

    // Display the information
    printf("\nName: %s", name);
    printf("Date of birth: %d", birthYear);

    return 0;
}
