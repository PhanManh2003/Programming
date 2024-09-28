#include<stdio.h>
#include<math.h>
//tam gia vuong
*
* *
* * *
* * * *
* * * * *
void shape1(int line){
	int i,j;
	 for (i = 1; i <= line; ++i) {
		      for (j = 1; j <= i; ++j) {
		        printf("* ");
		      }
		      printf("\n");
		    }
		   printf("=====================\n");
	}

 
* * * * *
* * * *
* * *
* *
*
void shape2(int line)
{
	 int i,j;
	 for (i = line; i >= 1; --i) {
		      for (j = 1; j <= i; ++j) {
		        printf("* ");
		      }
		      printf("\n");
		    }
		   printf("======================\n");
}

   * * * * *
     * * * *
       * * *
         * *
           *
void shape3(int line)
{
	int i,j;
	for(i = 1; i <= line; i++) {
	      for(j=1; j<=i; j++)
	         printf("  "); 
	      for(j=i; j <= line; j++)
	    	  printf(" *");
	 
	      printf("\n");
	   }
	
	 printf("====================\n");
	
}
    *
   * *
  * * *
 * * * *
* * * * *
void shape4(int line)
{
	 int i,j;
	 for (i = 1; i <=line ; ++i) {
		      for (j = i; j <= line-1; ++j) {
		        printf(" ");
		      }
		      for (j = 1; j<=i; j++){
		      	printf("* ");
		    }
		     printf("\n");
		     }
	printf("======================\n");
}


1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
void shape5(int line)
{
	int i,j;
	 for (i = 1; i <= line; ++i) {
		      for (j = 1; j <= i; ++j) {
		        printf("%d ", j);
		      }
		      printf("\n");
		    }
		   printf("=====================\n");
}

    1
   212
  32123
 4321234
543212345
void shape6(int line)
{
		int i,j;   
		for(i = 1; i <= line; i++) {
			for(j = 1; j <= line - i; j++)
				printf(" "); 
			for(j = i; j >= 1; j--)
				printf("%d", j);
			if(i > 1) {
				for(j = 2; j <= i; j++)
					printf("%d", j);								
			}
			printf("\n");
		}
		 printf("======================\n");	
}

        *
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *
void shape7(int line)
{
	int i,j,k;
		for(i = 1; i <= line; i++) {
            for(j = 1; j <= line-i; j++) {
           		printf("  ");
            }
            for(k = 1; k <= 2*i-1; k++) {
            	printf("* ");
            }
            printf("\n");
       
		}
		 printf("========================\n");
}

        *
      *   *
    *       *
  *           *
* * * * * * * * *
void shape8(int line)
{
	int i,j,k;
	for(i = 1; i <= line; i++) {
        for(j = 1; j <= line-i; j++) {
        	printf("  ");
        }
        for(k = 1; k <= 2*i-1; k++) {
        	if(k == 1 || k == 2*i-1 || i == line) {
            		printf("* ");
        }
        else {
            printf("  ");
        }
        }
        printf("\n");
	}
	 printf("=======================\n");
}

* * * * * * * * *
  * * * * * * *
    * * * * *
      * * *
        *
void shape9(int line)
{
	int i,j,s;
	for(i = line; i >= 1; --i) {
		      for(s = 1; s <= line - i; s++) {
		        	printf("  ");
		      }
		      for(j=i; j <= 2 * i - 1; ++j) {
		        	printf("* ");
		      }
		      for(j = 0; j < i - 1; ++j) {
		        	printf("* ");
		      }
		      printf("\n");
		    }
		 
		    printf("========================\n");	
}

      	*
      * *
    * * *
  * * * *
* * * * *
  * * * *
    * * *
      * *
        *
void shape10(int line)
{
	if (line%2!=0)    {
		    line=line/2+1; 
		    int i, s, j;
			for (i=1;i<=line;i++)     // tam giac tren
	        {  
	        for (s=line-1;s>=i;s--) {
	           printf("  ");
	        }
	        for (j=1;j<=i;j++) {
	            printf("* ");
	    }
	        printf("\n");    
	        }
	        for (i=1;i<=line;i++)     // tam giac duoi
	        {  
	        for (s=1;s<=i;s++) {
	            printf("  ");  
	        }
	        for (j=line-1;j>=i;j--) {
	             printf("* ");
	        }
	        printf("\n");           
	        }
} else printf("Enter line again:\n"); 
	
printf("=============================\n");
	
}

* * * * * *
*         *
*         *
* * * * * *
void shape11(int height, int width)
{
	int i,j;
	for(i = 1; i <= height; i++) {
			if(i == 1 || i == height) {
				for(j = 0; j < width; j++)
					printf("* ");
			}
			else {
				for(j = 1; j <= width; j++) {
					if(j == 1 || j == width)
						printf("* ");
					else
						printf("  ");
				}
			}
			printf("\n");
		}
		 printf("===========================\n");	
}
//hinh 5 file E-Star
        1
      2 3 2
    3 4 5 4 3
  4 5 6 7 6 5 4
5 6 7 8 9 8 7 6 5
void shape12(int line)
{
	int i, j, k = 0, count = 0, count1 = 0;
   for (i = 1; i <= line; ++i) {
      for (j = 1; j <= line - i; ++j) {
         printf("  ");
         ++count;
      	}
      while (k != 2 * i - 1) {
         if (count <= line - 1) {
            printf("%d ", i + k);
            ++count;
         } else {
            ++count1;
            printf("%d ", (i + k - 2 * count1));
         }
         ++k;
      }
      count1 = count = k = 0;
      printf("\n");
	}
 printf("===========================\n");	
}

//pascal triangle
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
void shape13(int line)
{
	int i, j;
	for(i = 0; i<=line; i++) 
		{
			for (j = line; j>i; j--) 
			{
				printf(" ");
			}
			int number = 1;
			for (j = 0; j<=i; j++) 
			{
				printf("%d ",number);
				number = number *(i-j)/(j+1);
			}
			printf("\n");
		}
	 printf("===========================\n");		
			
}
int prime(int n)
{
	int i;
	if(n == 1) return 0;
	for(i = 2; i <= sqrt(n); i++)
	{
		if (n % i == 0) return 0;
	}
	return 1;
}
//prime triangle
2 3 5 7 11
13 17 19 23
29 31 37
41 43
47
void shape14(int line)
{
	int i, j, d= 0;
	for(i = line; i >= 1;i--)
	{
		for (j=1; j<=i; )
		{
			d++;
			if(prime(d)) {
				printf("%d ", d);
			j ++;
			}
		}
		printf("\n");	
	}
	printf("===========================\n");	
}

1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
void shape15(int line)
{
	int i,j;
	for (i=1;i<=line;i++) {
  	if (i%2!=0) {
	  for (j=1;j<=i;j++) if (j%2!=0) printf("1 ");
  	  							else printf("0 ");
	  } else {
	  	 for (j=1;j<=i;j++) if (j%2!=0) printf("0 ");
  	  							else printf("1 ");
	  }
  	  
  	  
  	  printf("\n");
  }
}

int main()
{
	shape1(5);
	shape2(5);
	shape3(5);
	shape4(5);
	shape5(5);
	shape6(5);
	shape7(5);
	shape8(5);
	shape9(5);
	shape10(9);
	shape11(4,6);
	shape12(5);
	shape13(4);
	shape14(5);
	shape15(5);
}




