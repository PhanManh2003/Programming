#include <stdio.h>

int main() {
  int units;
  float charge;

  printf("Enter number of units consumed: ");
  scanf("%d", &units);

  if(units >= 0 && units <= 100) {
    charge = units * 600; 
  }
  else if(units >= 101 && units <= 150) {
    charge = 100 * 600 + (units - 100) * 900;
  }
  else if(units >= 151 && units <= 200) {
    charge = 100 * 600 + 50 * 900 + (units - 150) * 1200;
  }
  else if(units >= 201 && units <= 300) {
    charge = 100 * 600 + 50 * 900 + 50 * 1200 + (units - 200) * 1500;
  }
  else {
    charge = 100 * 600 + 50 * 900 + 50 * 1200 + 100 * 1500 + (units - 300) * 2000;
  }

  printf("Total charge is: Rs %.2f", charge);

  return 0;
}
