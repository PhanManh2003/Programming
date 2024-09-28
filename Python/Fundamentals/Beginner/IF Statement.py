# 1 Checking an element in a list and print it out in Uppercase
cars = ['audi', 'bmv', 'toyota', 'mercedes']
for car in cars:
    if car == 'bmv':
        print(car.upper())
    else:
        print(car.lower())

# 2 Checking a value in a list

banned_user = ['manh', 'dung', 'minh', 'thang']

user = input("Điền tên của bạn:")
if user not in banned_user:  # dùng not in hoạặc in
    print(f"{user.title()} , you can post now!")

# 3 Boolean expression
game_active = True
editor = False

# 4 if-else statements
age = 17
if age >= 18:
    print("- you are old enough to vote\n")
else:
    print("- you are too young to vote\n")

# 5 if-elif-else chain ( need to test more than 2 situations)
height = 190
if height < 160:
    print("- you are short\n")
elif 160 < height < 180:
    print("- medium\n")
else:
    print("- you are tall\n")

old = 27  # another way for if-elif-else ( bao nhiêu câu elif cũng đc,thay else bằng elif ở cuối cũng được)
if old < 18:
    price = 12
elif old < 25:
    price = 15
elif old < 30:
    price = 30
elif old >= 30:
    price = 50
print(f"- Your cost is ${price}!\n")

# 6 Testing multiple conditions ( use if- if -if)
requested_menu = ['chicken', 'beef', 'cake']
if 'chicken' in requested_menu:
    print("Add lemon")
if 'noodle' in requested_menu:
    print("add chilly sauces")
if 'beef' in requested_menu:
    print('Add pepper')
print("Finish your order!\n")

# 7 Checking for special item in a list
requested_menu = ['chicken', 'beef', 'cake']
for requested in requested_menu:
    if requested == 'chicken':
        print("Sorry, we dont have chicken now!")
    else:
        print(f"Add {requested}")
print("Have a good meal.\n")

# 8 Checking whether a list is empty or not

orders = []
if orders:  # nếu list orders[] có phần tử .
    for order in orders:
        print(f"Customer need {order}")
    print("Please wait in 5 minutes!\n")
else:
    print("Are you sure you want to order something?\n")
