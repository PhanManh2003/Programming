# HE172481 - AI1805
a = [1, 5, 4, 6, 8, 7, 9, 21, 14, 2]
for i in range(0, len(a) - 1):
    for j in range(i + 1, len(a)):
        if a[i] > a[j]:
            temp = a[i]
            a[i] = a[j]
            a[j] = temp
print(a)
