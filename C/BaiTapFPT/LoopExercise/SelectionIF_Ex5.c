#include <stdio.h>

int main() {
  int mark;

  printf("Enter student's mark: ");
  scanf("%d", &mark);

  if(mark >= 90 && mark <= 100) {
    printf("Grade: A");
  }
  else if(mark >= 80 && mark <= 89) {
    printf("Grade: B"); 
  }
  else if(mark >= 70 && mark <= 79) {
    printf("Grade: C");
  }
  else if(mark >= 60 && mark <= 69) {
    printf("Grade: D");
  }
  else if(mark < 60) {
    printf("Grade: F");
  }
  else {
    printf("Invalid mark"); 
  }

  return 0;
}
