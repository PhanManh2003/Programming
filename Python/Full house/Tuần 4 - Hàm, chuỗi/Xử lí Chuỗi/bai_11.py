# Viết một hàm Python để đảo ngược một chuỗi nếu độ dài của nó là bội số của 4.
def reverse_string():
    while True:
        input_string = input("Nhập chuỗi: ")
        if len(input_string) % 4 != 0:
            print("Chuỗi này có độ dài không phải bội của 4 @_@.")
        else:
            input_string = list(input_string)
            input_string.reverse()
            print(''.join(input_string))
            # Hoặc .sort(reverse = True)
            # Hoặc sorted(input_string, reverse = True)
            break


reverse_string()
