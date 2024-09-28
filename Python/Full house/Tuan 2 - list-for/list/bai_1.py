a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
flag = False
x = input("Nhập giá trị bất kì: ")
for value in a:
    if x.isnumeric() and int(x) == value:
        flag = True
    if type(value) == str and x == value:
        flag = True

if flag:
    print(f"{x} có trong mảng.")
else:
    print(f"{x} không có trong mảng.")
