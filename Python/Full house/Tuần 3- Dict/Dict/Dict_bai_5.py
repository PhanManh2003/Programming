people = [
    {
        'Name': 'Nguyen Anh',
        'Birth_day': '06/06/1999'
    },
    {
        'Name': 'Nguyen Anh 2',
        'Birth_day': '06/06/1998'
    },
    {
        'Name': 'Nguyen Anh',
        'Birth_day': '06/06/1997'
    },
    {
        'Name': 'Nguyen Anh 4',
        'Birth_day': '06/06/1999'
    }
]

flag = False
while not flag:
    name = input("Nhập tên người bạn muốn xem: ").title()

    for person in people:
        if name == person['Name']:
            print(person['Birth_day'])
            flag = True

    if not flag:
        print("\tKhông có tên cần tìm!") #vòng while lại chạy tiếp

# edit và check
user_input = 'none'
while user_input != '':
    print("\n-----------------------------------------------------\n")
    print("1. Nhập 'edit' để thêm trường id")
    print("2. Nhập 'check' để kiểm tra 1 trường có trong dict không.")
    print("3. Thoát")
    user_input = input("\nMời bạn nhập: ")

    while user_input != 'edit' and user_input != 'check' and user_input != 'exit':
        print("Bạn đã nhập sai. Mời nhập lại!")
        user_input = input("Mời bạn nhập: ")
    #edit
    if user_input == 'edit':
        id_list = []
        for index, person in enumerate(people):
            id = input(f"\nNhập id người thứ {index + 1}: ").upper()
            while id in id_list:
                id = input(f"\nMời nhập lại id người thứ {index + 1}: ")
            person['id'] = id
            id_list.append(id)

        print("\nDanh sách sau khi thêm trường id:")
        for person in people:
            print(person)
    #check
    if user_input == 'check':
        check = input("\nNhập tên trường mà bạn muốn check: ")
        for person in people:
            for key in person.keys():
                if check == key:
                    flag = True
                    break  # đã có trường cần tìm , thoát vòng lặp nhanh không flag bị đổi giá trị @_@
                else:
                    flag = False

        if flag:
            print("\nTrue")
        else:
            print("\nFalse")
    # exit
    if user_input == 'exit':
        exit("Bye, see you later!")


# không nên để print ở trong vòng lặp for vì các trường hợp có flag bằng nhau sẽ đều được in ra cùng một thông báo













