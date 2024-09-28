import os, fractions
from math import sqrt, tan, pi
os.system('cls')

#Câu 1: In thong tin
print('--------------------Studen Information--------------------')
print('     Name    :                                            ')
print('     ID      :                                            ')
print('     Class   :                                            ')
print('----------------------------------------------------------')
print('\n')
#Câu 2: Viết chương trình chuyển đổi từ nhiệt độ C sang độ F
print('----------------------Convert C to F----------------------')
temp_c = float(input('Input degree Centigrade:'))
temp_f = ((9.0 / 5.0) * temp_c) + 32.0
print(temp_f,'degrees Fahrenheit')
print('----------------------------------------------------------')
print('\n')
#Câu 3: Tính số tuổi của chó
print("-------------------------Dog's age------------------------")
h_age = int(input("Input a dog's age in human years: "))
if h_age < 0:
	print("Age must be positive number.")
	exit()
elif h_age <= 2:
	d_age = h_age * 10.5
else:
	d_age = 21 + (h_age - 2)*4
print("The dog's age in dog's years is", d_age)
print('----------------------------------------------------------')
print('\n')
#Câu 4: Chuyển đổi tên tháng thành số ngày
print("-----------------------Convert month----------------------")
print("List of months: January, February, March, April, May, June, \nJuly, August, September, October, November, December")
month_name = input("Input the name of Month: ")
if month_name == "February":
	print("No. of days: 28/29 days")
elif month_name in ("April", "June", "September", "November"):
	print("No. of days: 30 days")
elif month_name in ("January", "March", "May", "July", "August", "October", "December"):
	print("No. of days: 31 day")
else:
	print("Wrong month name") 
print('----------------------------------------------------------')
print('\n')
#Câu 5 Kiểm tra tam giác
print("----------------------Check triangle----------------------")
print("Input lengths of the triangle sides: ")
x = int(input("x: "))
y = int(input("y: "))
z = int(input("z: "))
if x == y == z:
	print("Equilateral triangle")
elif x==y or y==z or z==x:
	print("Isosceles triangle")
else:
	print("Scalene triangle")
print('----------------------------------------------------------')
print('\n')
#Câu 6 Giải pt bậc hai
print("--------------------Quadratic function--------------------")
a = float(input("a: "))
b = float(input("b: "))
c = float(input("c: "))
if a == 0:
    if b == 0: 
        if c == 0:
            print("Infinite roots")
        else :
            print("No roots")
    else :
        x = (-c)/b
        print("There is one root: ", x)
else :
    r = b**2 - 4*a*c
    if r > 0:
        num_roots = 2
        x1 = (((-b) + sqrt(r))/(2*a))     
        x2 = (((-b) - sqrt(r))/(2*a))
        print("There are 2 roots: %f and %f" % (x1, x2))
    elif r == 0:
        num_roots = 1
        x3 = (-b) / 2*a
        print("There is a double root: ", x3)
    else :
        num_roots = 0
        print("No roots, discriminant < 0.")
        exit()
print('----------------------------------------------------------')
print('\n')
#Câu 7 Ngày tiếp theo ngày vừa nhập
print("-------------------------Next day-------------------------")
year = int(input("Input a year: "))

if (year % 400 == 0):
    leap_year = True
elif (year % 100 == 0):
    leap_year = False
elif (year % 4 == 0):
    leap_year = True
else:
    leap_year = False

month = int(input("Input a month [1-12]: "))

if month in (1, 3, 5, 7, 8, 10, 12):
    month_length = 31
elif month == 2:
    if leap_year:
        month_length = 29
    else:
        month_length = 28
else:
    month_length = 30


day = int(input("Input a day [1-31]: "))

if day < month_length:
    day += 1
else:
    day = 1
    if month == 12:
        month = 1
        year += 1
    else:
        month += 1
print("The next date is [yyyy-mm-dd] %d-%d-%d." % (year, month, day))
print('----------------------------------------------------------')
print('\n')
#Câu 8 Diện tích đa giác đều
print("-------------------Area regular polygon-------------------")
n_sides = int(input("Input number of sides: "))
s_length = float(input("Input the length of a side: "))
p_area = n_sides * (s_length ** 2) / (4 * tan(pi / n_sides))
print("The area of the polygon is: ",p_area)
print('----------------------------------------------------------')
print('\n')
# Câu 9 Cộng trừ nhân chia 2 phân số
print("-------------------------Fractions------------------------")
a1, b1 = int(input("a1: ")),int(input("b1: "))
a2, b2 = int(input("a2: ")),int(input("b2: "))
if b1 == 0 or b2 == 0:
    print('Infinity')
else:
    f1 = fractions.Fraction(a1, b1)
    f2 = fractions.Fraction(a2, b2)
    print('{} + {} = {}'.format(f1, f2, f1 + f2))
    print('{} - {} = {}'.format(f1, f2, f1 - f2))
    print('{} * {} = {}'.format(f1, f2, f1 * f2))
    print('{} / {} = {}'.format(f1, f2, f1 / f2))
print('----------------------------------------------------------')
