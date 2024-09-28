# Viết chương trình Python để xóa khoảng trắng khỏi một chuỗi đã cho.

# TODO: Cách 1
text = input("Nhập chuỗi: ")
if ' ' in text:
    text = text.replace(' ', '')
print(text)

# TODO: Cách 2
text = input("Nhập chuỗi: ")
for value in text:
    if value.isspace():
        text = text.replace(value, '')  # value = value.replace(' ', '') ( Sai)
print(text)

# TODO: Cách 3
text = input("Nhập chuỗi: ")
text = text.split(' ')
print(''.join(text))
