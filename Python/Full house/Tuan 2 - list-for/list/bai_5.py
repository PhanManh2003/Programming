a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
count = 0
x = input("Nhập giá trị bất kì: ")

none = ''
for index, value in enumerate(a):
    if x.isnumeric() and int(x) == value:
        location = index
        break
    elif type(value) == str and x == value:
        location = index
        break
    else:
        location = none
if location == none:
    print(f"Ký tự {x} không có trong list A")
else:
    print(f"Ký tự {x} xuất hiện lần đầu trong list A ở vị trí thứ: {location}")
