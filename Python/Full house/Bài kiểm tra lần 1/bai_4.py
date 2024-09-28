def check_username():
    while True:
        count_error = 0
        username = input("Nhập tài khoản: ")
        for index, value in enumerate(username):
            if username[index].isspace():
                count_error += 1
            if username[0].isdigit():
                count_error += 1
            if value == '=':
                count_error += 1
        if "SELECT" in username \
                or "\t" in username \
                or "\n" in username:
            count_error += 1

        if count_error > 0:
            print("Nhập sai, chú ý quy tắc sau:")
            print("\t- Không chứa dấu cách") # dấu \t , \n e ko bít chèn vô :)
            print("\t- Ký tự đầu tiên không phải là 1 số")
            print("\t- Không chứa dấu “=”, không chứa chữ “SELECT” ")
            print("\t- Mời nhập lại.")
        else:
            return username


def check_password():
    while True:
        count_error = 0
        upper_detection = 0
        digit_detection = 0
        password = input("Nhập mật khẩu: ")
        if len(password) < 6:
            count_error += 1
        for index, value in enumerate(password):
            if password[index].isdigit():
                digit_detection += 1
            if password[index].isupper():
                upper_detection += 1
        if count_error > 0 or digit_detection == 0 or upper_detection == 0:
            print("Nhập sai, chú ý quy tắc sau:")
            print("\t- Mật khẩu có ít nhất 6 ký tự.")
            print("\t- Mật khẩu có ít nhất 1 chữ cái viết hoa.")
            print("\t- Mật khẩu có ít nhất 1 chữ số trong đó.")
            print("\t- Mời nhập lại.")
        else:
            return password


def execute():
    print("Welcome")
    check_username()
    check_password()
    exit("OK, have a good experience.")


execute()
