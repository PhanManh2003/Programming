//strlen()	calculate string length
//strcpy()	copy one string to another
//strcmp()	compare two strings
//strcat()	concatenate two strings
//strlwr()	convert string to lower case
//strupr()	convert string to uppercase

#include <stdio.h>
#include <string.h>

int main() {
	// strlen
    char str[] = "Hello, world!";
    int length = strlen(str);
    printf("The length of the string is: %d\n", length);
    
    // strcpy
    char source[] = "Hello, world!";
    char destination[20];
    strcpy(destination, source);
    printf("The destination string after copying: %s\n", destination);
    
    // strcmp
    char str1[] = "apple";
    char str2[] = "banana";
    int result = strcmp(str1, str2);
    if (result == 0) {
        printf("The two strings are equal\n");
    } else if (result < 0) {
        printf("String 1 is less than String 2\n");
    } else {
        printf("String 1 is greater than String 2\n");
    }
    
    // strcat
    char s1[20] = "Hello, ";
    char s2[] = "world!";
    strcat(s1, s2);
    printf("The string after concatenation: %s\n", s1);
    
    // strlwr
    char s3[] = "Hello, World!";
    strlwr(s3);
    printf("The string after converting to lowercase: %s\n", s3);
    return 0;
}

