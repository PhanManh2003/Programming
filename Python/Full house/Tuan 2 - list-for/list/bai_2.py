a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
count = 0
x = input("Nhập giá trị bất kì: ")
for value in a:
    if x.isnumeric() and int(x) == value:
        count += 1
    if type(value) == str and x == value:
        count += 1
if count > 0:
    print(f"{x} có trong mảng, số lần xuất hiện của {x} là: {count}")
else:
    print(f"{x} không có trong mảng.")
