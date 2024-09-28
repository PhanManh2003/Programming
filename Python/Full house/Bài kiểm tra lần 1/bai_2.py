while True:
    n = int(input("Nhập số nguyên dương n: "))
    if n <= 0:
        print("Nhập sai, nhập lại đi.")
    else:
        sum = 0
        for i in range(1, n + 1):
            sum += i
        print(f"Tổng các số 1 + 2 + 3 + ... + n bằng: {sum}")
        break
