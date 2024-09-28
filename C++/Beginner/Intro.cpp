#include <iostream>
#include <string>
#include <cmath>
#include <iomanip> // input, output manipulation
using namespace std;


int main()
{
	bool value;
	value = true;
	cout << value << endl; // print : 1
	
	char letter; // char is indeed an int
	letter = 65; // print : "A"
	cout << letter << endl;

	// Determine the size of a value type.
    cout <<"short int: " << sizeof(short)<< " bytes" << endl;
	cout <<"int: " << sizeof(int)<< " bytes" << endl;
	cout <<"long int: " << sizeof(long int)<< " bytes" << endl;
	cout <<"long long int: " << sizeof(long long int)<< " bytes" << endl;

	cout <<"float: " << sizeof(float)<< " bytes" << endl; 
	cout <<"double: " << sizeof(double)<< " bytes" << endl;
	cout <<"long double: " << sizeof(long double)<< " bytes" << endl;
    /*
    Data Type                              Range                      Macro for min value           Macro for max value
char                                -128 to +127                        CHAR_MIN                      CHAR_MAX
short char                          -128 to +127                       SCHAR_MIN                     SCHAR_MAX
unsigned char                         0  to 255                             0                        UCHAR_MAX

short int                         -32768 to +32767                      SHRT_MIN                      SHRT_MAX
unsigned short int                    0  to  65535                          0                        USHRT_MAX 
int                          -2147483648 to +2147483647                  INT_MIN                       INT_MAX
unsigned int                          0  to  4294967295                     0                         UINT_MAX
long int            -9223372036854775808 to +9223372036854775807        LONG_MIN                      LONG_MAX
unsigned long int                     0  to  18446744073709551615           0                        ULONG_MAX 
long long int       -9223372036854775808 to +9223372036854775807       LLONG_MIN                     LLONG_MAX
unsigned long long int                0  to  18446744073709551615           0                       ULLONG_MAX

float                        1.17549e-38 to  3.40282e+38                 FLT_MIN                       FLT_MAX
float(negative)             -1.17549e-38 to -3.40282e+38                -FLT_MIN                      -FLT_MAX
double                      2.22507e-308 to  1.79769e+308                DBL_MIN                       DBL_MAX
double(negative)           -2.22507e-308 to -1.79769e+308               -DBL_MIN                      -DBL_MAX
    */


    // Khai báo biến với từ khóa auto
    auto amount = 101 , rate = 123, k = 8; // nếu 2 biến không thuộc cùng kiểu dữ liệu thì không được khai báo liền nhau
    auto stockCode = "Buffet";
    cout << amount << ' ' << stockCode << ' ' << rate << endl;
	
    
    
    // int/double = int
    // double/int = double
    // Khi cả 2 toán hạng (kiểu double) của phép chia đều ở dạng số nguyên thì kết quả cũng là số nguyên
    double x,y,z;
    x = 5 / 2;
    y = 5.0 / 2;
    z = 5 / 2.0;
    cout << x << endl << y << endl << z << endl;

    int t = 100;
    t = t / 2.6;
    cout << t << endl; // kết quả là số nguyên: 38


    // Toán tử ép kiểu static_cast : static_cast<DataType>(ValueNeedConvertToDataType)
    int books , months;
    double perMonth;
    cout << "How many books do you plan to read? ";
    cin >> books;
    cout << "How many months will it take to read them? ";
    cin >> months;
    perMonth = static_cast<double>(books) / months; // chuyển biến books về kiểu double
    cout << "That is " << setprecision(2) << fixed << perMonth << " books per month.\n";
        // Hiển thị x chữ số sau dấu thập phân dùng setprecision(x) + fixed;


    
    return 0;
}
