a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
for value in a:
    if type(value) == str:
        a.remove(value)
print(f"List A sau khi đã loại bỏ string:\n{a}")
a.sort()
print(f"3 phần tử nhỏ nhất trong list A lần lượt là: {a[0]}, {a[1]}, {a[2]}")