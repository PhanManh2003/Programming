# Viết chương trình Python để tìm lần xuất hiện đầu tiên của chuỗi con f'not' và 'Poor' từ một chuỗi đã cho,
# nếu 'not' theo sau 'Poor', hãy thay toàn bộ chuỗi con 'not' ... 'Poor' bằng “good”. Trả về chuỗi kết quả.

# Chuỗi mẫu: 'The lyrics is not that is poor!'
# not -> 14, poor-> 26. Do not sau poor -> thay toàn bộ cụm đó = good
# Kết quả mong đợi: 'The lyrics is good!'

a = "The lyrics is not that is poor!"
print(f"-Chuỗi mẫu là: {a}\n")
found_not = a.find('not')
found_poor = a.find('poor')

print(f"-Lần xuất hiện đầu tiên của 'not' là: {found_not}")
print(f"-Lần xuất hiện đầu tiên của 'poor' là: {found_poor}")
if found_not < found_poor:
    a = a.replace(a[found_not: (found_poor + 4)], 'good')
    print(f"-Kết quả mong đợi: {a}")
