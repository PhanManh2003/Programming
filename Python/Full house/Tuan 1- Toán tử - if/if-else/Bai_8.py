consumption = int(input("Nhập số điện tiêu thụ (đơn vị: KWh): "))

if consumption < 0:
    print("Not valid")
elif consumption <= 50:
    charge = 1.678
elif 51 <= consumption <= 100:
    charge = 1.734
elif 101 <= consumption <= 200:
    charge = 2.014
elif 201 <= consumption <= 300:
    charge = 2.536
elif 301 <= consumption <= 400:
    charge = 2.83
elif consumption >= 401:
    charge = 2.927
payment = charge * consumption
print(f"Bạn phải trả số tiền là: {round(payment)} đồng")
