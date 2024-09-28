int		%d, %i
char		%c
float		%f
double		%lf
short int	%hd
unsigned int	%u
long int	%ld, %li
long long int	%lld, %lli
unsigned long int %lu
unsigned long long int	%llu
signed char		%c
unsigned char		%c
long double		%Lf

//nhap so in ra hinh so
#include <stdio.h>

int main(){
    int i, j, row;
    scanf("%d", &row);
    
    for(i = 1; i <= row; i++){
        for(j = 1; j <= i; j++){
            printf("%d ", j);
        }
        printf("\n");
    }
    
    
    return 0;
}

----------------------------------------------------
//nhap so hinh ra hinh chu
int main() {
int i, j, rows, count=0;
printf("Enter the number of rows\n");
scanf("%d", &rows);
for (i = 0; i < 2*rows; i=i+2) {
for (j = 0; j <= i; j++) {
printf("%c", 'A'+count);
if(j < i/2)
count++;
else
count--;
}
count = 0;
printf("\n");
}
return(0);
}
-----------------------------------
//chuyen cac ki tu viet hoa thanh ki tu viet thuong

#include <stdio.h>
#include <string.h>
#define MAX_LENGTH 100
int main() {
	int i;
char str[MAX_LENGTH + 1]; 
int len;

printf("Enter a string (maximum length %d): ", MAX_LENGTH);
fgets(str, MAX_LENGTH + 1, stdin);

len = strlen(str);
if (str[len - 1] == '\n') {
str[len - 1] = '\0';
}

for (i = 0; i < len; i++) {
if (str[i] >= 'A' && str[i] <= 'Z') {
str[i] = str[i] + ('a' - 'A');
}
}

printf("%s\n", str);
return 0;
}
-------------------------------------------
//chu cai dau cua moi chu trong chuoi thanh in hoa
#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
char str[100];
printf("Enter a string with a maximum length of 100 characters: ");
fgets(str, sizeof(str), stdin);
int len = strlen(str);
if (len > 0 && str[len-1] == '\n') {
str[--len] = '\0';
}
for (i = 0; i < len; i++) {
if (i == 0 || isspace(str[i-1])) {
str[i] = toupper(str[i]);
}
else if (i == 1 || (i > 1 && !isalpha(str[i-2]) && isspace(str[i-1]))) {
str[i] = toupper(str[i]);
}
}
printf("The modified string is: %s\n", str);
return 0;
}
----------------------
//sap xep tang dan theo thu tu le, le trc chan sau
void main() {
int n, i, j, temp;
printf("Enter the number of elements in the array: ");
scanf("%d", &n);
int array[n];
printf("Enter the elements of the array: ");
for (i = 0; i < n; i++) {
scanf("%d", &array[i]);
}
// separate odd and even numbers
int odds[n], evens[n], oddIndex = 0, evenIndex = 0;
for (i = 0; i < n; i++) {
if (array[i] % 2 == 1) {
odds[oddIndex] = array[i];
oddIndex++;
} else {
evens[evenIndex] = array[i];
evenIndex++;
}
}
// sort odd and even numbers separately
for (i = 0; i < oddIndex; i++) {
for (j = i + 1; j < oddIndex; j++) {
if (odds[i] > odds[j]) {
temp = odds[i];
odds[i] = odds[j];
odds[j] = temp;
}
}
}
for (i = 0; i < evenIndex; i++) {
for (j = i + 1; j < evenIndex; j++) {
if (evens[i] > evens[j]) {
temp = evens[i];
evens[i] = evens[j];
evens[j] = temp;
}
}
}
// merge odd and even numbers back into one array
int result[n], resultIndex = 0;
for (i = 0; i < oddIndex; i++) {
result[resultIndex] = odds[i];
resultIndex++;
}
for (i = 0; i < evenIndex; i++) {
result[resultIndex] = evens[i];
resultIndex++;
}
// print the sorted array
printf("Sorted array: ");
for (i = 0; i < n; i++) {
printf("%d ", result[i]);
}
}














//Binary to Decimal

int main()
{
    unsigned long long num, binary_val, decimal_val = 0, base = 1, rem;
 
    printf("Enter a binary number(1s and 0s) \n");
    scanf("%llu", &num);
    binary_val = num;
    while (num > 0)
    {
        rem = num % 10;
        decimal_val = decimal_val + rem * base;
        num = num / 10 ;
        base = base * 2;
    }
    printf("The Binary number is = %llu \n", binary_val);
    printf("Its decimal equivalent is = %llu \n", decimal_val);
}

