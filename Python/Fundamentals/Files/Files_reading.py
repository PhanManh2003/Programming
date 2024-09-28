# A. Read
# TODO 1. Reading from a file
print("- Bai 1")

# cách 1:
with open('pi_digits.txt') as f:  # gán file pi_digits.txt cho 1 đối tượng mà ta đặt tên là file_object
    contents = f.read()
print(contents)
# for i in file_object_1:  ( không lặp được ở bên ngoài với cách 1 vì cách 1 chỉ là gán tên cho file cần mở thôi.)
#     print(i.rstrip())

# cách 2: ()
f = open('pi_digits.txt')  # A = open(file_name or path)
for line in f:
    print(line.rstrip())
    
# TODO 2. Reading line by line
print("\n- Bai 2")
with open('pi_digits.txt') as f:
    for line in f:
        print(line.rstrip())

# TODO 3.Making a List of Lines from a file
print("\n- Bai 3")
with open('pi_digits.txt') as f:
    lines = f.readlines()
print(lines)

for line in lines:
    print(line)

for line in lines:
    print(line.rstrip())  # xóa kí tự newline cuối mỗi line