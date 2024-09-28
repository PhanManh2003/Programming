# HE172481 - AI1805
def power_of_2(n):
    if n == 0:
        return 1
    else:
        return 2 * power_of_2(n - 1)


result = power_of_2(5)
print(result)  # Output: 32
