a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
for value in a:
    if type(value) == str:
        a.remove(value)
print(a)
# thuật toán lấy vị trí từ i đến vị trí cuối làm phạm vi và:
# với mỗi giá trị i thì tìm ra giá trị đạt cực trị trong phạm vi đó rồi gán bằng a[i]
for i in range(0, len(a) - 1, 1):
    for j in range(i + 1, len(a), 1):
        if a[i] > a[j]:
            temp = a[i]
            a[i] = a[j]
            a[j] = temp
print(a)

