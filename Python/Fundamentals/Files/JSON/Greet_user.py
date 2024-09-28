# Tái cấu trúc ( refactoring) in storing data
# Tránh lỗi chưa tạo file thì dùng Try-except-else
import json


def get_stored_username():
    """Check whether the file contains usernames exists or not. Then return a value for the function"""
    filename = 'username.json'
    try:
        with open(filename) as file_object:
            result = json.load(file_object)
    except FileNotFoundError:
        return None
    else:
        return result


def greet_user():
    """Greet user with their name."""
    username = get_stored_username()  # ! Quan trọng : Sử dụng giá trị trả về của hàm trước để xét if-else :)
    if username:
        while True:
            opinion = input("Is this your name? ( Yes/No): ")
            if opinion != 'Yes' and opinion != 'No':
                print("Nhập lại đi")  # thực hiện hết chỗ này thì nó while lại chạy từ đầu.
            else:
                if opinion == 'Yes':
                    print(f"Welcome back, {username}")
                elif opinion == 'No':
                    input_new_username()
                break

    else:
        input_new_username()


def input_new_username():
    """Input a new username."""
    username = input("What is your name? : ")
    filename = 'username.json'
    with open(filename, 'w') as file_object:
        json.dump(obj=username, fp=file_object)
        file_object.close()
    print(f"Glad to see you again, {username}")


greet_user()
