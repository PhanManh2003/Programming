# Viết chương trình Python biến đổi chuỗi thành chữ thường n ký tự đầu tiên trong một chuỗi.
a = input("Nhập chuỗi: ")
n = int(input("Nhập n: "))
while len(a) < n:
    print("Sai rồi, n <= len(a)!")
    n = int(input("Nhập n: "))
print(a[0:n].lower() + a[n:])