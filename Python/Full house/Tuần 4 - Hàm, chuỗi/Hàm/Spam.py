def check_input_str(message: str):
    while True:
        result = input(message).strip()
        if len(result) == 0:
            print("Cannot be empty.")
            print("Try again.")
        else:
            return result


def check_username_valid(message: str):
    while True:
        count = 0
        username = check_input_str(message)
        for index, value in enumerate(username):
            if username[index].isspace():
                count += 1
            if username[0].isnumeric():
                count += 1
            if value == '=':
                count += 1
            if username.__contains__("SELECT"):
                count += 1
        if count > 0:
            print("Wrong username format.")
            print("Username cannot contains space characters.")
            print("Username cannot starts with a number.")
            print("Username cannot contains '=', cannot contains 'SELECT'")
        else:
            return username


def check_password_valid(message: str):
    while True:
        count = 0
        check_alpha = 0
        check_numeric = 0
        password = check_input_str(message)
        if len(password) < 6:
            count += 1
        for index, value in enumerate(password):
            if password[index].isnumeric():
                check_numeric += 1
            if password[index].isupper():
                check_alpha += 1
        if count > 0 and check_alpha == 0 and check_numeric == 0:
            print("Password must have at least 6 letters.")
            print("Password must have at least 1 uppercase.")
            print("Password must have at least 1 number.")
        elif count == 0 and check_alpha >= 1 and check_numeric >= 1:
            return password
        else:
            print("Password must have at least 6 letters.")
            print("Password must have at least 1 uppercase.")
            print("Password must have at least 1 number.")


def menu():
    print("============= REGISTER =============")
    username = check_username_valid("Enter username: ")
    password = check_password_valid("Enter password: ")
    print("Create account successfully.")


menu()
