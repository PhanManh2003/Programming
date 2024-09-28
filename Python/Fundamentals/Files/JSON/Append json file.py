import json


# TODO: Thêm dữ liệu mới nhập từ phím vào file .json

# load là load object, loads là load string
# tạo một hàm ghi dữ liệu với tham số 'data'
# nhiệm vụ của tham số 'data': sau này khi load dữ liệu từ file và sửa, dữ liệu mới sẽ làm đối số cho 'data' để dump


def write_json(data, filename='family.json'):
    with open(filename, 'w') as f:
        json.dump(data, f, indent=4)


# Fix lỗi chưa tạo file thì dùng Try-Except-Else
try:
    with open('family.json') as json_file:
        load_data = json.load(json_file)
        name = input("What's the member's name: ")
        age = int(input("What's the age: "))
        y = {'name': name, 'age': age}
        load_data.append(y)

except FileNotFoundError:
    with open('family.json', 'w') as f:
        a = []
        json.dump(a, f, indent=4)
        f.close()
    with open('family.json') as json_file:  # Tạo rồi thì load luôn và cập nhật
        load_data = json.load(json_file)
        name = input("What's the member's name: ")
        age = int(input("What's the age: "))
        y = {'name': name, 'age': age}
        load_data.append(y)
        json_file.close()
    write_json(load_data)
else:
    write_json(load_data)
