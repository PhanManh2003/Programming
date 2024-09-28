N = int(input("Nhập số nguyên N bất kỳ: "))

if N > 0:
    for integer in range(N, 0, -1):
        print(f"{integer}", end=' ')
else:
    for integer in range(N, 2, 1):
        print(f"{integer}", end=' ')
