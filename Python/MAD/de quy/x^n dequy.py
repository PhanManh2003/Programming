# HE172481 - AI1805
def power(x, n):
    if n == 0:
        return 1
    else:
        return x * power(x, n - 1)


result = power(6, 5)
print(result)
