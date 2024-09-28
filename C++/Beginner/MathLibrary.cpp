 /* 1. y = abs(x);
    2. y = cos(x)/ sin(x)/ tan(x);
    3. y = log(x);
    4. y = fmod(x,z); : trả về phần dư của x/z
    5. y = exp(x); : tính e^x
    6. y = log10(x);
    7. y = sqrt(x) 

    Dùng thư viện cmath
 */
#include <cmath>
#include <iostream>
#include <iomanip>
using namespace std;
int main(){
    double a,b,c;

    cout << "Enter the length of side a: ";
    cin >> a;
    cout << "Enter the length of side b: ";
    cin >> b;
    c = sqrt(pow(a,2) + pow(b,2));
    cout << "The length of the hypotenuse is ";
    cout << setprecision(2) << fixed << c << endl;
    return 0;
}
