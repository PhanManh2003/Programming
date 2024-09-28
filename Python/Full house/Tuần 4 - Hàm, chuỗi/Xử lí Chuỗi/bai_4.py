# Viết chương trình Python để lấy một chuỗi từ một chuỗi đã cho
# trong đó tất cả các lần xuất hiện của ký tự đầu tiên của nó đã được đổi thành '$', ngoại trừ chính ký tự đầu tiên.
# Chuỗi mẫu của trình chỉnh sửa: 'restart' => chuoi input = “r”
# Kết quả mong đợi: 'resta$t'

main_string = input("Nhập chuỗi mẫu: ")
input_string = input("Nhập chuỗi input: ")
check_string = main_string[1:]

for value in check_string:
    if value == input_string:
        check_string = check_string.replace(value, '$')
        break

result = main_string[0] + check_string
print(result)