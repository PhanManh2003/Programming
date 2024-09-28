# Các hàm trả về True False

# 1. isalnum(): kiểm tra xem một chuỗi có phải là chứa duy nhất các ký tự chữ hoặc số hay không
# 2. isnumeric(): Hàm này có tác dụng kiểm tra xem một chuỗi có phải là chứa duy nhất các chữ số hay không
# 3. isalpha(): Hàm này có tác dụng kiểm tra xem một chuỗi có phải là chứa duy nhất các ký tự chữ hay không
# 4. isspace(): Hàm này có tác dụng kiểm tra xem một chuỗi có phải chỉ chứa duy nhất các ký tự khoảng trắng không
# 5. isdecimal(), isdigit() (như 2)
# 6. islower(), isupper(), istitle() ( dễ rồi)

# 7. string.count(char, start, end) :Mặc định thì end = len() của chuỗi
# TODO: Count có thể dùng cho 1 list, ở đây string là 1 list
string = "toidicode.com"
print(string.count('i', 2, 4))

# 8. encode & decode
string = "toidicode.com"
print(string.encode())  # Kết quả: b'toidicode.com'

string = b'toidicode.com'
print(string.decode())  # Kết quả: toidicode.com

# 9.  startswith()(str, start, end) & endswith()(str, start, end)
print("\n11)")
string = 'toidicode.com'
print(string.startswith('m', 3, len(string)))  # Kết quả: False
print(string.endswith('m', 3, 10))  # Kết quả: False

# 10. find(str, start, end): trả về vị trí bắt đầu của chuỗi cần tìm và nếu không tìm thấy trả về -1
string = 'toidicode.com'
print(string.find('dih', 1, 5))  # Kết quả: 3
print(string.index('di'))  # dùng hàm index cũng được

# 11. ljust(length, char) & rjust(length, char): Hàm này có tác dụng trả về một chuỗi với độ dài length xác định
string = "Vu Thanh Tai"
print(string.ljust(17, '-'))  # Kết quả: Vu Thanh Tai-----
print(string.rjust(18, '-'))
print(string.rjust(6, '-'))

# 12. maketrans() & translate()
inputs = "abcdefghijklmnopqrstuvwxyz!@#"
outputs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123"
string = "vu thanh tai !!@@##"

print(string.translate(string.maketrans(inputs, outputs)))

# cú pháp chung : string.function_name()
