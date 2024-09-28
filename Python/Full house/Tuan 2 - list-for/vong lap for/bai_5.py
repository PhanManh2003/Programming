# Khởi tạo danh sách sinh viên
students = []
N = int(input("Nhập vào số lượng sinh viên: "))
for i in range(N):
    print(f"Thông tin sinh viên thứ {i + 1}: ")
    student_id = input("\nNhập id: ").upper()
    name = str(input("Nhập name: ").title())
    mid_term = float(input("Nhập mid_term: "))
    final = float(input("Nhập final: "))
    total = mid_term * 0.3 + final * 0.7

    students.append({
        'name': name,
        'student_id': student_id,
        'mid_term': mid_term,
        'final': final,
        'total': total,
    })
# Result evaluation
for student in students:
    if student['total'] >= 9.5:
        student['grade'] = 'A+'
    elif 8.5 <= student['total'] < 9.5:
        student['grade'] = 'A'
    elif 8 <= student['total'] < 8.5:
        student['grade'] = 'B+'
    elif 7 <= student['total'] < 8:
        student['grade'] = 'B'
    elif 6.5 <= student['total'] < 7:
        student['grade'] = 'C+'
    elif 5.5 <= student['total'] < 6.5:
        student['grade'] = 'C'
    elif 5 <= student['total'] < 5.5:
        student['grade'] = 'D+'
    elif 4 <= student['total'] < 5:
        student['grade'] = 'D'
    elif student['total'] < 4:
        student['grade'] = 'F'
