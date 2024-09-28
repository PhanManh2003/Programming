# Y hệt list nhưng phần tử không thay đổi được ( có chỉ số)

# 1. Khai báo tuple
a = ()  # tuple trống
b = (10,)  # chứa dấu , nếu có duy nhất 1 phần tử
c = (10) # ko phải tuple
print(a)
print(b)
print(c)
# 2. Xóa tuple ( dùng del)


# 3. Thêm phần tử
day1 = ('monday', 'tuesday', 'wednesday')
day2 = ('thursday', 'friday', 'saturday', 'sunday')
day = day1 + day2
print(day)  # ('monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday')

# 4. Tuple lồng ( giống list)
day1 = ('monday', 'tuesday', 'wednesday')
day2 = ('thursday', 'friday', 'saturday', 'sunday', day1)
print(day2)
print(day2[4][0])  # monday trong day1

# 5. Compare two tuples
a = (6, 1, 2) < (5, 1, 2)
b = ('Aron', 'Sally') < ('Jones', 'Sam')
print(a, b)

# 6. Sort by Values instead of Keys in dict
a = {'a': 10, 'b': 1, 'd': 25, 'c': 22}
b = list()
for k, v in a.items():
    b.append((v, k))
print(b)
b = sorted(b, reverse=True)
print(b)
