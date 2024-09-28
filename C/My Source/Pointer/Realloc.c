#include<stdio.h>
#include <stdlib.h>

int main() {
  int *ptr;
  int i;

  ptr = (int *)malloc(5 * sizeof(int *)); // cap phat dong 1 mang chua 5 con tro kieu int

  if(ptr!=NULL) {
    *(ptr + 1) = 2;
    ptr[2] = 4;
    ptr[3] = 8;
    ptr[4] = 16;
    /* ptr[5] = 32; lenh này se không thuc hien duoc o day vi het vùng nho */
    ptr = (int *)realloc(ptr, 7 * sizeof(int)); //cap phát thêm hai vùng nho nua 
    // Chu y: Khong duoc realloc de thu nho kich thuoc vung nho cua con tro
    if(ptr != NULL) {
      printf("Bay gio se cap phat them vung nho... \n");
      ptr[5] = 32; /* lúc này câu lenh này moi hop le */
      ptr[6] = 64;
      for(i = 0; i < 7; i++) {
        printf("ptr[%d] chua gia tri %d\n", i, ptr[i]);
      }
      realloc(ptr, 0); /* tuong duong goi toi hàm free(ptr); */
      return 0;
    }
    else {
      printf("Khong cap phat them duoc - khong du vung nho!.\n");
      return 1;
    }
  }
  printf("Khong cap phat them duoc - khong du vung nho!.\n");
  return 1;
}