# Menu
choice = 0
while choice != 10:
    print("\n-----------------------------------------------------")
    print("1. In ra danh sách các sinh viên có điểm A+")
    print("2. In ra danh sách các sinh viên có điểm F")
    print("3. Sắp xếp sinh viên có điểm từ cao xuống thấp")
    print("4. Tính điểm trung bình tất cả các sinh viên")
    print("5. Đếm số sinh viên có điểm F")
    print("6. Kiểm tra sinh viên đã qua môn theo tên")
    print("7. Thêm sinh viên")
    print("8. Sửa sinh viên theo MSV")
    print("9. Xoá sinh viên theo MSV")
    print("10. Thoát")
    choice = int(input("\nMời bạn chọn: "))

    # 1. Print A+ students
    if choice == 1:
        count_A_plus = 0
        members_A_plus = []
        for student in students:
            if student['grade'] == 'A+':
                count_A_plus += 1
                members_A_plus.append(student)
        if count_A_plus > 0:
            print(f"\nA+ students are: ")
            for member in members_A_plus:
                print(f"{member}")
        else:
            print("\nThere's no A+ student here!")

    # 2. Print F students
    elif choice == 2:
        count_F_plus = 0
        members_F = []
        for student in students:
            if student['grade'] == 'F':
                count_F_plus += 1
                members_F.append(student)
        if count_F_plus > 0:
            print(f"\nF students are: ")
            for member in members_F:
                print(f"{member}")
        else:
            print("\nThere's no F student here!")

    # 3. Sorting in descending scores
    elif choice == 3:
        for i in range(0, len(students) - 1, 1):
            for j in range(i + 1, len(students), 1):
                if students[i]['total'] < students[j]['total']:
                    temp = students[i]['total']
                    students[i]['total'] = students[j]['total']
                    students[j]['total'] = temp

        print("\nHere's the list of students with descending scores order:")
        for student in students:
            print(student)

    # 4. Average score of students
    elif choice == 4:
        S = 0
        for student in students:
            S += student['total']
        average = S / N
        print(f"\nThe average score of all students is: {average}")

    # 5. Count the number of F students
    elif choice == 5:
        count_F_plus = 0
        members_F = []
        for student in students:
            if student['grade'] == 'F':
                count_F_plus += 1
                members_F.append(student)
        if count_F_plus > 0:
            print(f"\nF students are: ")
            for member in members_F:
                print(f"{member}")
        else:
            print("\nThere's no F student here!")

    # 6. Pass checking
    elif choice == 6:
        flag = 0
        check_name = str(input("Nhập tên sinh viên cần kiểm tra: ").title())

        for student in students:
            if check_name == student['name']:
                flag = 1  # đã phát hiện
                if student['total'] >= 4:
                    print(f"\nXin chúc mừng {check_name} đã qua môn!")
                else:
                    print(f"\nXin lỗi, {check_name} không qua môn!")
                break  # không xét các phần tử phía sau nữa vì sẽ làm thay đổi giá trị của flag
        if flag == 0:
            print("\nKhông có tên sinh viên cần tìm trong danh sách!")

    # 7. Add student ( like the beginning )
    elif choice == 7:
        add_number = int(input("Nhập vào số lượng sinh viên cần thêm: "))

        for i in range(add_number):
            student_id = input("\nNhập id: ").upper()
            name = str(input("Nhập name: ").title())
            mid_term = float(input("Nhập mid_term: "))
            final = float(input("Nhập final: "))
            total = mid_term * 0.3 + final * 0.7

            students.append({
                'name': name,
                'student_id': student_id,
                'mid_term': mid_term,
                'final': final,
                'total': total,
            })
        # Result evaluation
        for student in students:
            if student['total'] >= 9.5:
                student['grade'] = 'A+'
            elif 8.5 <= student['total'] < 9.5:
                student['grade'] = 'A'
            elif 8 <= student['total'] < 8.5:
                student['grade'] = 'B+'
            elif 7 <= student['total'] < 8:
                student['grade'] = 'B'
            elif 6.5 <= student['total'] < 7:
                student['grade'] = 'C+'
            elif 5.5 <= student['total'] < 6.5:
                student['grade'] = 'C'
            elif 5 <= student['total'] < 5.5:
                student['grade'] = 'D+'
            elif 4 <= student['total'] < 5:
                student['grade'] = 'D'
            elif student['total'] < 4:
                student['grade'] = 'F'

        print("\nDanh sách sinh viên sau khi thêm:")
        for student in students:
            print(student)

    # 8.Sửa sinh viên theo MSSV
    elif choice == 8:
        mssv = input("Nhập mã số sinh viên cần sửa: ").upper()
        # để upper bên trong thì sẽ viết hoa câu lệnh hiển thị chứ ko viết hoa cái câu mình nhập vào
        flag_8 = 0

        for index, student in enumerate(students):
            if mssv == student['student_id']:
                flag_8 = 1  # đã phát hiện
                del students[index]  # xóa đi

                student_id = input("\nNhập id: ").upper()
                name = str(input("Nhập name: ").title())
                mid_term = float(input("Nhập mid_term: "))
                final = float(input("Nhập final: "))
                total = mid_term * 0.3 + final * 0.7

                students.insert(index, {
                    'name': name,
                    'student_id': student_id,
                    'mid_term': mid_term,
                    'final': final,
                    'total': total,
                })
                break
        if flag_8 == 0:
            print("\nKhông có MSSV cần tìm trong danh sách!")

            # Result evaluation
        for student in students:
            if student['total'] >= 9.5:
                student['grade'] = 'A+'
            elif 8.5 <= student['total'] < 9.5:
                student['grade'] = 'A'
            elif 8 <= student['total'] < 8.5:
                student['grade'] = 'B+'
            elif 7 <= student['total'] < 8:
                student['grade'] = 'B'
            elif 6.5 <= student['total'] < 7:
                student['grade'] = 'C+'
            elif 5.5 <= student['total'] < 6.5:
                student['grade'] = 'C'
            elif 5 <= student['total'] < 5.5:
                student['grade'] = 'D+'
            elif 4 <= student['total'] < 5:
                student['grade'] = 'D'
            elif student['total'] < 4:
                student['grade'] = 'F'
        print(f"\nDanh sách sinh viên sau khi sửa:")
        for student in students:
            print(student)

    # 9.Xóa sinh viên theo MSSV
    elif choice == 9:
        mssv = input("Nhập mã số sinh viên cần xóa: ").upper()
        flag_9 = 0

        for index, student in enumerate(students):
            if mssv == student['student_id']:
                flag_9 = 1  # đã phát hiện
                del students[index]  # xóa đi
                break
        if flag_9 == 0:
            print("\nKhông có MSSV cần tìm trong danh sách!")

        print(f"\nDanh sách sinh viên sau khi xóa:")
        for student in students:
            print(student)

    # 10. Thoát
    elif choice == 10:
        exit("Bye, see you later!")
    # Nhập nhầm số
    else:
        print("Bạn đã nhập sai. Mời nhập lại!")
        choice = int(input("Mời bạn chọn: "))
