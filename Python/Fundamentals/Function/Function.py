# TODO: TỔNG QUÁT => Mỗi hàm là 1 đơn vị độc lập nên những thứ trong nó phải phụ thuộc vào tham số của nó !!
# 1. Define a function
def greet_haha():
    """Display a simple greeting"""
    print("Hello")
    def say():
        print("shit")

  # A function call
hoho = greet_haha().say()  # cách gọi khác


# 2. Passing information to a function
def greet_user(username):  # username is called "parameter"
    """Display a simple greeting"""
    print(f"Hello, {username.title()}")


greet_user('ronaldo')  # Để truyền đối số 'ronaldo' cho tham số 'username' của hàm greet_user


# ronaldo is called "argument":


# 3. Passing arguments to functions
# 3.1 Positional Arguments
def pet(animal_type, pet_name):
    """Display info about a pet"""
    print(f"\nI have a {animal_type}")
    print(f"My {animal_type}'s name is {pet_name.title()}")


pet('mouse', 'bugger')
pet('cat', 'béo')  # Multiple function call
pet('dog', 'cún')


# 3.2 Keyword Arguments
def pet(animal_type, pet_name):
    """Display info about a pet"""
    print(f"\nI have a {animal_type}")
    print(f"My {animal_type}'s name is {pet_name.title()}")


pet(animal_type='mouse', pet_name='bugger')


# 3.3 Default Values
def pet(pet_name, animal_type='dog'):  # default parameter xếp đằng sau, ko dc xếp trước non-default parameter
    """Display info about a pet"""
    print(f"\nI have a {animal_type}")
    print(f"My {animal_type}'s name is {pet_name.title()}")


# !1. gọi hàm chứa giá trị cụ thể
pet(pet_name='milu')
pet(pet_name='kingston', animal_type='lion')  # python ignore the default value 'dog' of animal_type
pet('kingston', 'lion')  # python ignore the default value 'dog' of animal_type


# 4. Return Value ( Giá trị trả về)
# 4.1 Return a simple value
def get_formatted_name(first_name, last_name):
    """Return a fullname"""
    full_name = f"{first_name} {last_name}"
    return full_name.title()  # kết thúc hàm và trả giá trị full_name về nơi mà hàm được gọi ở line 56
    # (full_name thay cho first_name và last_name)


fb_player_1 = get_formatted_name('cristiano', 'ronaldo')  # working with seperate object with a specific name
fb_player_2 = get_formatted_name('lionel', 'messi')
print(fb_player_1)
print(fb_player_2)


# 4.2 Make an optional argument ( allow functions to handle a wide range of use cases)
# bài này nếu tuỳ theo việc người dùng có cung cấp tên đệm hay không mà sẽ in ra tên theo đó.
# 4.3 Return a Dictionary
def build_person(first_name, last_name, age=None):
    """return a dict about a person's info """
    person = {'first': first_name, 'last': last_name}
    if age:
        person['age'] = age
    return person


player = build_person('fernando', 'torres', 27)  # đặt biến khi gọi hàm vì trong hàm không có lệnh print
print(player)


# 5. Function with While loop
def get_formatted_name(first_name, last_name):
    """Return a fullname"""
    full_name = f"{first_name} {last_name}"
    return full_name


while True:
    print("\nPlease  tell me your name!")
    f_name = input("First name: ")
    l_name = input("Last name: ")
    break
official = get_formatted_name(f_name, l_name)  # !2. gọi hàm chứa biến
print(f"Hello, {official.title()}")


# 6. Passing a list to a function
def greeting(names):
    """Print a message to everybody"""
    for name in names:
        print(f"Hello, {name}")


users = ['aron', 'bill', 'chilwell']  # khởi tạo list không được để ở trong khu vực của hàm
greeting(users)  # gọi hàm thì hàm sẽ gán list users cho parameter 'names', do đó names sẽ thành 1 list
# ĐẶT TÊN LIST TRÙNG VỚI PARAMETER CỦA HÀM CŨNG ĐƯỢC
greeting('hihih')


