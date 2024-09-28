# Viết chương trình Python để viết hoa các chữ cái đầu tiên và cuối cùng
# của mỗi từ của một chuỗi cho trước.

# TODO 1: Split chuỗi thành list các từ
text = input("Nhập chuỗi: ")
text = text.split(' ')
print(text)

# TODO 2: Split các từ thành list các chữ cái để viết hoa
for i in range(len(text)):
    text[i] = list(text[i])
    text[i][0] = text[i][0].upper()
    text[i][-1] = text[i][-1].upper()
    text[i] = ''.join(text[i])

print(text)
print(f"\nKết quả: {' '.join(text)}")
