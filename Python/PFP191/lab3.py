def menu():
    print("-------------Student Information----------------")
    print("     Name    :   Phan Tiến Mạnh")
    print("     ID      :   HE172481")
    print("     Class   :   AI1805")
    print("------------------------------------------------")
    print("---------------------MENU-----------------------")
    print("     [a] Cau 1               [f] Cau 6")
    print("     [b] Cau 2               [g] Cau 7")
    print("     [c] Cau 3               [h] Cau 8")
    print("     [d] Cau 4               [i] Cau 9")
    print("     [e] Cau 5               [j] Cau 10")
    print("                   [E] Exit                     ")
    print("------------------------------------------------")
    choice = input("Enter your option: ")
    return choice


def cau1():  # a.Đếm các ký tự lặp lại trong một chuỗi
    print("--------------------Cau 1-----------------------")
    string = input("Input string: ")
    print("Result:")
    for value in set(string):
        print(f"'{value}':      {string.count(value)}")
    print("------------------------------------------------")


def cau2():  # b.	Hoán đổi các trường hợp in hoa in thường trong một chuỗi đã cho.
    print("--------------------Cau 2-----------------------")
    string = input("Input string: ")
    print("Result:")
    print(string.swapcase())
    print("------------------------------------------------")


def cau3():  # c.	Viết hoa chữ cái đầu tiên và viết thường các chữ cái còn lại trong một chuỗi cho trước.
    print("--------------------Cau 3-----------------------")
    string = input("Input string: ")
    print("Result:")
    print(string[0].upper() + string[1:].lower())
    print("------------------------------------------------")


def cau4():  # d.	Xóa các ký tự không mong muốn khỏi một chuỗi đã cho.
    print("--------------------Cau 4-----------------------")
    string = input("Input string: ")
    print("Result:")
    for value in string:
        if not value.isalpha():
            string = string.replace(value, ' ')
    print("Result:")
    print(string)
    print("------------------------------------------------")


def cau5():  # e.	Thay thế từng ký tự của một từ có độ dài từ 4 trở lên bằng một ký tự #.
    print("--------------------Cau 5-----------------------")
    string = input("Input string: ")
    a = string.split()
    for index, value in enumerate(a):
        if len(a[index]) >= 4:
            for i in a[index]:
                a[index] = a[index].replace(i, '#')
    result = ' '.join(a)
    print("Result:")
    print(result)
    print("------------------------------------------------")


def cau6():  # f.	Thay thế các ký tự lặp lại bằng các ký tự đơn
    print("--------------------Cau 6-----------------------")
    string = input("Input string: ")
    result = string[0]
    for i in range(1, len(string)):
        if string[i] != string[i - 1]:
            result += string[i]
    print("Result:")
    print(result)
    print("------------------------------------------------")


def cau7():  # g.	Nhập vào một chuỗi và trả về ‘-‘ ở cả hai phía của mỗi phần tử không phải là nguyên âm.
    print("--------------------Cau 7-----------------------")
    string = input("Input string: ")
    result = ""
    vowels = "AEIOUaeiou"

    for char in string:
        if char not in vowels:
            result += "-" + char + "-"
        else:
            result += char
    print("Result:")
    print(result)
    print("------------------------------------------------")


def cau8():  # h.	Trích xuất tên từ một địa chỉ Email
    print("--------------------Cau 8-----------------------")
    string = input("Input string: ")
    f = string.find('@')
    result = ""
    for i in range(0, f):
        result += string[i]

    print("Result:")
    print(result)
    print("------------------------------------------------")


def cau9():  # i.	Đếm số lần mỗi chuỗi chứa ba chữ cái giống nhau ở cùng một chỉ mục.
    print("--------------------Cau 9-----------------------")
    string1 = input("Input string 1: ")
    string2 = input("Input string 2: ")
    count = 0

    if len(string1) >= len(string2):
        length = len(string2)
    else:
        length = len(string1)
    for i in range(0, length):
        if string1[i] == string2[i]:
            count += 1

    print("Result:")
    print(count)
    print("------------------------------------------------")


def cau10():  # j.	Tìm mức độ giống nhau của chuỗi giữa hai chuỗi đã cho
    print("--------------------Cau 10-----------------------")

    def algorithm(x, y):
        m = len(x)
        n = len(y)
        l = [[None] * (n + 1) for i in range(m + 1)]  # tạo ma trận m + 1 hàng và n + 1 cột
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 or j == 0:
                    l[i][j] = 0
                elif x[i - 1] == y[j - 1]:
                    l[i][j] = l[i - 1][j - 1] + 1
                else:
                    l[i][j] = max(l[i - 1][j], l[i][j - 1])
        return l[m][n]

    def score(x, y):
        return algorithm(x, y) / max(len(x), len(y))

    string1 = input("Input string 1: ")  # "Cong hoa xa hoi chu nghia Viet Nam"
    string2 = input("Input string 2: ")  # "Cong hoax a hoich u nghiaV ietN am"

    print("Result:")
    print(score(string1, string2))
    print("------------------------------------------------")


def main():
    choice = menu()
    if choice == 'a':
        cau1()
    elif choice == 'b':
        cau2()
    elif choice == 'c':
        cau3()
    elif choice == 'd':
        cau4()
    elif choice == 'e':
        cau5()
    elif choice == 'f':
        cau6()
    elif choice == 'g':
        cau7()
    elif choice == 'h':
        cau8()
    elif choice == 'i':
        cau9()
    elif choice == 'j':
        cau10()
    elif choice == 'E':
        exit()
    else:
        print("Nhập sai")


if __name__ == '__main__':
    main()
