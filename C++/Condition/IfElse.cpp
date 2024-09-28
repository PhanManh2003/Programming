#include <iostream>
using namespace std;
int main(){
    bool value = true;
    if (value)
        cout << "hello" << endl;
    else
        cout << "hi" << endl;
    
    // toán tử quan hệ: < > <= >= == != (ưu tiên hơn toán tử logic) 
    // toán tử logic và thứ tự ưu tiên: !(not) > && (and) > ||(or) 
    

            // Chương trình tính điểm chữ
    const int   A_SCORE = 90,
                B_SCORE = 80,
                C_SCORE = 70,
                D_SCORE = 60;
    int testScore;
    
    cout << "Enter the numeric test score: ";
    cin >> testScore;
    // ! Không cho viết (5 < x < 20) mà phải viết là (x > 5 && x < 20)
    if(testScore >= A_SCORE)
        cout << "Your grade is A.\n";
    else if (testScore >= B_SCORE)
        cout << "Your grade is B.\n";
    else if (testScore >= C_SCORE)
        cout << "Your grade is C.\n";
    else if (testScore >= D_SCORE)
        cout << "Your grade is D.\n";
    else
        cout << "Your grade is F.\n";

    // toán tử điều kiện (toán tử 3 ngôi) -> syntax: result = expression ? value1 : value2 
    int a, x = 101;
    a = x > 100 ? 0 : 1; 
        /*  
            if (x > 100)
                a = 0;
            else 
                a = 1;
        */ 
    cout << a << endl;

    cout << "Your grade is: " << (testScore < 60 ? "Fail" : "Pass");// đóng ngoặc vì toán tử << được ưu tiên hơn 

    // Toán tử 3 ngôi:  condition ? true_value : false_value;
    return 0;
}