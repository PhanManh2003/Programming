#include <iostream> 
using namespace std; 
  
int main() 
{ 
    // Tóm lại là cin.get để đọc và gán bất kì 1 kí tự nào từ bàn phím kể cả kí tự khoảng trắng cho 1 biến char 
    char ch;
    cout << "This program has paused 1. Press Enter to continue.";
    cin.get(ch); // cách viết 1
    cout << "This program has paused 2. Press Enter to continue.";
    ch = cin.get(); // cách viết 2
    cout << "This program has paused 3. Press Enter to continue.";
    cin.get(); // cách viết 3
    return 0; 
} 