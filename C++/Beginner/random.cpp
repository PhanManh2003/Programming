// Chương trình thể hiện các số ngẫu nhiên
#include <iostream>
#include <cstdlib> // đối với rand và srand
#include <ctime> // đối với hàm time

using namespace std;
int main() {
    // Nhận thời gian hệ thống.
    unsigned seed = time(0); // hàm time nhận 0 làm đối số cho hàm
    cout << seed << endl; // số giây tính từ 01/01/1970

    // Khởi tạo bộ sinh số ngẫu nhiên bằng srand()
    srand(seed); // srand chấp nhận đối số unsigned int , đối số này hoạt động như một giá trị hạt giống
    
    // Hiển thị 3 số ngẫu nhiên
    cout << rand() << endl; // Số trả về từ hàm là int
    cout << rand() << endl;
    cout << rand() << endl;

    // Giới hạn phạm vi của số ngẫu nhiên: y = (rand() % (maxValue - minValue) + 1 ) + minValue;    

    // Chương trình xúc xắc
    const int MIN_VALUE = 1;
    const int MAX_VALUE = 6;

    int die1,die2;
    // unsigned seed = time(0); (bên trên đã khai báo rồi nên thôi)
    // srand(seed);

    cout << "-----Rolling the dice-------\n";
    die1 = (rand() % (MAX_VALUE - MIN_VALUE + 1))+ MIN_VALUE;                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    die2 = (rand() % (MAX_VALUE - MIN_VALUE + 1))+ MIN_VALUE;  
    cout << die1 << endl;
    cout << die2 << endl;
    return 0;
}