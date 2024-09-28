/*
    Khi gặp continue, tất cả các câu lệnh trong phần thân của vòng lặp mà xuất hiện sau nó đều bị bỏ qua
    và vòng lặp chuẩn bị cho lần lặp tiếp theo
    - Trong vòng while , chương trình sẽ nhảy đến biểu thức kiểm tra ở đầu vòng lặp
    - Trong do-while, chương trình sẽ nhảy đến biểu thức kiểm tra ở cuối vòng lặp
    - Trong for, chương trình sẽ cho biểu thức cập nhật thực thi , sau đó là biểu thức kiểm tra
*/
#include <iostream>
using namespace std;
int main()
{
    int testVal = 0;
    while (testVal++ < 10) // : Kiểm tra testVal < 10 rồi thực thi vòng lặp, sau đó mới tăng 1 đơn vị
    {
        if (testVal == 4)
        continue;
        cout << testVal << " ";
    }


    return 0;
}