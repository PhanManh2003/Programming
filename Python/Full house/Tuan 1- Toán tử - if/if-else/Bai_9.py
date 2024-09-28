money = float(input("Nhập số tiền gửi tiết kiệm (đơn vị: triệu đồng): "))
interest = float(input("Nhập lãi suất: "))

if interest < 0 or interest > 1:
    print("Interest not valid!")
else:
    time_unit = input("Nhập đơn vị theo ngày/tháng: ")
    time_value = int(input("Nhập số ngày/tháng gửi tiền: "))

    if time_value < 0:
        print("time_value not valid!")
    elif time_unit == 'ngày':
        print(f"Tổng số tiền lãi nhận được là {money * interest * time_value / 360} triệu đồng")
    elif time_unit == 'tháng':
        print(f"Tổng số tiền lãi nhận được là {money * interest * time_value / 12} triệu đồng")

