                    // Đây gọi là vòng lặp thử nghiệm và thường dùng để tạo menu

#include <iostream>
using namespace std;
int main(){

    int score1, score2, score3;
    double average;
    char again;
    
    do
    {
        cout << "Enter 3 scores and I will calculate the average: ";
        cin >> score1 >> score2 >> score3;

        average = (score1 + score2 + score3) / 3.0;
        cout << "The average is " << average << endl;

        cout << "Do you want to take another work? (Y/N): ";
        cin >> again; 


    } while (again == 'Y' || again == 'y');
    // Vòng lặp do-while còn gọi là "vòng lặp do người dùng kiểm soát" và nó sẽ thực thi ít nhất 1 lần

    
    return 0;
}