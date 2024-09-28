# hãy coi 1 chuỗi là 1 list
# split biến Chuỗi thành List các chuỗi con theo ý muốn
# cứ thấy list là nghĩ đến for-loop
text = "số điện thoại của tôi là 098897442. Hoặc liên hệ với tôi theo số hotline là +84865520222. Xin cảm ơn"
list_string = text.split()

phone_numbers = []
for value in list_string:
    if not value.isalpha():
        phone_numbers.append(value)
print(phone_numbers)

print("\nCác số điện thoại xuất hiện bên trong text là:")
for phone_number in phone_numbers:
    # spit lần 2 để tách dấu chấm ra khỏi chuỗi , biến chuỗi thành list
    a = phone_number.split('.')
    a.remove('')
    for value in a:
        print(f"{value}") # ko dùng lệnh : print(a) vì nó in mẹ cái cả list chứa []