----------------------------------------------------------------------------
//Binary to Octal

int main()
{
long int binarynum, octalnum = 0, j = 1, remainder;
printf("Enter the value for binary number: ");
scanf("%ld", &binarynum);
while (binarynum != 0)
{
remainder = binarynum % 10;
octalnum = octalnum + remainder * j;
j = j * 2;
binarynum = binarynum / 10;
}
printf("Equivalent octal value: %lo", octalnum);
return 0;
}

--------------------------------------------------------------------

//Binary to Hexa

int main(){
   long int binaryval, hexadecimalval = 0, i = 1, remainder;
   printf("Enter the binary number: ");
   scanf("%ld", &binaryval);
   while (binaryval != 0){
      remainder = binaryval % 10;
      hexadecimalval = hexadecimalval + remainder * i;
      i = i * 2;
      binaryval = binaryval / 10;
   }
   printf("Equivalent hexadecimal value: %lX", hexadecimalval);
   return 0;
}
------------------------------------------------------------------------

//Decimal to Binary
int main()  
{  
int a[10],n,i;  
 
printf("Nhap mot so bat ky: ");  
scanf("%d",&n);  
for(i=0;n>0;i++)  
{  
a[i]=n%2;  
n=n/2;  
}  
printf("\nDang nhi phan cua so vua nhap la = ");  
for(i=i-1;i>=0;i--)  
{  
printf("%d",a[i]);  
}  
getch();
}
------------------------------------------------------------------------------
//Decimal to Octal

// function prototype
int convertDecimalToOctal(int decimalNumber);

int main() {

    int decimalNumber;

    printf("Enter a decimal number: ");
    scanf("%d", &decimalNumber);

    printf("%d in decimal = %d in octal", decimalNumber, convertDecimalToOctal(decimalNumber));

    return 0;
}

// function to convert decimalNumber to octal
int convertDecimalToOctal(int decimalNumber) {
    int octalNumber = 0, i = 1;

    while (decimalNumber != 0) {
        octalNumber += (decimalNumber % 8) * i;
        decimalNumber /= 8;
        i *= 10;
    }

    return octalNumber;
}
-------------------------------------------------------------------------------

//Decimal to Hexa

int main() {
long int num_decimal , remainder , quotient ;
int a = 1 , b , var ;
char hexanum_decimal[ 100 ] ;
printf( " Please enter decimal number here : " ) ;
scanf( "%ld" , &num_decimal ) ;
quotient = num_decimal ;
while( quotient != 0 ) {
var = quotient % 16 ;
if( var < 10 )
var = var + 48 ;
else
var = var + 55 ;
hexanum_decimal[ a++ ]= var ;
quotient = quotient / 16;
}
printf( " The equivalent hexadecimal value of decimal number is %ld : " , num_decimal ) ;
for ( b = a -1 ; b > 0 ; b-- )
printf( "%c" , hexanum_decimal[ b ] ) ;
return 0 ;
}
------------------------------------------------------------------
//Decimal to Char
int main()
{
    int n;
    char c;
    scanf("%d", &n);
    c = (char) n;
    printf("%c", c);
    return 0;
}
===========================================================================
//Octal to Decimal
// function prototype
long long convertOctalToDecimal(int octalNumber);

int main() {

    int octalNumber;

    printf("Enter an octal number: ");
    scanf("%d", &octalNumber);

    printf("%d in octal = %lld in decimal", octalNumber, convertOctalToDecimal(octalNumber));

    return 0;
}

