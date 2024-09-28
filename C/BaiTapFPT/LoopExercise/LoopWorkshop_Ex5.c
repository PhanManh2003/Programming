#include <stdio.h>

int main() {
  
  int hours, cars1 = 0, cars2 = 0, cars3 = 0;
  float totalHours = 0, totalFee = 0;

  printf("Enter number of hours (0 to exit): ");
  scanf("%d", &hours);

  while(hours != 0) {
    
    if(hours >= 1 && hours <= 4) {
      cars1++;
      totalHours += hours; 
      totalFee += hours * 3;
    }
    else if(hours >= 5 && hours <= 7) {
      cars2++;
      totalHours += hours;
      totalFee += (hours - 4) * 1.5 + 4 * 3; 
    }
    else if(hours >= 8 && hours <= 24) {
      cars3++;
      totalHours += hours;
      totalFee += 18;
    }

    printf("Enter number of hours (0 to exit): ");
    scanf("%d", &hours);
  }

  float avgHours = totalHours / (cars1 + cars2 + cars3);
  float avgFee = totalFee / (cars1 + cars2 + cars3);

  printf("\nCars 1-4 hours: %d", cars1);
  printf("\nCars 5-7 hours: %d", cars2);
  printf("\nCars 8-24 hours: %d", cars3);

  printf("\nTotal hours: %.2f", totalHours);
  printf("\nTotal fee: %.2f", totalFee);  

  printf("\nAverage hours per car: %.2f", avgHours);
  printf("\nAverage fee per car: %.2f", avgFee);

  return 0;
}
