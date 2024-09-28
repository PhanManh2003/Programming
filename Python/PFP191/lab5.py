# Name: Phan Tiến Mạnh
# ID : HE172481
# Class: AI1805

# Question 1
print("\nQuestion 1.\n")

# 1.	Creating a list in Python
a = [[1, 2, 3], [1, 2, 3], [1.0, 'Jessa', 3], [], []]
for list_element in a:
    print(list_element)

# 2.	Concatenate two lists index-wise
list1 = ["M", "na", "i", "Ke"]
list2 = ["y", "me", "s", "lly"]
result = list()
for i, j in zip(list1, list2):
    result.append(i + j)
print(result)

# Question 2
print("\nQuestion 2.\n")

# 1.	Turn every item of a list into its square
a = [1, 2, 3, 4, 5, 6, 7]
square = [i ** 2 for i in a]
print(square)

# 2.	Concatenate two lists in the following order
list1 = ["Hello ", "take "]
list2 = ["Dear", "Sir"]
result = []
for x in list1:
    for y in list2:
        result.append(x + y)
print(result)

# Question 3
print("\nQuestion 3.\n")

# 1.	Merge two Python dictionaries into one
dict1 = {'Ten': 10, 'Twenty': 20, 'Thirty': 30}
dict2 = {'Thirty': 30, 'Fourty': 40, 'Fifty': 50}


def Merge_Dict(a, b):
    result = a | b
    return result


dict_3 = Merge_Dict(dict1, dict2)
print(dict_3)

# 2.	Print the value of key ‘history’ from the below dict
sampleDict = {
    "class": {
        "student": {
            "name": "Mike",
            "marks": {
                "physics": 70,
                "history": 80
            }
        }
    }
}
print(sampleDict['class']['student']['marks']['history'])

# 3.	Initialize dictionary with default values
employees = ['Kelly', 'Emma']
defaults = {"designation": 'Developer', "salary": 8000}
a = dict()
for name in employees:
    a[name] = defaults
print(a)
# cách 2: Dùng fromkeys() method
# a = dict.fromkeys(employees, defaults)
# print(a)

# Question 4
print("\nQuestion 4.\n")

# 1.	Access value 20 from the tuple
tuple1 = ("Orange", [10, 20, 30], (5, 15, 25))
wanted = tuple1[1][1]
print(wanted)

# 2.	Unpack the tuple into 4 variables
tuple1 = (10, 20, 30, 40)
a, b, c, d = tuple1
print(a)
print(b)
print(c)
print(d)

# 3.	Swap two tuples in Python
tuple1 = (11, 22)
tuple2 = (99, 88)

tuple1, tuple2 = tuple2, tuple1
print(tuple1)
print(tuple2)
