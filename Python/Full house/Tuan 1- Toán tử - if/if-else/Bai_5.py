name = input("Nhập họ tên sinh viên: ")
id = input("Nhập mã sinh viên: ")
mid = float(input("Nhập điểm thi giữa kỳ: "))
end = float(input("Nhập điểm thi cuối kỳ: "))
total = mid * 0.3 + end * 0.7

if total >= 9.5:
    grade = 'A+'
elif total >= 8.5 and total < 9.5:
    grade = 'A'
elif total >= 8 and total < 8.5:
    grade = 'B+'
elif total >= 7 and total < 8:
    grade = 'B'
elif total >= 6.5 and total < 7:
    grade = 'C+'
elif total >= 5.5 and total < 6.5:
    grade = 'C'
elif total >= 5 and total < 5.5:
    grade = 'D+'
elif total >= 4 and total < 5:
    grade = 'D'
else:
    grade = 'F'

print(f"Sinh viên: {name}, MSV: {id} có điểm bằng chữ là: {grade}")