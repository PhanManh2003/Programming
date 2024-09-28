students = []

choice = 1


def print_students():
    for student in students:
        print(f"{student.student_id}\t{student.name}\t{student.total}")


class Student:
    def __init__(
            self,
            student_id: str,
            name: str,
            mid_term: float,
            final: float
    ):
        self.student_id = student_id
        self.name = name
        self.mid_term = mid_term
        self.final = final
        self.total = self.get_total()
        self.letter_point = self.get_letter_point()

    def get_total(self):
        return self.mid_term * 0.3 + self.final * 0.7

    def get_letter_point(self):
        if self.total > 9:
            return 'A'
        if self.total < 4:
            return 'F'

        return 'Pass'


def main():
    global choice
    while choice != 10:

        print("\n*******************************\n")
        print("1. In ra danh sách các sinh viên có điểm A+")
        print("2. In ra danh sách sinh viên có điểm F")
        print("3. Sắp xếp sinh viên theo điểm TB từ cao xuống thấp")
        print("4. Tính điểm trung bình của tất cả các sinh viên.")
        print("5. Đếm xem có bao nhiêu sinh viên bị điểm F")
        print("6. Kiểm tra xem sinh viên tên có qua môn không? ")
        print("7. Thêm sinh viên")
        print("8. Sửa sinh viên theo MSSV")
        print("9. Xóa sinh viên theo MSSV")
        print("10. Thoát")
        choice = int(input("Bạn chọn: "))

        while choice < 1 or choice > 10:
            choice = int(input("Bạn nhập sai, mời bạn nhập lại: "))

        if choice == 1:
            flag = False
            for student in students:
                if student.total >= 9.5:
                    flag = True
                    print(f"\n==> Sinh viên A+: {student.name} ")
            if not flag:
                print("\n==> Không có sinh viên A+")

        if choice == 2:
            flag = False
            for student in students:
                if student.total < 4:
                    flag = True
                    print(f"==> Sinh viên F: {student.name} ")
            if not flag:
                print("Không có sinh vien F")

        if choice == 3:
            for i in range(0, len(students) - 1):
                for j in range(i + 1, len(students)):
                    if students[i].total < students[j].total:
                        temp = students[i]
                        students[i] = students[j]
                        students[j] = temp

            print(f"==> Danh sách sắp xếp: {students}")

        if choice == 4:
            avg = 0
            for student in students:
                avg += student.total
            print(f"\n=>> Trung bình cộng của điểm các sinh viên là: {float(avg / len(students))}")

        if choice == 5:
            count_ = 0
            for student in students:
                if student.total < 4:
                    count_ += 1

            print(f"\n==> Số học sinh vị điểm F là: {count_}")

        if choice == 6:
            flag = False
            name = str(input("\nNhâp tên sinh viên cần tìm: "))

            if type(name) == str:
                for student in students:
                    if name == student.name:
                        flag = True
                        print(f"\nCó tên sinh viên {name} trong danh sách\n")

                        if student.total >= 4:
                            print(f"==>Sinh viên {name}  qua môn")
                        else:
                            print(f"==>Sinh viên {name} không qua môn")
                        break
                if not flag:
                    print(f"\nKhông có {name} trong danh sách")

        if choice == 7:
            student_id = input("Nhập MSSV: ")
            name = input("Nhập họ tên: ")
            mid_term = float(input("Nhập điểm giữa kì: "))
            final = float(input("Nhập điểm cuối kì: "))

            student = Student(
                student_id=student_id,
                name=name,
                mid_term=mid_term,
                final=final
            )

            if 0 <= student.mid_term <= 10 and 0 <= student.final <= 10:
                students.append(student)
                print("==> Đã thêm thành công")
            else:
                print("XXX Kiểm tra lại thông tin sinh viên XXX")

        # câu 7 em còn trường hợp nhập bị trùng MSSV yêu cầu nhập lại
        if choice == 8:
            flag = False
            MSSV_ = int(input("\nNhập mã số sinh viên cần sửa: "))
            for i in range(len(students)):
                student = students[i]
                if student.student_id == MSSV_:
                    flag = True
                    students[i].student_id = input("Nhập MSSV: ")
                    students[i].name = input("Nhập họ tên: ")
                    students[i].mid_term = float(input("Nhập điểm giữa kì: "))
                    students[i].final = float(input("Nhập điểm cuối kì: "))
                    break

            if not flag:
                print("XXX Không thấy mã số sinh viên XXX")

        if choice == 9:
            flag = False
            MSSV_ = int(input("\nNhập mã số sinh viên cần xóa: "))
            for idx, student in enumerate(students):
                if student.student_id == MSSV_:
                    flag = True
                    students.pop(idx)
                    break

            if not flag:
                print("XXX Không thấy mã số sinh viên XXX")

        print_students()


if __name__ == '__main__':
    main()
