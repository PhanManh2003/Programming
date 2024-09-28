student_1 = [165, 270, 300]
student_2 = [166, 272, 301]
student_3 = [168, 273, 305]
student = [student_1, student_2, student_3]
print(student)
 #list trong list
N = int(input("Nhập số nguyên N bất kỳ: "))
# Xếp lần lượt theo dòng:
if N > 0:
    for index in range(1, N+1, 1):
        print(f"{index} ", end='   ')
else:
    for index in range(1, N-1, -1): # nếu N = -5 thì chạy
        print(f"{index}", end='   ')
#
print("\n")
shopping_list = {}

def add_item(item_name, quantity=1):
    if item_name in shopping_list.keys():
        shopping_list[item_name] += quantity
    else:
        shopping_list[item_name] = quantity

add_item("Bread")
add_item("Milk")
print(shopping_list)
#


















