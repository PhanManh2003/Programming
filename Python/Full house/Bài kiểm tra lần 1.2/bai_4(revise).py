import json


def save_file(data, filename='users.json'):
    # nhiệm vụ của tham số 'data': sau này khi load dữ liệu từ file và sửa, dữ liệu mới sẽ làm đối số cho 'data'
    with open(filename, 'w') as f:
        json.dump(data, f, indent=4)
        f.close()


def check_username(username: str):
    denied_chars = ["SELECT", " ", "\t", "\n", "="]
    if username[0].isdecimal():
        return False

    for char in denied_chars:
        if char in username:
            return False

    return True


def check_upper_and_number(password: str, is_upnum=False):
    flag = False  # dùng flag vì chỉ cần 1 kí tự thỏa mãn là thoát
    for char in password:
        result = char.isnumeric() if is_upnum else char.isupper()
        # !!! check cả upper và number cùng 1 lúc theo 2 mặt giá trị của is_number ( check 2 thứ 1 lúc )
        if result:
            flag = True  # đã thỏa mãn
            break
    return flag


def check_password(password: str):
    if len(password) < 6 \
            or not check_upper_and_number(password, is_upnum=False) \
            or not check_upper_and_number(password, is_upnum=True):
        return False

    return True


def find_user(username: str):
    # TODO : Tìm user theo username
    with open('users.json') as json_file:
        load_data = json.load(json_file)
        for index, value in enumerate(load_data):
            if load_data[index]['username'] == username:
                return True
    return False


def register(username: str, password: str):
    # !!! lấy tham số của hàm register này làm đối số cho tham số hàm check_username
    # Liên kết các hàm bằng cách lấy tham số hàm này làm đối số cho tham số hàm kia
    if not check_username(username=username) or not check_password(password=password):
        # if not + function_name ( có nghĩa: nếu giá trị hàm return là False)
        print("Định dạng tài khoản hoặc mật khẩu không đúng.")
    else:  # TODO: Check tồn tại tài khoản hay không, không thì ghi vào
        try:
            if not find_user(username):
                with open('users.json') as json_file:
                    load_data = json.load(json_file)  # load object
                    new_user = {
                        'username': username,
                        'password': password
                    }
                    load_data.append(new_user)
                    json_file.close()
                save_file(load_data)
                print("Đăng ký thành công.")
            else:
                print("Username đã tồn tại, nhập lại.")
        except FileNotFoundError:  # Fix lỗi chưa tạo file
            with open('users.json', 'w') as f:
                a = []
                json.dump(a, f, indent=4)
                f.close()
            with open('users.json') as json_file:
                load_data = json.load(json_file)  # load object
                new_user = {
                    'username': username,
                    'password': password
                }
                load_data.append(new_user)
                json_file.close()
            save_file(load_data)
            print("Đăng ký thành công.")


def login(username: str, password: str, count: int):
    if not check_username(username) or not check_password(password):
        print("Định dạng tài khoản hoặc mật khẩu không đúng.")
    # TODO: Làm gì khi thấy hoặc không thấy username
    else:
        check_exist_user = find_user(username)
        if not check_exist_user:
            print("Đăng nhập thất bại, không có username tồn tại.")
            count += 1
            return count
        else:
            with open('users.json') as json_file:
                users = json.load(json_file)
                for user in users:
                    if user['username'] == username and user['password'] == password:
                        print("Đăng nhập thành công.")
                    else:
                        print("Đăng nhập thất bại, sai mật khẩu.")
                        count += 1
                        return count


def menu():
    print("1. Đăng Ký")
    print("2. Đăng Nhập")
    print("3. Thoát")
    return int(input("Bạn chọn: "))


def main():
    count = 0
    while True:
        select = menu()
        if select == 3:
            break
        if select < 1 or select > 3:
            print("Sai, chọn từ 1 đến 3!")
        if select == 1:
            username = input("Nhập tài khoản: ")
            password = input("Nhập mật khẩu: ")
            register(username=username, password=password)
        if select == 2:
            while count < 3:  # Thoát ở hàm main() nếu đăng nhập thất bại quá 3 lần!
                username = input("Nhập tài khoản: ")
                password = input("Nhập mật khẩu: ")
                count = login(username=username, password=password, count=count)
                # gán biến = function thì Vừa chạy dc hàm, Vừa gán dc biến bằng giá trị trả về
        if count == 3:
            print("Trí nhớ kém quá, bay acc rồi nhé :)")
            break


if __name__ == '__main__':
    main()

# ý tưởng cho vđ: thoát nếu đăng nhập quá 3 lần:
# Đầu tiên: Nghĩ đến 1 biến count, rồi đặt nó ở hàm main kết hợp với vòng while để thoát ngay tại hàm main
# Tiếp: Hàm login sau mỗi lần đăng nhập thất bại thì phải trả về biến count += 1
# Tiếp: Vì biến count đc khai báo ở hàm main() nên hàm login() cần có 1 tham số count để truyền
