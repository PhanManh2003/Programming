#include <stdio.h>

int main() {

    int row = 3;
    int col = 4;
    int matrix[row][col];

    // Input
	int i,j;
    for ( i = 0; i < row; i++) {
        for ( j = 0; j < col; j++) {
            printf("Enter matrix[%d][%d]: ", i + 1, j + 1);
            scanf("%d", &matrix[i][j]);
        }
    }

    // Display
    printf("\nDisplay matrix: \n");
    for (i = 0; i < row; i++) {
        for (j = 0; j < col; j++) {
            printf("[%d]", matrix[i][j]);
        }
        printf("\n");
    }
    return 0;
}

//1 Input 2D array
void inputArr(int a[][50], int n, int m){
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      scanf("%d", &a[i][j]);
    }
  }
}

//2 Output 2D array 
void outputArr(int a[][50], int n, int m){
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      printf("%d ", a[i][j]);
    }
    printf("\n");
  }
}

//3 Sum all elements of 2D array
void sumArr(int a[][50], int n, int m){
  int sum = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      sum += a[i][j];
    }
  }
  printf("Sum: %d\n", sum); 
}

//4 Find min and max value in 2D array
int findMaxMin(int a[][100], int n, int m){
  int max = a[0][0];
  int min = a[0][0];
  
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(a[i][j] > max) max = a[i][j];
      if(a[i][j] < min) min = a[i][j];
    }
  }

  printf("Max: %d, Min: %d\n", max, min);
  return 0;
}

//5 Sum specific row 
int sumRow(int a[][100], int n, int m){
  int row, sum = 0;
  scanf("%d", &row);

  for(int j=0; j<m; j++){
    sum += a[row][j];
  }

  printf("Sum of row %d: %d\n", row, sum);
  return 0;
}

//6 Sum specific column
int sumCol(int a[][100], int n, int m){
  int col, sum = 0;
  scanf("%d", &col);

  for(int i=0; i<n; i++){
    sum += a[i][col];
  }

  printf("Sum of column %d: %d\n", col, sum);
  return 0;
}

//7 Count occurrences of value k
int findK(int a[][100], int n, int m, int k){
  int count = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(a[i][j] == k) count++;
    }
  }

  printf("Number of %d: %d\n", k, count);
  return 0;
}

//8 Count prime numbers
int countPrimes(int a[][100], int n, int m){
  int count = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(isPrime(a[i][j])) count++; 
    }
  }

  printf("Number of primes: %d\n", count);
  return 0;
}

//9 Average of positive numbers
int averagePos(int a[][100], int n, int m){
  int count = 0;
  double sum = 0.0;

  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(a[i][j] > 0){
        sum += a[i][j];
        count++;
      }
    }
  }

  double avg = sum/count;
  printf("Average of positives: %.2f\n", avg);
  
  return 0;
}

//10 Sum main diagonal
int sumMainDiag(int a[][100], int n, int m){
  int sum = 0;
  for(int i=0; i<n; i++){
    sum += a[i][i]; 
  }

  printf("Main diagonal sum: %d\n", sum);
  return 0;
}

//11 Sum below main diagonal
int sumBelowMainDiag(int a[][100], int n, int m){
  int sum = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<i; j++){
      sum += a[i][j];
    }
  }

  printf("Below main diagonal sum: %d\n", sum);
  return 0; 
}

//12 Sum above main diagonal
int sumAboveMainDiag(int a[][100], int n, int m){
  int sum = 0;
  for(int i=0; i<n; i++){
    for(int j=i+1; j<m; j++){
      sum += a[i][j];
    }
  }

  printf("Above main diagonal sum: %d\n", sum);
  return 0;
}
