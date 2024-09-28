N = int(input("Nhập số nguyên N bất kỳ: "))
# range(a,b,c) thì sẽ dừng ở vị trí trước nó 1 đơn vị và gần mốc 0 nhất
if N > 0:
    for integer in range(1, N + 1, 1):
        print(f"{integer}", end=' ')
else:
    for integer in range(1, N - 1, -1): # nếu N <= 0 thì N sẽ đứng trước N-1
        print(f"{integer}", end=' ')
