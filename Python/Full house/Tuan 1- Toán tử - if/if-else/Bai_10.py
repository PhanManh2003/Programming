import math

a = int(input("Nhập chiều dài cạnh a: "))
b = int(input("Nhập chiều dài cạnh b: "))
c = int(input("Nhập chiều dài cạnh c: "))


if a <= 0 or b <= 0 or c <= 0:
    print("Not valid!")
elif a >= b + c or b >= a + c or c >= b + a:
    print("Triangle not exist!")
else:
    p = (a + b + c) / 2
    area = math.sqrt(p * (p - a) * (p - b) * (p - c))
    if (a == b and b == c):
        style = 'đều'
    elif (a == b or a == c or b == c):
        style = 'cân'
    elif (a * a + b * b == c * c or a * a + c * c == b * b or b * b + c * c == a * a):
        style = 'vuông'
    else:
        style = 'thường'
    print(f"Đây là tam giác {style}, có diện tích là: {area} (dvdt)")

