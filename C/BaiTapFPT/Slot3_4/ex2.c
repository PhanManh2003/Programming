#include <stdio.h>

int main() {
	float height, base, area;
	
    // Prompt the user for the height and base
    printf("Enter the height of the triangle: ");
    scanf("%f", &height);
    
    printf("Enter the base of the triangle: ");
    scanf("%f", &base);
    
    // Calculate the area of the triangle
    area = 0.5 * height * base;
    
    // Output
    printf("The area of the triangle is %.2f\n", area);
    printf("Memory address of 'area': %p\n", &area);
    
    return 0;
}






