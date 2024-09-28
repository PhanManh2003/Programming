# Nguyên tắc : Coi chuỗi là 1 list
# 2 cách tạo list với chuỗi text: text = text.split() / text = list(text) (cách 2 tách từng kí tự)

a = """I 
will
go 
to
school
tomorrow
"""
a += "thank you"
print(a)
print(a[1])
print(f"x = {5 + 7}")
print(a.split("\n"))

# 1. split() : string.split(char, max)  biến 1 chuỗi thành 1 list chứa các chuỗi con
print("\n1)")
string_1 = "Toi di hoc lap trinh o fullhouse"

print(string_1.split()[0])
print(string_1.split('fullhouse'))
print(string_1.split('lap trinh'))
print(string_1.split('i', 2))  # max là số lượng chuỗi tách tối đa ( ở đây max = 2).

# 2. join(): string.join(list)
print("\n2)")
string_2 = '->'
x = ['toi', 'thong', 'minh']
print('_'.join(x))
print(' '.join(x))
print(string_2.join(x))

# 3. Capitalize() ( viết hoa chữ cái đầu của chuỗi )
print("\n3)")
string_3 = 'i go home.'
print(string_3.capitalize())

# 4. Center() : string.center(length, char)
print("\n4)")
string_4 = 'PhanTienManh'
print(string_4.center(40, '*'))
print(string_4.center(40))

# 5. replace(): string.replace(old,new,max)
print("\n5)")
string_5 = "I love money, I love school, I love health, I love running."
print(string_5.replace('I', 'You', 3))
print(string_5) # vẫn giữ nguyên

# 6. max(): Hàm này trả về chữ cái có độ sắp xếp cuối cùng theo bảng chữ cái alphabet nằm trong chuỗi.
# ( tương tự với min)
print("\n6)")
string_6 = "Phan Tien Manh"
print(max(string_6))

# 7. swapcase() : string.swapcase() biến chữ hoa thành chữ thường và ngược lại
print("\n7)")
string_7 = "phan Tiến MạnH"
print(string_7.swapcase())

# 8. rstrip(char): loại bỏ kí tự bên phải 1 chuỗi ( tương tự với lstrip(), strip()  )
print("\n8)")
string_8 = "Vu Thanh Tai----"
print(string_8.rstrip('-'))

# 9. zfill(length): thêm được các ký tự zero (số 0) vào trước chuỗi
print("\n9)")
string_9 = "Vu Thanh Tai"
print(string_9.zfill(3))
print(string_9.zfill(20))

# 10. splitlines(max: số lần cắt tối đa): tách chuỗi bởi ký tự \n
print("\n10)")
string_10 = """Vũ
Thành
Tài
"""
print(string_10.splitlines())
