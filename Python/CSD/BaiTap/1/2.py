def menu():
    print("-----------------------Menu-----------------------")
    print("     2. Nhập mã sv, tìm và hiển thị thông tin sinh viên đó.")
    print("     3. Tìm mã và xóa sinh viên đó")
    print("     4. Tìm mã và sửa điểm sinh viên đó ")
    print("     5. Thoát")
    return int(input("Bạn chọn: "))


def save_data(file_path, linkedlist):
    with open(file_path, 'w', encoding='utf-8') as f:
        cur = linkedlist
        while cur is not None:
            f.write(f"{cur.student_id}\t{cur.name}\t{cur.point}\n")
            cur = cur.next
    print("Lưu thành công.")


def main():
    # 1. Đọc thông tin các sinh viên từ file data.txt vào một danh sách liên kết và hiển thị
    class Student:
        def __init__(self, student_id, name, point):
            self.student_id = student_id  # value 1
            self.name = name  # value 2
            self.point = point  # value 3
            self.next = None  # pointer

    def read_data(directory):
        head = None
        tail = None

        with open(directory, 'r', encoding='utf-8') as f:
            for line in f:
                student_id, name, point = line.strip().split('\t')
                student = Student(student_id, name, point)  # tạo 1 node student từ Class Student

                if head is None:
                    # If the list is empty, set the new student as the head
                    head = student
                    tail = student
                else:
                    # If the list is not empty, append the new student to the tail
                    tail.next = student
                    tail = student
        return head  # trả về linked list

    def display_students(students):
        print("Danh sách sinh viên:")
        current = students
        while current is not None:
            print(f"{current.student_id}\t{current.name}\t{current.point}")
            current = current.next

    file_path = 'data.txt'
    student_list = read_data(file_path)
    display_students(student_list)

    while True:
        select = menu()
        if select == 2:
            def find_student_2(id_needed, linkedlist):
                cur = linkedlist
                while cur is not None:
                    if cur.student_id == id_needed:
                        return cur  # trả về node
                    cur = cur.next

                return None

            search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
            found_student = find_student_2(search_id, student_list)
            if found_student:
                print("Đã tìm thấy sinh viên:")
                print(f"Student ID: {found_student.student_id}")
                print(f"Name: {found_student.name}")
                print(f"Point: {found_student.point}\n")
            else:
                print("Không tìm thấy sinh viên!\n")

        elif select == 3:
            def find_student_3(id_needed, linkedlist):
                cur = linkedlist
                pre = None
                while cur is not None:
                    if cur.student_id == id_needed:
                        return pre, cur
                    # tịnh tiến 2 con trỏ nếu không trùng id
                    pre = cur
                    cur = cur.next

                return None, None

            def delete_student(id_needed, linkedlist):
                pre, cur = find_student_3(id_needed=id_needed, linkedlist=linkedlist)
                if cur:
                    if pre:
                        pre.next = cur.next
                        cur.next = None
                    else:
                        linkedlist = cur.next  # linkedlist bắt đầu từ node tiếp theo
                        print(f"Sinh viên với ID: {cur.student_id} đã được xóa.\n")
                else:
                    print("Không tìm thấy sinh viên!\n")
                return linkedlist

            search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
            student_list = delete_student(search_id, student_list)

            # Lưu dữ liệu lại vào file data.txt sau khi xóa
            file_path = 'data.txt'
            save_data(file_path, student_list)

            # Hiển thị lại danh sách sinh viên
            display_students(student_list)

        elif select == 4:
            def find_student_4(id_needed, linkedlist):
                cur = linkedlist
                while cur is not None:
                    if cur.student_id == id_needed:
                        return cur  # trả về node
                    cur = cur.next

                return None

            def update_student_point(id_needed, linkedlist):
                cur = find_student_4(id_needed=id_needed, linkedlist=linkedlist)
                if cur:
                    point = float(input("Nhập điểm mới cho sinh viên: "))
                    cur.point = str(point)
                else:
                    print("Không có sinh viên bạn muốn tìm.\n")
                return linkedlist

            search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
            student_list = update_student_point(search_id, student_list)

            # Lưu dữ liệu lại vào file data.txt sau khi sửa điểm
            file_path = 'data.txt'
            save_data(file_path, student_list)

            # Hiển thị lại danh sách sinh viên
            display_students(student_list)

        elif select == 5:
            print("Tạm biệt.")
            break

        else:
            print("Sai, chọn từ 2 đến 4!\n")


if __name__ == '__main__':
    main()
