# Viết chương trình Python để thay đổi một chuỗi đã cho thành một chuỗi mới
# trong đó ký tự đầu tiên và ký tự cuối cùng đã được trao đổi.
a = input("Nhập chuỗi bất kỳ: ")
a = list(a)

# TODO: Cách 1
temp = a[0]
a[0] = a[-1]
a[-1] = temp
print(''.join(a))

# TODO: Cách 2
b = input("Nhập chuỗi lần nữa: ")
b = b[-1:] + b[1:-1] + b[:1]
print(b)

