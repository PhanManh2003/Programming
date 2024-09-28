# Viết chương trình Python để kiểm tra xem tất cả các kí tự của chuỗi có thuộc bảng chữ cái không.

# Cách viết dùng tham số hàm
def check_alphabet(input_string: str):
    if input_string.isalpha():
        return True
    return False


def notification(input_string: str):
    if check_alphabet(input_string):
        print("Có chứa tất cả chữ cái")
    else:
        print("Không chứa tất cả chữ cái. ")


def execute():
    user_input = input("Nhập chuỗi: ")
    notification(user_input)


execute()
# #TODO:Không viết ntn:
# def check_alphabet(input_string: str):
#     if input_string.isalpha():
#         return True
#     return False
#
#
# def notification():
#     if check_alphabet():
# TODO: !!! Hàm viết trong hàm mà HÀM CON chứa tham số lúc khai báo
# TODO: thì bắt buộc HÀM CHA cũng phải chứa tham số để làm đối số cho HÀM CON.
# TODO: còn nếu HÀM CHA chứa tham số mà HÀM CON không chứa thì không có tính liên kết và khả dụng.
#
#         print("Có chứa tất cả chữ cái")
#     else:
#         print("Không chứa tất cả chữ cái. ")
#
#
# def execute():
#     user_input = input("Nhập chuỗi: ")
#     check_alphabet(user_input)
#     notification()
# TODO: Chỉ cần chạy hàm cha thì sẽ chạy luôn cả hàm con ( không cần chạy 2 hàm như thế này )
#
# execute()

# TODO:Cách viết không dùng tham số hàm
# def check_alphabet():
#     user_input = input("Nhập chuỗi: ")
#     if user_input.isalpha():
#         return True
#     return False
#
#
# def notification():
#     if check_alphabet():
#         print("Có chứa tất cả chữ cái")
#     else:
#         print("Không chứa tất cả chữ cái. ")
#
# notification()
# TODO:Lấy tham số hàm này làm đối số cho tham số hàm kia chính là cách
# TODO: "liên kết các hàm trong 1 chương trình thành 1 khối"! ( có thể 2 hàm đều không chứa tham số)
