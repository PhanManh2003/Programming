# Viết chương trình Python để đếm số ký tự (tần số ký tự) trong một chuỗi.
# Chuỗi mẫu của trình chỉnh sửa: ‘google.com’
# Kết quả mong đợi: {' g ': 2,' o ': 3,' l ': 1,' e ': 1,'. ': 1,' c ': 1 , 'm': 1}

string = 'google.com'
result = dict()
for value in string:
    result[value] = result.get(value, 0) + 1
print(result)