# 6 Moving a list to another list
def print_users(unconfirmed_users, confirmed_users):  # hàm 1 phụ trách chuyển phần tử
    """Move items from list to list"""
    while unconfirmed_users:
        current_user = unconfirmed_users.pop()
        confirmed_users.append(current_user)
        print(f"Verifying user: {current_user}")


def show_users(confirmed_users):  # 2 hàm 2 phụ trách PRINT phần tử trong list được chuyển
    print("\nThe following users have been accepted: ")
    for confirmed_user in confirmed_users:
        print(confirmed_user)


unconfirmed_users = ['xavi', 'bale', 'courtois', 'maldini']
confirmed_users = []

print_users(unconfirmed_users[:], confirmed_users)
show_users(confirmed_users)


# Ý NGHĨA: VIỆC DÙNG HÀM PHỤ TRÁCH TỪNG CÔNG VIỆC NTN GIÚP VIỆC SỬA , BẢO TRÌ THÔNG TIN DỄ DÀNG ,
# KO PHẢI NGỒI LỤC LẠI CODE MÀ CHỈ CẦN SỬA TỪ BÊN NGOÀI RỒI GỌI HÀM

# 7.1 Passing an arbitrary number of arguments
def make_pizza(*toppings):  # * tell python to make an empty tuple called toppings
    """Print the list of toppings that have been requested."""
    print(toppings)
    # arguments ---- (packed together)----> 1 tuple


make_pizza('pepperoni')
make_pizza('mushroom', 'onion', 'pepper')


# 7.2 Mix positional & arbitrary arguments
def make_pizza(size, *toppings):  # positional arguments ( đối số vị trí ) bao giờ cũng đặt trước
    """Print the list of toppings that have been requested."""
    print(f"\nMaking a {size}-inch pizza required the following toppings:")
    for topping in toppings:
        print(f"- {topping}")


make_pizza(20, 'pepperoni')
make_pizza(11, 'mushroom', 'onion', 'pepper')


# 7.3 create arbitrary arguments with dictionary:
def build_profile(first_name, last_name,
                  **user_info):  # ** tell python to create an empty dictionary called user_info and pack whatever name-value pairs it receives into this dictionary
    """Build a dict containing everything we know about a user"""
    user_info['first_name'] = first_name
    user_info['last_name'] = last_name
    return user_info


user_profile = build_profile('cristiano', 'ronaldo', location='London', age=38,
                             height='185cm')  # 3 more key-value pairs added
print(user_profile)
# bạn có thể thêm bất kì cặp name-value nào vào cho dictionary sau này 1 cách dễ dàng


# 8. Store function in a module
# 8.1 Import an entire module
import module  # Another way: Import all functions in a Module ->syntax: from module_name import *

module.make_pizza(8, 'shit')  #### tên module.tên hàm
module.make_pizza(11, 'kfc', 'egg', 'soup')

# 8.2 import specific functions
# general syntax : from module_name import function_name_0, function_name_1 , function_name_2,....

from module import make_pizza

make_pizza(99, 'bò', 'nem', 'ruốc')  # không cần dùng dấu chấm khi gọi hàm vì đã import cụ thể r
make_pizza(33, 'gà')

# 8.3 import all functions in a module
from module import *

make_pizza(111, 'chim', 'ốc', 'hến')  # không cần dùng dấu chấm khi gọi hàm vì đã import cụ thể r
make_pizza(112, 'trâu')

# 9. Alias ( Bí danh, tránh trùng tên với tên chương trình )
# 9.1 Give function an Alias
from module import make_pizza as mp

mp(44, 'bò', 'nem', 'ruốc')  # không cần dùng dấu chấm khi gọi hàm vì đã import cụ thể r
mp(22, 'gà')
# 9.2 Give module an Alias
import module as m

m.make_pizza(55, 'bò', 'nem', 'ruốc')
m.make_pizza(22, 'shit')

# Watch out!: module_name and function_name : lowercase & underscores ; import statements at the beginning of a file
