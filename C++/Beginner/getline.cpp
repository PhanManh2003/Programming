#include <iostream>
#include <string>
using namespace std;

int main(){

    /* Khi cin đọc đầu vào , nó sẽ truyền đi và bỏ qua bất kì kí tự "khoảng trắng" nào ở đầu
     (tab,space,enter). Khi đến kí tự không khoảng trắng đầu tiên và bắt đầu đọc, nó sẽ dừng đọc khi 
     chuyển đến kí tự khoảng trắng tiếp theo
     */
            
    // getline cho phép đọc toàn bộ 1 dòng , bao gồm cả khoảng trắng ở đầu và khoảng trắng input từ phím
        string name;
        string city;
        
        cout << "Please enter your name: ";
        getline(cin, name);
        cout << "Enter the city you live in: ";
        getline(cin, city);

        cout << "Hello, " << name << endl;
        cout << "You live in " << city << endl;
        
        string greet1 = "hello ", object = "world";
        string greet2;
        
        // phép cộng chuỗi
        greet2 = greet1 + object;
        cout << greet2 << endl;
        greet1 += object;
        cout << greet1 << endl;
        return 0;

}
