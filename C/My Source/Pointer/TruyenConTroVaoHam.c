#include <stdio.h>
// Truyen con tro cho 1 tham so con tro
void add(int* p1, int *p2) {
    (*p1) += 2;
    (*p2) += 3;
}

int main()
{
    int* pa, a = 5;
    int* pb, b = 6;
    pa = &a;
    pb = &b;
    add(pa, pb);

    printf("a = %d\n", a);
    printf("b = %d\n", b);
  return 0;
}
