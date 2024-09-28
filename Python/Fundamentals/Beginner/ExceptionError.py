# 1,  IndexError – xuất hiện khi truy xuất phần tử của danh sách theo chỉ số
#
# >>> # IndexError - xuất hiện khi truy xuất phần tử của danh sách theo chỉ số
# >>> L1=[1,2,3]
# >>> L1[3] # không có chỉ số 3
# Traceback (most recent call last):
# File "<pyshell#18>", line 1, in <module>
# L1[3]
# IndexError: list index out of range


# 2, ModuleNotFoundError – xuất hiện khi import một module không tồn tại
#
# >>> # ModuleNotFoundError - xuất hiện khi import một module không tồn tại
# >>> import notamodule # không có module này
# Traceback (most recent call last):
# File "<pyshell#10>", line 1, in <module>
# import notamodule
# ModuleNotFoundError: No module named 'notamodule'


# 3,  ImportError – xuất hiện khi định danh trong lệnh import không chính xác
#
# >>> from math import cube # không có đối tượng nào tên là cube trong module math
# Traceback (most recent call last):
# File "<pyshell#16>", line 1, in <module>
# from math import cube
# ImportError: cannot import name 'cube'


# 4, TypeError – xuất hiện khi thực hiện phép toán trên những kiểu dữ liệu không phù hợp
#
# >>> '2'+2 # không thể cộng một xâu với một số
# Traceback (most recent call last):
# File "<pyshell#23>", line 1, in <module>
# '2'+2
# TypeError: must be str, not int


# 5,ValueError – xuất hiện khi biến đổi kiểu
#
# >>> int('xyz') # không thể chuyển đổi chuỗi 'xyz' thành kiểu số
# Traceback (most recent call last):
# File "<pyshell#14>", line 1, in <module>
# int('xyz')
# ValueError: invalid literal for int() with base 10: 'xyz'


# 6, NameError – xuất hiện khi sử dụng một định danh chưa được định nghĩa
#
# >>> age # định danh 'age' chưa được định nghĩa
# Traceback (most recent call last):
# File "<pyshell#6>", line 1, in <module>
# age
# NameError: name 'age' is not defined
