# Viết chương trình Python để đếm số lần xuất hiện của mỗi từ trong một câu đã cho.
a = input("Nhập câu: ")
a = a.split()

# TODO: Lấy danh sách chỉ chứa nguyên các từ có trong câu
for index, value in enumerate(a):
    a[index] = a[index].replace(' ', '')
    a[index] = a[index].replace(',', '')
    a[index] = a[index].replace('.', '')
print(a)  # a là 1 list
#  TODO: Đếm số lần xuất hiện của các từ
b = set(a)
for value in b:
    print(f"{value}: {a.count(value)}")  # chỉ có dạng list mới dùng hàm count dc
