# Viết một chương trình Python để thêm 'ing' vào cuối một chuỗi đã cho (độ dài ít nhất phải bằng 3).
# Nếu chuỗi đã cho đã kết thúc bằng 'ing' thì hãy thêm 'ly' để thay thế.
# Nếu độ dài chuỗi của chuỗi đã cho nhỏ hơn 3 thì giữ nguyên.

# Chuỗi mẫu: 'abc'
# Kết quả mong đợi: 'abcing'
# Chuỗi mẫu: 'string'
# Kết quả mong đợi: 'stringly'

a = input("Nhập chuỗi mẫu: ")

if len(a) < 3:
    print(a)
else:
    check_str = a[-3:]
    if check_str == 'ing':
        a = a.replace(check_str, 'ly')
    else:
        a += 'ing'

print(f"Kết quả mong đợi: {a}")
