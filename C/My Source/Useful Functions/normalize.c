#include <string.h>

// moi tu trong chuoi cach nhau dung 1 dau space
void normalize(char *str)
{
    int len;
    char *token;

    token = strtok(str, " ");
    while (token)
    {
        len = strlen(token);
        strcpy(str, token);
        str[len] = ' ';
        str += len + 1;
        token = strtok(0, " ");
    }

    if (len)
        *str = '\0';
}
