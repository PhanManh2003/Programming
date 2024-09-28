# Viết chương trình Python để tìm ký tự lặp lại đầu tiên trong một chuỗi đã cho.
# VD: abcxc -> ký tự lặp lại đầu tiên là ký tự c

text = input("Nhập chuỗi: ")
# TODO 1: Tạo một list chứa các kí tự được lặp lại
repeated_characters = []
for value in set(text):
    if text.count(value) > 1:
        repeated_characters.append(value)

print(f"Danh sách các kí tự được lặp lại trong chuỗi là:\n{repeated_characters}")

# TODO 2: Tìm kí tự được lặp lại đầu tiên
for value in text:
    if value in repeated_characters:
        print(f"Kí tự lặp lại đầu tiên là: {value}")
        break
