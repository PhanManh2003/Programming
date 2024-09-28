# Viết một hàm Python lấy một danh sách các từ và trả về từ dài nhất và độ dài của từ dài nhất.

def find_string(input_string: str):
    # TODO: Lấy danh sách các từ vừa nhập
    list_string = input_string.split(',')
    for index, value in enumerate(list_string):
        list_string[index] = list_string[index].replace(' ', '')
    print(f"-Danh sách các từ bạn nhập là: \n{list_string}")

    # TODO: Tìm từ dài nhất và độ dài của nó
    max_length = len(list_string[0])
    longest_word = list_string[0]

    for index, value in enumerate(list_string):
        if len(list_string[index]) > max_length:
            longest_word = list_string[index]
            max_length = len(list_string[index])

    print(f"-Từ dài nhất là: {longest_word}")
    print(f"-Độ dài của từ là: {max_length}")


user_input = input("Mời nhập danh sách các từ cách nhau bởi dấu phẩy: ")
find_string(user_input)
