a = '1 3 2 -1 0 -10 '
numbers = a.split()
result = []

for value in numbers:
    value = int(value) #ép kiểu
    if value >= 0:
        result.append(value)

for i in range(0, len(result) - 1, 1):
    for j in range(i + 1, len(result), 1):
        if result[i] > result[j]:
            temp = result[i]
            result[i] = result[j]
            result[j] = temp
print(result)

# 1: tách chuỗi to thành chuỗi con.
# 2: ép kiểu chuỗi con thành số và đưa vào 1 list A
# 3: sắp xếp lại các số trong list A
# 4: in list A