#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
    // Hiểu đơn giản i là cột mốc để cho j chạy và in. 
    // Chú ý: 2 biến i và j là hoàn toàn độc lập.
    for (int i = 1; i <= 10; i++) 
    {
        for (int j = 1; j <= i; j++) 
        {
            cout << "*";
        }
        cout << endl; // xuống hàng
    }

    

    return 0;
}