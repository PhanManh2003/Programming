while True:
    n = int(input("Nhập số nguyên dương n: "))
    if n <= 0:
        print("Nhập sai, nhập lại đi.")
    else:
        m = 1
        for i in range(1, n + 1):
            m *= i
        print(f"n! bằng: {m}")
        break
