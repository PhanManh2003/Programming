# Viết chương trình Python để đếm và hiển thị các số nguyên của một văn bản nhất định.

text = "Hôm nay là ngày 22 tháng 12 năm 2012. Tôi đi leo núi với 2 người bạn thì ăn hết 2.5 kg táo và"
text += "uống hết 1.5 lít nước và trời lạnh -16.8 độ C. Hơn nữa, tài khoản tôi còn có -123000 VNĐ ."
text += "Nhiệt độ trong phòng (độ C) là -12."

text = text.split()
print(text)
# TODO 1: Tách các phần tử chứa số nguyên và số thập phân thành 1 list numbers
numbers = []
for i in range(len(text)):
    if text[i].isdigit():  # tách số nguyên dương
        numbers.append(text[i])
    elif text[i].replace('.', '').isdigit():  # tách số thập phân dương ( 2012. là ngoại lệ cần làm mịn)
        numbers.append(text[i])
    elif text[i][0] == '-' and text[i][1:].replace('.', '').isdigit(): # tách số nguyên âm và thập phân âm (có ngoại lệ)
        numbers.append(text[i])
print(numbers)

for i in range(len(numbers)):  # Làm mịn list numbers với dấu chấm ở cuối
    if numbers[i][-1] == '.':
        numbers[i] = numbers[i].replace('.', '')
print(numbers)

# TODO 2: Tách các số nguyên thành 1 list integers
integers = []
for value in numbers:
    if '.' not in value:
        integers.append(value)
print(f"Các số nguyên trong văn bản là: \n{integers}")