import json

filename = 'numbers.json'
with open(filename) as file_object:  # chế độ chỉ đọc
    result = json.load(file_object)  # json.load tải thông tin được lưu trữ trong file 'numbers.json'
print(result)
