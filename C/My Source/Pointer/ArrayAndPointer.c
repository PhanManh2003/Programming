#include <stdio.h>
int main() {
   int num[5];
   int i;

   for(i = 0; i < 5; ++i) {
      printf("&x[%d] = %p\n", i, &num[i]);
   }
	
   printf("Address of array num: %p", num);
//	 &num[i] tuong duong voi num+i và num[i] tuong duong voi *(num+i)

   return 0;
}

// chuong trinh 2

//#include <stdio.h>
//int main() {
//
//    int i, num[5], sum = 0;
//    printf("Enter 5 numbers: ");
//    for(i = 0; i < 5; ++i) {
//        //  scanf("%d", &x[i]);
//        scanf("%d", num+i);
//
//        // Equivalent to sum += x[i]
//        sum += *(num+i);
//    }
//
//    printf("Sum = %d", sum);
//
//    return 0;
//}
