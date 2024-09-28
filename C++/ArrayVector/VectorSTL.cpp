/* STL là một tập hợp các kiểu dữ liệu và thuật toán.
Các kiểu dữ liệu gọi là container gồm 2 loại:  sequence container và associative container.
Sequence container sắp xếp dữ liệu theo kiểu tuần tự như mảng
Associative container thì tổ chức dữ liệu bằng các khóa mà cho phép truy cập ngẫu nhiên, nhanh chóng.
*/

/*
Vector là 1 sequence container giống như mảng:
    - 1 vector chứa 1 chuỗi giá trị hoặc phần tử
    - 1 vector lưu giữ các phần tử ở các vị trí bộ nhớ liền nhau
    - Có thể sử dụng toán tử [] để truy xuất các phần tử
Lợi thế của vector so với mảng:
    - không cần phải khai báo kích thước
    - nếu thêm giá trị vào 1 vector đã đầy thì vector sẽ tự động tăng kích thước
    - vector có thể báo cáo số phần tử mà chúng chứa
*/

#include <iostream>
#include <vector>
#include <algorithm> // dùng cho hàm reverse
using namespace std;
int main()
{
    // Định nghĩa và khởi tạo 1 vector
    vector<int> numbers{1, 2, 3, 4, 5}; // hoặc:  vector <int> numbers(5);

    // Hiển thị các phần tử vector
    for (int val : numbers)
    {
        cout << val << endl;
    }

    // 1. Hàm thành viên pushback
    numbers.push_back(23);
    cout << numbers[5] << endl;

    // 2. Hàm thành viên popback
    numbers.pop_back();
    cout << "The vector after pop:" << endl;
    for (int val : numbers)
    {
        cout << val << " " << endl;
    }

    // 3. Xác định kích thước bằng hàm thành viên size
    cout << "The number of element is: " << numbers.size() << endl;

    // 4. Gán giá trị của phần tử thứ 2 cho x
    int y = numbers.at(3);
    int x = numbers[2];
    cout << "The number x,y is: " << x << "," << y << endl;

    // 5. Đảo thứ tự các phần tử
    reverse(numbers.begin(), numbers.end());
    cout << "The reverse vector is:" << endl;
    for (int val : numbers)
    {
        cout << val << " " << endl;
    }

    // 6. Thay đổi kích thước theo 1 giá trị xác định: resize(element)
    numbers.resize(9, 1); // các phần tử đc thêm vào đặt thành 1 nếu size tăng, giữ nguyên nếu size giảm
    cout << "The vector after resize is: " << endl;
    for (int val : numbers)
    {
        cout << val << " " << endl;
    }

    // 7. Xóa nội dung 1 vector
    numbers.clear();
    cout << "Now the vector has: " << numbers.size() << " element" << endl;

    // 8. Xác định 1 vector trống
    if (numbers.empty())
        cout << "Empty" << endl;
    else
        cout << "Not empty" << endl;

    // 9. Swap 2 vector: vect1.swap(vect2);
    vector<int> vect1{1, 2, 3, 4, 5};
    vector<int> vect2{6, 7, 8, 9, 10};
    vect1.swap(vect2);
    cout << "Vector 1 after swapping:" << endl;
    for (int val : vect1)
    {
        cout << val << " " << endl;
    }
    cout << "Vector 2 after swapping:" << endl;
    for (int val : vect2)
    {
        cout << val << " " << endl;
    }

    // 10. Truy xuất phần tử trong vector bằng iterator:
    //  iterator là một công cụ mạnh mẽ để truy cập và thao tác trên các phần tử của các tập hợp dữ liệu
    vector<int> vec{10, 20, 30, 40, 50};
    vector<int>::iterator i;

    for (i = vec.begin(); i != vec.end(); i++)
    {
        cout << *i << " ";
    }
    cout << endl;
    return 0;
}
