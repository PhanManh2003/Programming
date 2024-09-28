# Viết chương trình Python để tìm từ được lặp lại nhiều thứ hai trong một chuỗi đã cho.
text = input("Nhập đoạn văn bản: ")

# TODO 1: Tạo một set chứa các từ khác nhau
words = text.split()  # words là 1 list
set_words = set(words)

# TODO 2: Tạo 1 list các dict chứa các từ và số lần lặp lại của chúng ( không dùng set vì không dùng for được)
word_details = []
for value in set_words:
    word_details.append({
        'word': value,
        'times': words.count(value),
    })

# TODO 3: Tạo 1 list chứa số lần lặp lại của các từ và sắp xếp theo thứ tự
repeated_times = []
for value in set_words:
    repeated_times.append(words.count(value))

repeated_times.sort(reverse=True) # lớn đến bé


# TODO 4: Match 2 list vừa tạo theo số nhiều thứ 2
print("\nDanh sách từ lặp lại nhiều thứ 2 là:")
for value in word_details:
    if value['times'] == repeated_times[1]: # Mấu chốt của bài toán
        print(value['word'])
