import cmath
from math import tan, pi

# Câu 1:
print("Câu 1")
name = input("Input name: ")
ID = input("Input ID: ")
Class = input("Input class: ")
print("--------------------Student Information-------------------")
print(f"     Name    : {name}")
print(f"     ID      : {ID}")
print(f"     Class   : {Class}")
print("----------------------------------------------------------\n")

# Câu 2:
print("Câu 2")
print("-------------------Convert C to F-------------------------")
c = float(input("Input degree Centigrade: "))
f = 9 / 5 * c + 32
print(f"{round(f, 2)} degrees Fahrenheit")
print("----------------------------------------------------------\n")

# Câu 3:
print("Câu 3")
print("----------------------Dog's age---------------------------")
human_year = int(input("Input a dog's age in human years: "))
if 0 < human_year <= 2:
    dog_age = human_year * 10.5
    print(f"The dog's age in dog's years is: {int(dog_age)}")
elif human_year > 2:
    dog_age = 2 * 10.5 + (human_year - 2) * 4
    print(f"The dog's age in dog's years is {int(dog_age)}")
else:
    print("You enter the wrong value.\n")
print("----------------------------------------------------------\n")

# Câu 4:
print("Câu 4")
print("---------------------Convert month------------------------")
print("List of months: January, February, March, April, May, June,")
print("July, August, September, October, November, December")
month = input("Input the name of Month: ")
if month == 'January':
    print("No. of days: 31/31 days")
elif month == 'February':
    print("No. of days: 28/29 days")
elif month == 'March':
    print("No. of days: 31/31 days")
elif month == 'April':
    print("No. of days: 30/31 days")
elif month == 'May':
    print("No. of days: 31/31 days")
elif month == 'June':
    print("No. of days: 30/31 days")
elif month == 'July':
    print("No. of days: 31/31 days")
elif month == 'August':
    print("No. of days: 31/31 days")
elif month == 'September':
    print("No. of days: 30/31 days")
elif month == 'October':
    print("No. of days: 31/31 days")
elif month == 'November':
    print("No. of days: 30/31 days")
elif month == 'December':
    print("No. of days: 31/31 days")
else:
    print("You enter the wrong value.")
print("----------------------------------------------------------\n")

# Câu 5:
print("Câu 5")
print("--------------------Check triangle------------------------")
x = float(input("x: "))
y = float(input("y: "))
z = float(input("z: "))
if x < 0 or y < 0 or z < 0:
    print("The input must be positive.")
if x + y > z and x + z > y and y + z > x:
    if x == y and y == z:
        print("Equilateral triangle")
    elif (x == y and x != z) or (y == z and y != x) or (x == z and x != y):
        print("Isosceles triangle")
    else:
        print("Normal triangle")

else:
    print("No triangle exists.")
print("----------------------------------------------------------\n")

# Câu 6:
print("Câu 6")
print("------------------Quadratic function----------------------")
a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))

discriminant = (b ** 2) - (4 * a * c)
sol1 = (-b + cmath.sqrt(discriminant)) / (2 * a)
sol2 = (-b - cmath.sqrt(discriminant)) / (2 * a)

if discriminant < 0:
    print("No root")
elif discriminant == 0:
    print(f"There are 1 root: {-b/(2*a)}")
else:
    print(f"There are 2 roots: {sol1} and {sol2}")
print("----------------------------------------------------------\n")

# Câu 7:
print("Câu 7")
day = int(input("Enter the day: "))
month = int(input("Enter the month: "))
year = int(input("Enter the year: "))

if month in (4, 6, 9, 11):
    max_days = 30
elif month == 2:
    if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0):
        max_days = 29
    else:
        max_days = 28
else:
    max_days = 31

if day < max_days:
    day += 1
else:
    day = 1
    if month == 12:
        month = 1
        year += 1
    else:
        month += 1
print(f"The next day is [yyyy-mm-dd]: {year}-{month}-{day}")
print("----------------------------------------------------------\n")

# Câu 8:
print("Câu 8")
print("-------------------Area regular polygon--------------------")
number = int(input("Input number of sides: "))
length = float(input("Input length of a side: "))
area = (number * length ** 2) / (4 * tan(pi / number))
print(f"The area of a regular polygon with {number} sides and {length} side length  is: {round(area, 2)}")
print("----------------------------------------------------------\n")

# Câu 9:
print("Câu 9")
f1_numerator = int(input("Enter the numerator of the first fraction: "))
f1_denominator = int(input("Enter the denominator of the first fraction: "))
f2_numerator = int(input("Enter the numerator of the second fraction: "))
f2_denominator = int(input("Enter the denominator of the second fraction: "))
denominator = f1_denominator * f2_denominator

add_numerator = f1_numerator * f2_denominator + f1_denominator * f2_numerator
sub_numerator = f1_numerator * f2_denominator - f1_denominator * f2_numerator
mul_numerator= f1_numerator * f2_numerator
div_numerator = f1_numerator * f2_denominator
div_denominator = f1_denominator * f2_numerator

print("-----------------------Fractions--------------------------")
print(f"{f1_numerator}/{f1_denominator} + {f2_numerator}/{f2_denominator} = {add_numerator}/{denominator}")
print(f"{f1_numerator}/{f1_denominator} - {f2_numerator}/{f2_denominator} = {sub_numerator}/{denominator}")
print(f"{f1_numerator}/{f1_denominator} * {f2_numerator}/{f2_denominator} = {mul_numerator}/{denominator}")
print(f"{f1_numerator}/{f1_denominator} / {f2_numerator}/{f2_denominator} = {div_numerator}/{div_denominator}")
print("----------------------------------------------------------\n")