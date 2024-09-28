#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
    int n = 9;
    // Hiểu đơn giản i là cột mốc để cho j chạy và in. 
    // Chú ý: 2 biến i và j là hoàn toàn độc lập.
    for (int i = 0; i <= n; i++)
    { 
        for(int j = n - i; j >= 0; j--)
        {
            cout << "*"; 
        }
        cout << endl;
    } 
   
    return 0;
}