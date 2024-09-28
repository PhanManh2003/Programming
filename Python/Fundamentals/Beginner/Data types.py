hi = str(input("Enter name: ") ) # Hàm nhập dữ liệu
print(f"Your name is {hi.title()}")
print("what you type is ", hi)  # print theo cách này thì rất xấu và mất time

name = "manh alex"
print(name.upper())  # viet hoa

first_name = "Albert Einstein once said,"
last_name = ' "A person who never made mistake never tried anything new" '

full_name = f"{first_name} {last_name}"  # combine 2 string , use {}

message = f"Hello, {full_name.title()}"  # cu phap viet hoa chu cai dau cua tu
print(message)

print("Today \t Is \t A \nGood \n\t Day")

rooney = "      english striker    "
print(rooney)
rooney = rooney.strip()  # cu phap lui dau dong
print(rooney)

print(5 + 3)
print(5 + 3)

MY_NUMBER = 220303  # khai bao hang so
print("my favorite number is", MY_NUMBER)

z = 3 + 4j
print(z + 3)
