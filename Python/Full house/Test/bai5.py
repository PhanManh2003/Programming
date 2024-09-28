import json

f = open('users.json', 'r')
users = json.load(f)


def save_file():
    g = open('users.json', 'w')
    # TODO viết nốt hàm save file


def check_username(username: str):
    denied_chars = ["SELECT", " ", "\t", "\n", "="]
    if username[0].isdecimal():
        return False

    for char in denied_chars:
        if char in username:
            return False

    return True


def check_upper_and_number(password: str, is_number=False):
    flag = False
    for char in password:
        result = char.isnumeric() if is_number else char.isupper()
        if result:
            flag = True
            break
    return flag


def check_password(password: str):
    if len(password) < 6 \
            or not check_upper_and_number(password, is_number=False) \
            or not check_upper_and_number(password, is_number=True):
        return False

    return True


def register(username: str, password: str):
    if not check_username(username) or not check_password(password):
        print("Định dạng tài khoản hoặc mật khẩu không đúng")
    # TODO: Nếu đăng ký thành công thì ghi vào file users.json
    print("Đăng ký thah công")


def login(username: str, password: str):
    if not check_username(username) or not check_password(password):
        print("Định dạng tài khoản hoặc mật khẩu không đúng")
    # TODO: đọc file users.json và kiểm tra xem có username và password không
    # Nếu có username thì check password xem có đúng không
    # Nếu hợp lệ thì báo đăng nhập thành công
    # Nếu mật khẩu sai thì báo mật khẩu không đúng
    # Nếu tài khoản không tồn tại thì báo tài khoản không tồn tại


def menu():
    print("1. Đăng Nhập")
    print("2. Đăng Ký")
    print("3. Thoát")
    return int(input("Bạn chọn: "))


def main():
    while True:
        select = menu()
        if select == 3:
            break
        # TODO: Check nếu người dùng nhập vào số không phải từ 1-3
        if select == 1:
            username = input("Nhập tài khoản")
            password = input("Nhập mật khẩu")
            register(username=username, password=password)
        if select == 2:
            username = input("Nhập tài khoản")
            password = input("Nhập mật khẩu")
            login(username=username, password=password)


main()
