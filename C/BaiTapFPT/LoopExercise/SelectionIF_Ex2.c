#include <stdio.h>

int main() {
  int distance;
  float cost;

  printf("Enter distance traveled: ");
  scanf("%d", &distance);

  distance = distance/100;
  
  switch(distance) {
    case 0 ... 9:
      cost = 5.0;
      break;
    case 10 ... 29:
      cost = 8.0;
      break;
    case 30 ... 59:
      cost = 10.0;
      break;      
    case 60 ... 99:
      cost = 12.0;
      break;
    default:
      printf("Invalid distance");
  }

  printf("Cost is: Rs %.2f", cost);
  
  return 0;
}
