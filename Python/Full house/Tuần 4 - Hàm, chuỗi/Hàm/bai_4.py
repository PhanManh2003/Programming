def f(n: int):
    if n == 0 or n == 1:
        return n
    return f(n - 1) + f(n - 2)


n = int(input("Nhập n: "))
print(f(n)) # print ra cái giá trị return của hàm
