A = [
    {
        "Name": "Nguyen Anh",
        "Birth_day": "06/06/1999"
    },
    {
        "Name": "Nguyen Anh 2",
        "Birth_day": "06/06/1998"
    },
    {
        "Name": "Nguyen Anh",
        "Birth_day": "06/06/1997"
    },
    {
        "Name": "Nguyen Anh 4",
        "Birth_day": "06/06/1999"
    }
]
keyword = "a"
id_list = []
while keyword != '':
    print("\n**************************************\n")
    print("1. Nhập tên để tra ngày sinh")
    print("2. Nhập 'edit' để thêm trường id")
    print("3. Nhập 'check' để kiểm tra trường có trong dict không.")
    print("4. Nhấn Enter để kết thúc chương trình")
    keyword = input("\nMời nhập: ")

    if keyword != "edit" and keyword != "check" and keyword:
        flag = False
        for value in A:
            if keyword == value["Name"]:
                print(value["Birth_day"])
                flag = True
        if not flag:
            print(f"Không có người nào tên là {keyword} trong list")

    if keyword == "edit":
        for index in range(len(A)):
            print(f"Nhập id người thứ {index + 1}: ", end="")
            id = input()
            while id in id_list:
                print(f"Không được đặt id trùng nhau, mời nhập lại id người thứ {index + 1}: ", end="")
                id = input()
            id_list.append(id)
            A[index]["id"] = id
        print(A)

    if keyword == "check":
        key = input("Nhập tên trường: ")
        check = True
        for value in A:
            if key not in value:
                check = False
                break
        print(check)

    if not keyword:  # không chứa kí tự gì
        exit("See you again!")
