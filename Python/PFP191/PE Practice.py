# Write a  program that performs the following tasks:
#1.	Create a function with variable length of arguments
import math
def func1(a,b,c):
    print("Printing values")
    print(a)
    print(b)
    print(c)
func1(20,40,60)
#2.	Return multiple values from a function
def calculation(a,b):
    return(f"{a*b}")
res = calculation(40,10)
print(res)


#Write a program to accept  2  integer numbers  m and n, then:
#1.	Create a function with default argument
def showEmployee( a: str, b: float = 9000):
    print(f"Name: {a} salary: {b}")

showEmployee("Ben", 12000)
showEmployee("Jessy")

#2.	Create an inner function to calculate the addition in the following way
#•	Create an outer function that will accept two parameters, a and b
#•	Create an inner function inside an outer function that will calculate the addition of a and b
#•	At last, an outer function will add 5 into addition and return it
def outer_func(a,b):
    def inner_func(a,b):
        return a + b
    return inner_func(a,b)
    
result = outer_func(5,10)
print(result)


#Write a  program that performs the following tasks:
#1.	Create a recursive function
# Write a program to create a recursive function to calculate the sum of numbers from 0 to 10.
# A recursive function is a function that calls itself, again and again.
def addition(n: int):
    if n == 0:
        return 0
    else:
        return n + addition(n-1)
    
res = addition(10)
print(res)

#2.	Assign a different name to function and call it through the new name
def display_student(name,age):
    print(name, age)
display_student("Emma", 26)
show_student = display_student
show_student("Emma", 27)


#Write a program that performs the following tasks:
#1.	Check Palindrome Number
#A palindrome number is a number that is same after reverse. For example 545, is the palindrome numbers
def check_palindrome(n: float):
    n_str = str(n)
    if n_str == n_str[::-1]:
        print("Palindrome")
    else:
        print("Not Palindrome")

check_palindrome(25)

#2.	Find the largest item from a given list
x = [4, 6, 8, 24, 12, 2]
max = x[0]
for value in x:
    if value > max:
        max = value
print(max)


#Write a  program that performs the following tasks:
#1.	Input an integer number  n, where  n > 5 (If  n≤ 5 then prompt a user to re-enter). Then calculate
#2.	S1 = 1 + 2 + 3 + ... + n.
#3.	S2 = n! 
#4.	S3 =1+ + +...+ .
#5.	Re-input n. Check whether n is a prime number or not.
def calculation():
    n = int(input("Nhập n: "))
    while n <= 5:
            print("Nhập n > 5")
            n = int(input("Nhập n: "))
    
    s1 = 0
    for i in range(1,n+1):
        s1 += i
    print(s1)

    s2 = 1
    for i in range(1,n+1):
        s2 *= i
    print(s2)

    s3 = 0
    for i in range(1,n+1):
        s3 += 1/i
    print(s3) 
    
    num = int(input("Nhập n: "))
    def is_prime(num):
        if num < 2:
            return False
        for i in range(2, int(math.sqrt(num))+1):
            if num % i == 0:
                return False
        return True
    if is_prime(num):
        print("Prime")
    else:
        print("Not prime")

calculation()


#Write a program to accept  2  integer numbers  m and n, then:
#1.	Display all common prime dividers of them.
#2.	Find the greatest common divider (GCD) of them.
#3.	Find the least common multiple (LCM) of them.
def show():
    m = int(input("Enter first integer: "))
    n = int(input("Enter second integer: "))
    def is_prime(num):
        if num < 2:
            return False
        for i in range(2, int(math.sqrt(num))+1):
            if num % i == 0:
                return False
        return True

    def common_prime_dividers(m, n):
        common_dividers = []
        for i in range(2, min(m,n)+1):
            if m % i == 0 and n % i == 0 and is_prime(i):
                common_dividers.append(i)
        return common_dividers


    def gcd(m, n):
        while n != 0:
            m, n = n, m % n
        return m


    def lcm(m, n):
        return (m * n) // gcd(m, n)

    print(common_prime_dividers(m, n))
    print(gcd(m, n))
    print(lcm(m, n))

show()

#Write a  program that performs the following tasks:
#1.	Input an integer number  n (check input validation), then
#2.	Display n  in binary number format.
#3.	Re-input n (not check input validation). Calculate the sum of all digits of n.
#4.	Find the number m, which is the reverse of n.

def input_validation():
    num = input("Nhập n: ")
    try:
        b = int(num)
        print("ok")
    except ValueError:
        num = int(input("Nhập n: "))
    return b

a = input_validation()
print(a)
print(bin(a))
print(bin(a).replace("0b", ""))