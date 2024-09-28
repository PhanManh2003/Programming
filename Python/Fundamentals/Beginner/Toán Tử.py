# TODO 1. Toán tử thường

# ** lũy thừa . vd 3 ** 4 = 81
# 9 % 2 = 1 chia lấy dư
# 9 // 2 = 4 chia lấy thương
# 9 / 2 = 4.5 chia lấy thập phân


# TODO 2. Toán tử gán

# /= chia và gán x/=5 va x=7 <=> x= x/5
# //= chia lấy thương và gán
# %= chia lấy dư và gán
# **= lũy thừa và gán


year = 2022
clause = year % 2 == 0 and year % 3 > 1
print(clause)

# toán tử 3 ngôi:

a = 1
print("'chẵn") if a % 2 == 0 else print("lẻ")
