#include <stdio.h>

int main() {
    float amount;
    // Prompt the user for input
    printf("How much money do you have in your pockets? ");

    // Accept the user's input
    scanf("%f", &amount);

    // Display the amount in 2 digits after decimal point
    printf("The amount of money in your pockets is $%.2f\n", amount);

    return 0;
}






