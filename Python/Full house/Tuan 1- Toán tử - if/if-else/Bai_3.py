import math

a = int(input("Enter the value of first side of the triangle: "))
b = int(input("Enter the value of the second side of the triangle: "))
c = int(input("Enter the value of the third side of the triangle: "))

if a >= b + c or b >= a + c or c >= b + a:
    print("Not valid!")
else:
    p = (a + b + c) / 2
    area = math.sqrt(p*(p-a)*(p-b)*(p-c))
    print(f"The area of the triangle is: {area}")
