def gcd(a: int, b: int):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


result = gcd(93, 66)
print(result)  # Output: 3
