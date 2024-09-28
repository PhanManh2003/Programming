# HE172481 - AI1805
def binary_search(a, x):
    i = 0
    j = len(a) - 1
    while i < j:
        m = (i + j) // 2
        if x > a[m]:
            i = m + 1
        else:
            j = m
    if x == a[i]:
        location = i
    else:
        location = False
    return location


a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
x = 8
location = binary_search(a, x)

if location:
    print(f"The location of x is {location}")
else:
    print("Not found")



