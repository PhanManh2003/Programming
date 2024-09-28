# Viết một hàm Python để chuyển một chuỗi đã cho thành
# tất cả các chữ hoa nếu nó chứa ít nhất 2 ký tự hoa trong 4 ký tự đầu tiên.
def upper_string():
    input_string = input("Nhập chuỗi: ")
    count_upper = 0
    for value in input_string[0:4]:
        if value.isupper():
            count_upper += 1
    if count_upper >= 2:
        result = input_string.upper()
    else:
        result = input_string
    print(f"Kết quả: {result}")


upper_string()
