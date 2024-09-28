data = [
    {
        'username': 'manhalex',
        'password': '123456',
        'mark': 9,
    },
    {
        'username': 'manhpthe',
        'password': 'khongmotdoithu96',
        'mark': 8,
    },
    {
        'username': 'manhfo4',
        'password': 'cuchuoilun123',
        'mark': 4,
    },
    {
        'username': 'admin',
        'password': '1234567',
    },
]
“=”

def validate_username(username: str):
    return ' ' in username


def validate_password(password: str):
    if len(password) < 6 or ' ' in password:
        return False
    return True


def menu_login():
    print("1. Đăng nhập")
    print("2. Thoát")
    while True:
        select = int(input("Mời bạn chọn: "))
        if select < 1 or select > 2:
            print("Bạn chọn sai rồi! Mời chọn lại")
        else:
            break
    return select


def login_verification(username, password):
    for item in data:
        if item['username'] == username and item['password'] == password:
            return item
    return None


def menu_admin():
    print("1. Thêm 1 sinh viên")
    print("2. In sinh viên")
    print("3. Xóa sinh viên")
    while True:
        select = int(input("Mời bạn chọn: "))
        if select < 1 or select > 3:
            print("Bạn chọn sai rồi! Mời chọn lại")
        else:
            break
    return select


def menu_student():
    print("1. Xem điểm sinh viên đó")
    print("2. Thay đổi mật khẩu của mình")
    while True:
        select = int(input("Mời bạn chọn: "))
        if select < 1 or select > 2:
            print("Bạn chọn sai rồi! Mời chọn lại")
        else:
            break
    return select


def main():  # hàm chạy chương trình nè
    select = menu_login() #  gán 1 biến vào hàm để sử dụng kết quả trả về của hàm
    if select == 1:
        user = None
        for i in range(3):
            username = input("Nhập username: ")
            password = input("Nhập password: ")
            user = login_verification(username, password) #  gán 1 biến vào hàm để sử dụng kết quả trả về của hàm
            if user:
                break
            else:
                print("Đăng nhập thất bại, mời đăng nhập lại.")
        if not user:
            return  # thoát hàm

        if user['username'] == 'admin':
            select_admin = menu_admin()
            print(select_admin)
            # TODO: Xử lí liên quan đến admin
        else:
            select_student = menu_student()
            print(select_student)
            # TODO: Xử lí liên quan đến student

    if select == 2:
        return


main()
