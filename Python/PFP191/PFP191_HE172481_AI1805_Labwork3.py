# Phan Tiến Mạnh - HE172481 - AI1805
import string

# Question 1
print("Question 1")
print("\n1. Print the following pattern")
for i in range(1, 7, 1):
    for j in range(1, i):
        print(j, end=' ')
    print()

print("\n2. Calculate the sum of all numbers from 1 to a given number")
n = int(input("Enter number: "))
s = 0
for i in range(1, n + 1):
    s += i
print(f"Sum is:  {s}")

# Question 2
print("\nQuestion 2")
print("\n1. Display numbers from a list using loop")
a = [75, 150, 33, 300, 14, 145, 203, 700]
for value in a:
    if value % 5 == 0 and value <= 150:
        print(value)
    elif value > 150:
        continue
    elif value > 500:
        break

print("\n2. Count the total number of digits in a number")
n = int(input("Enter a number: "))
n_str = str(n)
digits = len(n_str)
print(f"Total digits are: {digits}")

print("\n3. Print list in reverse order using a loop")
list1 = [10, 20, 30, 40, 50]
for i in range(len(list1), 0, -1):
    print(list1[i - 1])

# Question 3
print("\nQuestion 3")
print("\n1. Create a string made of the middle four characters")
a = input("Enter a string: ")
print(f"Original string is: {a}")
n = len(a)
if n < 4 or n % 2 == 1:
    print("Not exist middle four chars")
elif n == 4:
    print(f"Middle four chars are: {a}")
else:
    m = n // 2
    middle_string = a[m - 2: m + 2]
    print(f"Middle four chars are: {middle_string}")

print("\n2. Given two strings,s1 and s2. Write a program to create a new string s3 by appending s2 in the middle of s1")
s1 = "Ault"
s2 = "Kelly"
s3 = s1[:len(s1) // 2] + s2 + s1[len(s1) // 2:]
print(s3)

print("\n3. Write a program to return a new string made of s1 and s2’s first, middle, and last characters")
s1 = "America"
s2 = "Japan"
s3 = s1[0] + s2[0] + s1[len(s1) // 2] + s2[len(s2) // 2] + s1[-1] + s2[-1]
print(s3)

print("\n4. Arrange string characters such that lowercase letters should come first")
str1 = "PyNaTive"
result = ''.join(sorted(str1, key=lambda x: x.isupper()))
print(result)

print("\n5. Count all letters, digits, and special symbols from a given string")
input_string = input("Enter a string: ")
print(f"Input string = {input_string}")

letter_count = 0
digit_count = 0
special_count = 0
for char in input_string:
    if char.isalpha():
        letter_count += 1
    elif char.isdigit():
        digit_count += 1
    else:
        special_count += 1

print("Total counts of chars, digits and symbols")
print(f"Chars = {letter_count} Digits = {digit_count} Symbol = {special_count}")

# Question 4
print("\nQuestion 4")
print("\n1. Removal all characters from a string except integers")
str1 = "I am 25 years and 10 months old"
output_str = ""
for char in str1:
    if char.isdigit():
        output_str += char
print(output_str)

print("\n2. Remove special symbols / punctuation from a string")
str1 = "/*Jon is @developer & musician"
t = str1.maketrans('', '', string.punctuation)
output_str = str1.translate(t)
output_str = output_str.replace('  ', ' ')
print(output_str)

print("\n3. Remove empty strings from a list of strings")
str_list = ["Emma", "Jon", "", "Kelly", None, "Eric", ""]
print(f"Original list of string")
print(str_list)
for index, value in enumerate(str_list):
    if value == '' or not value:
        del str_list[index]
print(f"After removing empty strings")
print(str_list)

print("\n4. Split a string on hyphens")
str1 = "Emma-is-a-data-scientist"
print("Displaying each substring\n")
a = str1.split('-')
for value in a:
    print(value)