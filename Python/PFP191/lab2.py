# 1.	Viết hàm cộng nhiều lần tất cả các chữ số của một số không âm được nhập
# từ bàn phím cho đến khi kết quả chỉ có một chữ số.
def bai_1():
    print("Bai 1:")
    print("-----------------Sum of Digit--------------------")

    def sum_of_digits(num):
        while num >= 10:
            sum = 0
            for digit in str(num):
                sum += int(digit)
            num = sum
        return num

    a = int(input("Input number of terms: "))
    print(f"Sum of digit: {sum_of_digits(a)}")
    print("-------------------------------------------------")


# 2.	Viết hàm hiển thị tổng của một chuổi  , với x, n là số nguyên được nhập từ bàn phím.
def bai_2():
    print("Bai 2:")
    print("-----------------Sum Expression------------------")

    def sum_expression(x: int, n: int):
        s = 0
        for i in range(1, n * 2 + 1, 2):
            if i % 4 == 1:
                s += x ** i
            else:
                s -= x ** i

        print("S = ", end='')
        for i in range(1, 2 * n + 1, 2):
            if i % 4 == 1 and i != 2 * n - 1:
                print(f"({x})^{i} - ", end='')
            elif i % 4 == 3 and i != 2 * n - 1:
                print(f"({x})^{i} + ", end='')
            elif i == 2 * n - 1:
                print(f"({x})^{i} ", end='')
        print(f"= {s}")

    x = int(input("Input the value of x: "))
    n = int(input("Input the number of terms: "))
    sum_expression(x, n)


# 3.	Viết hàm hiển thị tổng của một cấp số cộng, với số bắt đầu, số lượng, và số cấp số cộng được nhập từ bàn phím.
def bai_3():
    print("Bai 3:")
    print("----------------Arithmetic progression------------")

    def AP(starting: int, number: int, difference: int):
        s = 0
        print("S = ", end='')
        for i in range(0, number):
            s += (starting + difference * i)
            if i != number - 1:
                print(f"{starting + difference * i} + ", end='')
            else:
                print(f"{starting + difference * i} = {s} ", end='')

    starting = int(input("Input the starting number of the A.P series: "))
    number = int(input("Input the number of items for the A.P series: "))
    difference = int(input("Input the common difference of the A.P series: "))
    AP(starting, number, difference)
    print("\n-------------------------------------------------")


# 4.	Viết hàm kiểm tra xem một số nguyên nhập từ bàn phím có thể được biểu thị dưới dạng tổng của hai số nguyên tố không
def bai_4():
    print("Bai 4:")
    print("----------------Sum of two primes----------------")

    def sum_of_two_primes(num):
        def check_prime(n):
            if n <= 1:
                return False
            for i in range(2, int(n ** 0.5) + 1):
                if n % i == 0:
                    return False
            return True

        exist = []
        count = 0
        for i in range(2, num):
            if check_prime(i) and check_prime(num - i) and i not in exist and num - i not in exist:
                count += 1
                exist.append(i)
                exist.append(num - i)
                print(f"{num} can be written as: {i} + {num - i}")
        if count == 0:
            print("This number cannot be represented as the sum of two primes.")

    a = int(input("Input the number: "))
    sum_of_two_primes(a)
    print("---------------------------------------------------")


# 5.	Viết hàm vẽ hình tam giác Alphabet với số hàng được nhập từ bàn phím
def bai_5():
    print("Bai 5:")
    print("-------------------Alphabet triangle---------------------")

    def alphabet_triangle(rows):
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        char = 0
        for i in range(1, rows + 1):
            spaces = " " * (2 * (rows - i) + 1)
            characters = " ".join(alphabet[char: char + 2 * i - 1])
            char += 2 * i - 1
            print(spaces + characters)

    rows = int(input("Input number of rows: "))
    alphabet_triangle(rows)
    print("---------------------------------------------------")


def display_menu():
    print("------------Menu----------------------")
    print("            [1]. Sum of digit")
    print("            [2]. Sum expression")
    print("            [3]. Arithmetic progression")
    print("            [4]. Sum of two primes")
    print("            [5]. Alphabet triangle")
    print("            [0]. Exit")
    choice = int(input("Enter your choice (1-6): "))
    return choice


def main():
    choice = display_menu()
    if choice == 1:
        bai_1()
    elif choice == 2:
        bai_2()
    elif choice == 3:
        bai_3()
    elif choice == 4:
        bai_4()
    elif choice == 5:
        bai_5()
    else:
        print("invalid choice")


if __name__ == '__main__':
    main()
