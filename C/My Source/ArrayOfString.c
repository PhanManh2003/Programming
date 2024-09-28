#include <stdio.h>
#include <string.h>

int main() {
    // Declare and initialize a two-dimensional array of strings
    char names[3][20];  // This array contains 3 strings, and each string can hold up to 19 characters (+1 for the null-terminating character '\0')

    // Assign values to the array
    strcpy(names[0], "Alice");
    strcpy(names[1], "Bob");
    strcpy(names[2], "Charlie");

    // Print the strings in the array
    int i;
    for (i = 0; i < 3; i++) {
        printf("Name %d: %s\n", i, names[i]);
    }

    return 0;
}

