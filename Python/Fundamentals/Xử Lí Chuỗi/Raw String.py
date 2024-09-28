# Ở trong python, nếu chúng ta thêm ký tự r hoặc R vào trước một chuỗi chứa chuỗi thoát,
# thì những chuỗi thoát trong đó sẽ không bị coi là ký hiệu đặc biệt mà sẽ được coi như là một ký tự bình thường trong chuỗi.
# Chúng ta gọi những chuỗi như vậy là chuỗi thô trong python


s = "a\tb\nA\tB"
print(s)
rs = r"a\tb\nA\tB"
print(rs)

print(len(s))  # >> 7
print(len(rs))  # >> 10
s_list = list(s)
rs_list = list(rs)

print(s_list)  # >> ['a', '\t', 'b', '\n', 'A', '\t', 'B']
print(rs_list)  # >> ['a', '\\', 't', 'b', '\\', 'n', 'A', '\\', 't', 'B']
# Lưu ý, dấu gạch chéo ngược \ (tiếng anh : Backslash) ở chuỗi thô trong python
# sau khi được dùng để tạo list sẽ được biểu diễn bởi hai dấu gạch chéo ngược \\ như ví dụ trên.


# Ứng dụng của chuỗi thô raw string trong python
# TODO 1. Dùng chuỗi thô để viết đường dẫn Windows trong Python

# Cách 1 : dùng hai dấu gạch chéo ngược để biểu thị `\`
path = 'C:\\Windows\\system32\\cmd.exe'

# Cách 2 : dùng chuỗi thô
rpath = r'C:\Windows\system32\cmd.exe'

#  Hãy kiểm tra liệu hai chuỗi này có giống nhau không?
print(path == rpath)  # >> True


# TODO 2. Cách kết thúc đường dẫn
rpath2 = r'C:\Windows\system32'  # kết thúc bởi 0 dấu `\\` (dùng cái này là dc)
path2 = 'C:\\Windows\\system32\\'  # kết thúc bởi 2 dấu `\\`


# Lưu ý: # Phải kết thúc chuỗi thô trong Python bằng một số chẵn dấu gạch chéo ngược \
print(r"Kiyoshi 30 tuổi và rất đẹp trai \\")
# hoặc:
print(r"Kiyoshi 30 tuổi và rất đẹp trai" + "\\") # chú ý dấu '+'
