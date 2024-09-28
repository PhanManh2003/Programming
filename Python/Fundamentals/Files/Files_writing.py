filename_1 = 'pi_digits.txt'
with open(filename_1, 'w') as file_object_1:  # mở tệp ở chế độ 'w' sẽ tự động xóa nội dung của tệp trước khi trả về
    file_object_1.write("Goodbye and see you again.\n")
    file_object_1.write("Phan Tien Manh.\n")
with open(filename_1, 'a') as file_object_1:
    file_object_1.write("Next time , please remember my name.\n")

# 1 . bài tập 1 ( nhắc người dùng nhập tên và ghi tên đó vào 1 file txt riêng )
filename_2 = 'guests.txt'
with open(filename_2, 'w', encoding='utf-8') as file_object_2:
    name = input("Mời nhập tên của bạn vào: ")
    file_object_2.write(f"My name is {name}\n")

# 2. bài tập 2 ( viết chương trình hỏi tại sao họ thích lập trình và ghi lại vào 1 file txt )
with open(filename_2, 'a', encoding='utf-8') as file_object_2:
    i = 0
    while i < 4:
        position = input("Tell me your position on the pitch: ")
        player = input("Tell me why your favourite player at this position : ")
        file_object_2.write(f"position: {position} ->  {player}\n")
        i += 1
