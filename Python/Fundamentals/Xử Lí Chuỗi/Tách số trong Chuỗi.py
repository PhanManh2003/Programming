# Hàm số re.findall() : tìm và tách số trong chuỗi python dưới dạng một list
import re

s1 = '1ab23cdef456'
m1 = re.findall(r'\d ', s1)  # re.findall ( r'\d' , str)
print(m1)
# r'\d' là một chuỗi thô được sử dụng như mẫu RegEx trong hàm, có tác dụng biểu thị một chữ số.
r1 = ''.join(m1)
print(r1)

# Hàm số re.findall() : tìm và tách dãy số liền nhau trong chuỗi python dưới dạng một list
print("\nDạng 2: tìm và tách dãy số liền nhau trong chuỗi python dưới dạng một list")
s2 = 'Thứ 6 ngày 25 tháng 6 năm 2021, 21:30'
m2 = re.findall(r'\d+', s2)
print(m2)

# Hàm số re.sub() : tìm và tách số trong chuỗi python dưới dạng một chuỗi
print("\nDạng 3: tìm và tách số trong chuỗi python dưới dạng một chuỗi")
s3 = 'Thứ 6 ngày 25 tháng 6 năm 2021, 21:30'
m3 = re.sub(r'\D', '', s3)
print(m3)
# re.sub dùng để gọi hàm
# str là chuỗi cần tách số ra.
# r'\D' là một chuỗi thô được sử dụng như mẫu RegEx trong hàm, có tác dụng biểu thị một ký tự.
# Ký tự trắng '' dùng để thay thế các ký tự tồn tại trong chuỗi str


# Hàm số re.search(): tìm và tách số đầu tiên trong chuỗi python
print("\nDạng 4: tìm và tách số đầu tiên trong chuỗi python")
s4 = 'Thứ 6 ngày 25 tháng 6 năm 2021, 21:30'
m4 = re.search(r'\d', s4)
print(m4.group())
# kết quả của Hàm re.search() trong Python không phải là chuỗi kết quả mà là một match # object chứa chuỗi đó.
# Để lấy ra chuỗi kết quả ra từ trong match object, chúng ta sẽ cần sử dụng thêm phương thức group() trong Python.


# Hàm số re.search(): tìm và tách dãy số đầu tiên trong chuỗi python
print("\nDạng 5: tìm và tách dãy số đầu tiên trong chuỗi python")
s5 = 'Năm 2021, thứ 6 ngày 13 21:30'
m5 = re.search(r'\d+', s5)
print(m5)
# >> <re.Match object; span=(4, 8), match='2021'>
print(m5.group())  # >> 2021

# Lấy vị trí xuất hiện của dãy số
print(m5.start())  # >> 4

# Lấy vị trí kết thúc của dãy số
print(m5.end())  # >> 8
