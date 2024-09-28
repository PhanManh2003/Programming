A = [1, 2, "Hello", "xxx", 9, "aaa", 9, 9, 1, "bbazx", 4, 1]
B = []
for value in A:
    if type(value) != str:
        B.append(value)
# Cách 1:
temp = ''
for i in range(0, len(B) - 1, 1):
    for j in range(i + 1, len(B), 1):
        if B[i] > B[j]:
            temp = B[i]
            B[i] = B[j] # gán A = B
            B[j] = temp
print(f"List A sau khi xoá bỏ phần tử là chuỗi và sắp xếp theo giá trị tăng dần: {B}")

names = ['Bob', 'Alice', 'Guido']
for index, value in enumerate(names):
    print(f"{index}: {value}")

