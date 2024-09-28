# Đọc dữ liệu từ file data.txt vào 1 danh sách liên kết và hiển thị
class Student:
    def __init__(self, student_id, name, point):
        self.student_id = student_id
        self.name = name
        self.point = point
        self.next = None


def save_data(file_path, students):
    with open(file_path, 'w', encoding='utf-8') as f:
        cur = students
        while cur is not None:
            f.write(f"{cur.student_id}\t{cur.name}\t{cur.point}\n")
            cur = cur.next
    print("Lưu thành công.")


def read_file(file_path):
    head = None
    tail = None

    with open(file_path, 'r', encoding='utf-8') as f:
        for line in f:
            student_id, name, point = line.strip().split('\t')
            student = Student(student_id, name, point)
            if head is None:
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
students = read_file(file_path)
display_students(students)


# 2 Tìm mã sinh viên và hiển thị
def find_2(student_id, students):
    cur = students
    while cur is not None:
        if cur.student_id == student_id:
            return cur  # trả về node
        cur = cur.next

    return None


search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
found_student = find_2(search_id, students)
if found_student:
    print("Đã tìm thấy sinh viên:")
    print(f"Student ID: {found_student.student_id}")
    print(f"Name: {found_student.name}")
    print(f"Point: {found_student.point}\n")
else:
    print("Không tìm thấy sinh viên!\n")


# 3. Tìm mã và xóa
def find_3(student_id, students):
    cur = students
    pre = None
    while cur is not None:
        if cur.student_id == student_id:
            return pre, cur
        # tịnh tiến 2 con trỏ nếu không trùng id
        pre = cur
        cur = cur.next

    return None, None


def delete_student(student_id, students):
    pre, cur = find_3(student_id=student_id, students=students)
    if cur:
        if pre:
            pre.next = cur.next
            cur.next = None
        else:
            students = cur.next  # students bắt đầu từ node tiếp theo
            print(f"Sinh viên với ID: {cur.student_id} đã được xóa.\n")
    else:
        print("Không tìm thấy sinh viên!\n")
    return students


search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
students = delete_student(search_id, students)

file_path = 'data.txt'
save_data(file_path, students)
display_students(students)


# 4
def find_4(student_id, students):
    cur = students
    while cur is not None:
        if cur.student_id == student_id:
            return cur  # trả về node
        cur = cur.next

    return None


def update_student_point(student_id, students):
    cur = find_4(student_id=student_id, students=students)
    if cur:
        point = float(input("Nhập điểm mới cho sinh viên: "))
        cur.point = str(point)
    else:
        print("Không có sinh viên bạn muốn tìm.\n")
    return students


search_id = input("Mời bạn nhập mã sinh viên cần tìm: ").upper()
students = update_student_point(search_id, students)

file_path = 'data.txt'
save_data(file_path, students)

display_students(students)
