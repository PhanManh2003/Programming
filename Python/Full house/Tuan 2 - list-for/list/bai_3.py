a = [1, 2, "Hello", 9, 9, 9, 1, 4, 1]
for value in a:
    if type(value) == str:
        a.remove(value)
print(f"List A sau khi đã loại bỏ string:\n {a}")