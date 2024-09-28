# Tên: Phan Tiến Mạnh , Mã Sv: HE172481, Lớp AI1805

# 1 Tạo file
file_path = 'data.txt'
with open(file_path, 'w', encoding='utf-8') as f:
    f.close()

# 2 Lưu thông tin người dùng
with open(file_path, 'a', encoding='utf-8') as f:
    n = int(input("Nhập vào số lượng sinh viên: "))
    for i in range(n):
        print(f"Thông tin sinh viên thứ {i + 1}: ")
        student_id = input("Nhập id: ").upper()
        name = str(input("Nhập name: ").title())
        point = float(input("Nhập điểm cho sinh viên: "))
        f.write(f"{student_id}\t{name}\t{point}\n")

    # Hiển thị thông báo
    choice = input("Bạn có tiếp tục nhập dữ liệu không [c/k] ?")

    while choice == 'c':  # case 1
        print(f"Thông tin sinh viên thứ {n + 1}: ")
        student_id = input("Nhập id: ").upper()
        name = str(input("Nhập name: ").title())
        point = float(input("Nhập điểm cho sinh viên: "))
        f.write(f"{student_id}\t{name}\t{point}\n")
        print()
        n += 1
        choice = input("Bạn có tiếp tục nhập dữ liệu không [c/k] ?")

    if choice == 'k':  # case 2
        exit("Tạm biệt !")

    while choice != 'c' and choice != 'k':  # case 3
        print("Nhập 'c' hoặc 'k'!")
        choice = input("Bạn có tiếp tục nhập dữ liệu không [c/k] ?")
        while choice == 'c':
            print(f"Thông tin sinh viên thứ {n + 1}: ")
            student_id = input("Nhập id: ").upper()
            name = str(input("Nhập name: ").title())
            point = float(input("Nhập điểm cho sinh viên: "))
            f.write(f"{student_id}\t{name}\t{point}\n")
            print()
            n += 1
            choice = input("Bạn có tiếp tục nhập dữ liệu không [c/k] ?")
        if choice == 'k':
            exit("Tạm biệt !")
