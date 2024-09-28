lines = ["HIHI", "haha", "yolo", "vo thuong"]
for line in lines:
    print(line, end=' ') #in dòng mới mà không phải xuống dòng

number = 0
while number < 10:
    number += 1
    if number % 2 == 0:
        continue  # skip and start from the beginning
    print(number)  # ko dc viết cùng indent với continue