// function to convert octalNumber to decimal
long long convertOctalToDecimal(int octalNumber) {
    int decimalNumber = 0, i = 0;

    while(octalNumber != 0) {
        decimalNumber += (octalNumber%10) * pow(8,i);
        ++i;
        octalNumber/=10;
    }

    i = 1;

    return decimalNumber;
}
--------------------------------------------------------------------
//Octal to Binary
int main()
{
    int i, octal, decimal = 0;
    long binary = 0;
    i = 0;
    
    printf("Enter the Octal Number = ");
    scanf("%d",&octal);

    while(octal != 0)
    {
        decimal = decimal + (octal % 10) * pow(8, i);
        i++;
        octal = octal / 10;
    }
    i = 1;
    while(decimal != 0)
    {
        binary += ((decimal % 2) * i);
        decimal = decimal / 2;
        i = i * 10;
    }

    printf("The Binay Value = %ld\n", binary); 
}
-----------------------------------------------------------------------------
//Hexa to Decimal
int main()
{
    char hex[17];
    long long decimal, place;
    int i = 0, val, len;

    decimal = 0;
    place = 1;

    /* Input hexadecimal number from user */
    printf("Enter any hexadecimal number: ");
    gets(hex);

    /* Find the length of total number of hex digit */
    len = strlen(hex);
    len--;

    /*
     * Iterate over each hex digit
     */
    for(i=0; hex[i]!='\0'; i++)
    {
 
        /* Find the decimal representation of hex[i] */
        if(hex[i]>='0' && hex[i]<='9')
        {
            val = hex[i] - 48;
        }
        else if(hex[i]>='a' && hex[i]<='f')
        {
            val = hex[i] - 97 + 10;
        }
        else if(hex[i]>='A' && hex[i]<='F')
        {
            val = hex[i] - 65 + 10;
        }

        decimal += val * pow(16, len);
        len--;
    }

    printf("Hexadecimal number = %s\n", hex);
    printf("Decimal number = %lld", decimal);

    return 0;
}
---------------------------------------------------------------------







//Ham ktra so chinh phuong
int isPerfectSquare(int n){
    return sqrt(n)==floor(sqrt(n));
}

//Ham ktra so nguyen to
int isPrime(int n){
    if (n<2) return 0;
    int i,l=(int) sqrt(n);
    for (i=2;i<=l;i++)
        if (n%i==0) return 0;
    return 1;
}

//ham kiem tra so hoan hao (n>0)
int isPerfect(int n){
    if (n<6) return 0;
    int s=1,i;
    for (i=2;i<=n/2;i++)
        if (n%i==0) s+=i;
    return s==n;
}

//Nhap vao mang a[] gom n phan tu
void inputArray(int a[], int* n){
    scanf("%d",n);
    int i;
    for (i=0;i<*n;i++){
        scanf("%d",&a[i]);
    }
}

//in ra mang a ra man hinh
void printArray(int a[],int n){
    int i;
    printf("%d\n",n);
    for (i=0;i<n;i++) printf("%d ",a[i]);
    printf("\n");
}

//Trao doi gia tri trong 2 con tro (2 bien)
void q_swap(int* a,int* b){
    int c=*a;
    *a=*b;
    *b=c;
}

//int m,n la 2 so nguyen duong (n>1)
//check xem m co phai la luy thua cua n hay ko (n^x=m  (x in N))
int isPowerOf(int m, int n){
    if (m<1) return -1;
    int exp = 0;
    while (m!=1){
        if (m%n!=0) return -1;  //khong phai luy thuy
            else m/=n;
        exp++;
    }
    return exp; //tra ve so mu
}

//long m,n la 2 so nguyen duong (n>1);
//check xem m co phai la luy thua cua n hay ko (n^x=m  (x in N))
int isPowerOf_long(long m, long n){
    if (m<1) return -1;
    int exp = 0;
    while (m!=1){
        if (m%n!=0) return -1;
            else m/=n;
        exp++;
    }
    return exp;
}

//sap xep chon
//order = 1 : tang dan; order = -1 : giam dan
void q_selectSort(int a[],int n,int order){
    int i,j;
    for (i=0;i<n-1;i++){
        int pos =i;
        for (j=i+1;j<n;j++){
            if ((a[j]-a[pos])*order<0){
                pos = j;
            }
        }
        q_swap(&a[i],&a[pos]);
    }
}

//sap xep chon (de qui)
void q_selectSort_Recur(int a[],int n,int order){
    if (n==1) return;
    int i,k=0;
    for (i=1;i<n;i++){
        if ((a[i]-a[k])*order > 0) k=i;
    }
    q_swap(a+n-1,a+k);
    q_selectSort(a,n-1,order);
}

//sap xep nhanh (phan doan), l,r la dau dit cua doan can sap xep (Kho, Ko hay dung)
void q_quickSort(int a[],int l,int r,int order){
    int i=l,j=r,x=a[l];
    while (i<j){
        while ((a[i]-x)*order < 0) i++;
        while ((a[j]-x)*order > 0) j--;
        if (i<=j){
            q_swap(a+i,a+j);
            i++;
            j--;
        }
    }   
    if (l<j) q_quickSort(a,l,j,order);
    if (r>i) q_quickSort(a,i,r,order);
}

