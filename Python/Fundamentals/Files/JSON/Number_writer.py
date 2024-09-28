import json

numbers = [1, 2, 3, 4, 5, 9, 8, 55, 4, 33, 213, 123, 4000, 23000]
filename = 'numbers.json'
# Tạo 1 tệp để lưu danh sách các số ( thường để đuôi là .json để biết dữ liệu trong tệp ở định dạng JSON)
with open(filename, 'w') as file_object:
    json.dump(numbers, file_object)  # cho phép lưu trữ list numbers vào tệp .json

with open(filename, 'r') as file_object:
    result = json.load(file_object)
    print(result[-1])