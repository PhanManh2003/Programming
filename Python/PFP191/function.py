# 1.    Viết hàm để in các bảng chữ cái từ a đến z
def print_alphabets():
    for i in range(97, 123):
        print(chr(i), end=" ")


print_alphabets()
print(chr(47))


# 2.    Viết hàm để in các giá trị ASCII của tất cả các ký tự
def print_ascii_values():
    for i in range(0, 256):
        print("{}: {}".format(i, chr(i)))


print_ascii_values()


# 3.    Viết hàm để in bảng cửu chương của một số cho trước
def mul_table(n: int):
    for i in range(1, 11, 1):
        print(f"{n} * {i} = {n * i}")


mul_table(3)


# 4.    Viết hàm để hoán đổi chữ số đầu tiên và chữ số cuối cùng của một số
def swap_first_last_digit(num):
    num_str = str(num)  # đổi sang kiểu chuỗi
    if len(num_str) <= 1:
        return num
    return float(num_str[-1] + num_str[1:-1] + num_str[0])


print(swap_first_last_digit(123.456))


# 5.	Viết hàm để đảo ngược một số
def reverse_a_number(num):
    num_str = str(num)
    if len(num_str) <= 1:
        return num
    return float(num_str[::-1])


print(reverse_a_number(719.034))


# 6. Viết hàm để tìm giai thừa của một số bất kỳ
def get_factorial(n: int):
    result = 1
    if n == 0:
        return result
    else:
        if n > 0:
            for i in range(1, n + 1):
                result *= i
            return result
        else:
            return "Nhập số tự nhiên, ngu"


print(get_factorial(-8))


# 7. Viết hàm để kiểm tra một số nhập vào có phải là số Nguyên tố hay không
def prime(n: int):
    if n < 0:
        return "Nhập số tự nhiên"
    elif n < 2:
        return f"{n} không phải số nguyên tố"
    else:
        divisor_count = 0
        for i in range(1, n + 1):
            if n % i == 0: # mấu chốt của bài toán
                divisor_count += 1
        if divisor_count == 2:
            return f"{n} là số nguyên tố"
        else:
            return f"{n} không phải số nguyên tố"


print(prime(35))


# 8.Viết một hàm để kiểm tra xem một số có phải là palindrome/số hoàn hảo/armstrong hay không
def check_palindrome(n: int):
    n_str = str(n)
    if n_str[:] == n_str[::-1]:
        return "Palindrome"
    else:
        return "Không phải palindrome"


print(check_palindrome(232))
