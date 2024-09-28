# Viết chương trình Python để lấy một chuỗi đơn từ hai chuỗi đã cho,
# cách nhau bởi dấu cách và hoán đổi hai ký tự đầu tiên của mỗi chuỗi.
# Chuỗi mẫu: abc, xyz
# Kết quả mong đợi: xbc ayz

# TODO: Tách thành 2 chuỗi đơn từ một chuỗi đã nhập
a = input("Nhập 2 chuỗi cách nhau bằng dấu phẩy: ")
a = a.split(',')
for index, value in enumerate(a):
    a[index] = a[index].replace(' ', '')
print(a)

# TODO: Hoán đổi kí tự
x = a[0][0]
y = a[1][0]
a[0] = a[0].replace(x, y, 1)  # replace 1 lần đầu thui
a[1] = a[1].replace(y, x, 1)
print(' '.join(a))
