# HE172481 - AI1805
def insertion_sort(a: list):
    for i in range(1, len(a)):
        m = a[i]
        j = i - 1
        while j >= 0 and m < a[j]:
            a[j + 1] = a[j]
            j -= 1
        a[j + 1] = m
    return a


a = [4, 7, 1, 3, 10, 33, 22, 14]
print("Result:", insertion_sort(a))
