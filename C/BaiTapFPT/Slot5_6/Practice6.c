#include <stdio.h>

int main() {
  float score;
  
  printf("Enter the test score: ");
  scanf("%f", &score);
  
  if(score >= 0 && score <= 10) {
    printf("The score is valid\n");
  } else {
    printf("The score is not valid\n");
  }

  return 0;
}
