//Enter an integer x to check if that number is a palindrome-number or not. If true, display false.

//Explanation: 14341 is a palindrome-number because writing it backwards is still 14341,
// and 123 is not a palindrome-number because writing it backwards is 321.


#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isPalindrome(const char *str) {
    int left = 0;
    int right = strlen(str) - 1;

    while (left < right) {
        if (str[left] != str[right]) {
            return false; // Characters don't match, not a palindrome
        }
        left++;
        right--;
    }

    return true; // All characters matched, it's a palindrome
}

int main() {
    char input_str[100];
    
    // Get user input
    printf("Enter a string: ");
    scanf("%s", input_str);

    if (isPalindrome(input_str)) {
        printf("%s is a palindrome.\n", input_str);
    } else {
        printf("%s is not a palindrome.\nn", input_str);
    }
    return 0;
}

