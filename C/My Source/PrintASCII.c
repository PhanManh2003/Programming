#include <stdio.h>

int main() {
    int code = 0;
    while (code < 256) {
        printf("%c, %3d, %3o, %3X\n", code, code, code, code);
        code++;
    }

    return 0;
}

