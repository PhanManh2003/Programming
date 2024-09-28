name = str(input("Nhập họ tên nhân viên: "))
pretax_salary = float(input("Nhập lương trước thuế của nhân viên (đơn vị: triệu đồng): "))
if pretax_salary <= 0:
    print("Not valid!")

if pretax_salary >= 15:
    tax = pretax_salary * 0.3
    percent='30%'
    real_salary = pretax_salary - tax
elif pretax_salary >= 7 and pretax_salary < 15:
    tax = pretax_salary * 0.2
    percent = '20%'
    real_salary = pretax_salary - tax
else:
    tax = pretax_salary * 0.1
    percent = '10%'
    real_salary = pretax_salary - tax

print(f"Nhân viên: {name.title()}, nhận lương ròng: {real_salary} \nvới thuế là: {percent}.\n (đơn vị: triệu đồng) ")