//Sap xep noi bot
void q_bubbleSort(int a[],int n,int Order){
    int i,j;
    for (i=0;i<n-1;i++){
        for (j=i+1;j<n;j++){
            if ((a[j]-a[i])*Order<0){
                q_swap(&a[i],&a[j]);
            }
        }
    }  
}

//sap xep chen
void q_insertionSort(int a[],int n,int Order){
    int i,j,t;
    for (i=1;i<n;i++){
        t=a[i];
        j=i-1;
        while (j>=0 && ((a[j]-t)*Order)>0){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=t;
    }
}

//xoa phan tu thu i trong mang a[]
void arrayDelete(int a[],int *p,int x){
    if (x<0 || x>=*p || *p==0){
        return;
    }
    int i;
    for (i=x+1;i<*p;i++) a[i-1]=a[i];
    *p-=1;
}

//chen x vao vi tri i
void arrayInsert(int a[],int *n,int x, int i){
    if (i<0||i>=*n) return;
    int j;
    for (j=*n-1;j>=i;j--) a[j+1]=a[j];
    a[i]=x;
    *n+=1;
}


/*========Cac ham string==========*/

//In ra xau co ngoec kep "%s" (de kiem tra thoi, ko can dung dau)
void printString(char s[]){
    printf("\"%s\"\n",s);
}

//In ra tu dai nhat trong xau
void q_longestWord(char s[]){
    int k=0,i=0,mark=-1,lmax=0;
    
    while (s[i]!='\0'){
        if (s[i]==' '){
            k=0;
        }
        else{
            k++;
            if (k>=lmax){
                lmax=k;mark=i;
            }
        }
        
        i++;
    }

    printf("\"");
    for (i=mark-lmax+1;i<=mark;i++) printf("%c",s[i]);
    printf("\"\n");
}

//dao nguoc xau S
void inverseString(char s[]){
    int i=0, j=strlen(s)-1;
    while (i<j){
        char c=s[i];
        s[i]=s[j];
        s[j]=c;
        i++; 
        j--;
    }
}

//xoa string S tu vi tri l -> r (0 <= l <= r <=length)
void deleteString(char s[],int l, int r){
    int len = strlen(s);
    if (r>=len || l<0 || l>r ){
        return;
    }
    int i;
    for (i=r+1;i<=len;i++) s[i-r+l-1]=s[i];
}

//copy string S1 tu vi tri l->r, luu vao S2
void copyString(char s2[],char s1[], int l, int r){
    int i;
    for (i=l;i<=r;i++){
        s2[i-l]=s1[i];
    }
    s2[r-l+1]='\0';
}

//xoa dau cach trong string
void removeSpace(char s[]){
    int l=0;
    while (s[l]==' ') l++;
    deleteString(s,0,l-1);

    l=strlen(s)-1;
    while (s[l]==' ') l--;
    s[l+1]=0;

    while (l>0){
        if (s[l]==' ' && s[l-1]==' ') {
            int mark_r = l-1;
            while (s[l]==' ') l--;
            deleteString(s,l+1,mark_r);
        }
        l--;
    }
}

//Tach xau thanh cac tu, luu vao mang arrS[][]
void splitString(char arrS[][64], char s[]){
    int mark[64];

    int i=0,count=0;
    while (s[i]==' ') i++;
    mark[0]=i;

    for (i=i;s[i]!=0;i++){
        if (s[i]!=' ' && s[i-1]==' '){
            mark[++count]=i;
        }
    }

    arrS[count+1][0]=0;
    while (count>=0){
        int x= mark[count];
        int j= 0;
        while (s[x]!=' ' && s[x]!='\0'){
            arrS[count][j]=s[x];
            j++;
            x++;
        }
        arrS[count][j]='\0';
        count--;
    }
}

/* tim so be thu 2 trong mang
int main() {
    int n, i, sml, s2sml;
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int a[n];
    printf("Enter the elements of the array:\n");
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    // Find the smallest element in the array
    sml = a[0];
    for (i = 1; i < n; i++) {
        if (a[i] < sml) {
            sml = a[i];
        }
    }

    // Find the second smallest element in the array
    s2sml = a[i];
    for (i = 1; i < n; i++) {
        if (a[i] < s2sml && a[i] != sml) {
            s2sml = a[i];
        }
    }

    printf("The second smallest element in the array is: %d\n", s2sml);

    return 0;
}*/



/* Q1.Exercises_review : Write a program, use the pointer to enter a sequence of integers consist N element (check input N and elements)
#include <stdio.h>

int main() {
    int i, N;
    printf("Enter the size of the array: ");
    scanf("%d", &N);

    // Allocate memory for the array
    int* arr = (int*) malloc(N * sizeof(int));

    // Prompt the user to enter the elements of the array
    printf("Enter %d integers separated by spaces:\n", N);
    for (i = 0; i < N; i++) {
        scanf("%d", arr + i);
    }

    //Compute the maximum, minimum, and sum of the array using pointers
    int* ptr = arr;
    int max = *ptr;
    int min = *ptr;
    int sum = 0;
    for (i = 0; i < N; i++) {
        if (*(ptr + i) > max) {
            max = *(ptr + i);
        }
        if (*(ptr + i) < min) {
            min = *(ptr + i);
        }
        sum += *(ptr + i);
    }

    // Output the results
    printf("Maximum value: %d\n", max);
    printf("Minimum value: %d\n", min);
    printf("Sum of elements: %d\n", sum);

    // Free the memory allocated for the array
    free(arr);

    return 0;
}*/



//                                    In ra so octal, hexa
int main() {
    char ch;
    // Prompt user for a character
    scanf("%c", &ch);
    // Print ASCII code, octal, and hexadecimal representation
    printf("%d ", ch);
    printf("0%o\n", ch);
    printf("0x%x\n", ch);

    return 0;
}



//                      Tim ky tu xuat hien nhieu nhat va xuat hien bao nhieu lan
int main(){
    char str[100];
    int freq[256];
    int i, max_freq = 0;
    char max_char;
    printf("Input the string: ");
    scanf("%s", str)
    // count frequency of each character
    for(i = 0; i<strlen(str); i++)
    {
        freq[str[i]]++;
    }
    // find the character with maximum frequency
    for(i = 0; i < 256; i++)
    {
        if(freq[i] > max_freq)
        {
            max_freq = freq[i];
            max_char = i;
        }
    }
    printf("The Highest frequency of character '%c' appears number of times: %d\n", max_char, max_freq);
    return 0;
}



//                                       Nhap chuoi va dao nguoc chuoi giam dan
int main(){
	char temp, s[100];
	int i, j;
	scanf("%s", s);
	int len = strlen(s);
	for(i=0; i<len-1; i++){
		for(j=i+1; j<len; j++){
			if(s[i]<s[j]){
				temp = s[i];
            	s[i] = s[j];
            	s[j] = temp;
			}
		}
	}

		printf("%s", s);

	return 0;
}




//                                    Nhap chuoi va lay chuoi tu 1 diem den do dai
int main() {
   char str[100], substr[100];
   int start, len, i, j;
   printf("Input the string: ");
   fgets(str, 100, stdin);
   printf("Input the position to start extraction: ");
   scanf("%d", &start);
   printf("Input the length of substring: ");
   scanf("%d", &len);
   j = 0;
   for(i=start-1; i<start-1+len; i++){
      substr[j] = str[i];
      j++;
   }
   substr[j] = '\0';
   printf("Substring extracted is: %s", substr);
   return 0;
}






//									Nhap chuoi va in ra tu dai nhat va ngan nhat
int main(){
   char str[100], word[100], largest[100], smallest[100];
   int i, j, len, largest_len = 0, smallest_len = 100;
   printf("Input the string: ");
   fgets(str, 100, stdin);
   j = 0;
   for(i=0; i<=strlen(str); i++){
      if(str[i]==' ' || str[i]=='\0'){
         word[j] = '\0';
         len = strlen(word);
         if(len > largest_len){
            largest_len = len;
            strcpy(largest, word);
         }
         if(len < smallest_len){
            smallest_len = len;
            strcpy(smallest, word);
         }
         j = 0;
      }
      else{
         word[j] = str[i];
         j++;
      }
   }
   printf("The largest word is: %s\n", largest);
   printf("The smallest word is: %s\n", smallest);
   return 0;
}
