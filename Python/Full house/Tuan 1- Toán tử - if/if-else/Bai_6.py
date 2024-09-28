import math

a = int(input("Nhập tham số a: "))
b = int(input("Nhập tham số b: "))
c = int(input("Nhập tham số c: "))

delta = b * b - 4 * a * c
if a == 0:
    if b == 0:
        if c == 0:
            print("Phương trình có vô số nghiệm.")
        else:
            print("Phương trình vô nghiệm.")
    else:
        print(f"Phương trình có 1 nghiệm x = {-c / b}.")

else:
    if delta < 0:
        print("Phương trình vô nghiệm.")
    elif delta == 0:
        print(f"Phương trình có nghiệm kép x1 = x2 = {-b / (2 * a)}.")
    else:
        print(f"Phương trình có 2 nghiệm phân biệt là x1 = {(-b + math.sqrt(delta)) / (2 * a)} và x2 = {(-b - math.sqrt(delta)) / (2 * a)}.")
