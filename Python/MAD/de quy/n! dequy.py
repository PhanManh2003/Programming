# HE172481 - AI1805
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)  # hàm return chính nó


# Egxample
result = factorial(5)
print(result)  # Output: 120
