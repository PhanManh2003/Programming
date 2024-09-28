# 1. Xử lí ngoại lệ ZeroDivisionError
try:
    print(5 / 0)
except ZeroDivisionError:
    print("You dumb!")

# 2. try - except - else
try:
    a = 10
    b = 2
    answer = a / b
    print(answer)
except ZeroDivisionError:
    print("\nShit!")
else:  # coi khối else như khối mã bổ sung nếu khối try chạy thành công
    print("\nBạn đã thực hiện thành công phép chia này.")


# 3 Xử lí ngoại lệ FileNotFoundError và đếm số từ trong 1 văn bản + làm việc với nhiều tệp cùng lúc
def count_words_in_file(filename):
    try:
        with open(filename, encoding='utf-8') as file_object:
            contents = file_object.read()
    except FileNotFoundError:
        pass  # thất bại âm thầm ( do nothing )
    else:
        words = contents.split()
        print(f"The file {filename} has {len(words)} words.")


filenames = ["D:\\Python\\project\\Files\\pi_digits.txt",
             "D:\\Python\\project\\Files\\guests.txt",
             "D:\\Python\\project\\Files\\shit.txt"]
for i in filenames:
    count_words_in_file(i)

line = "HELOLOLOjfg, it's me"
print(line.lower().count('elo'))
