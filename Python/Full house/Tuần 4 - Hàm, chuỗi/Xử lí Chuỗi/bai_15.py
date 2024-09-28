# Viết chương trình Python để hoán đổi dấu phẩy và dấu chấm trong một chuỗi.
# Chuỗi mẫu: "32.054,23"
# Kết quả mong đợi: "32.054,23"

# TODO: Cách 1
a = '32.054,23.425,234,546'
inputs = ",."
outputs = ".,"
b = a.maketrans(inputs, outputs)
print(a.translate(b))

# TODO: Cách 2
a = "32.054,23"
a = list(a)
for i in range(len(a)):
    if a[i] == '.':
        a[i] = ','
    elif a[i] == ',':
        a[i] = '.'
print(''.join(a))
