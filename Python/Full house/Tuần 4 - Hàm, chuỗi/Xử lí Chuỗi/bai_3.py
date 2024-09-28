# Viết chương trình Python để lấy một chuỗi gồm 2 ký tự đầu tiên và 2 ký tự cuối cùng từ một chuỗi đã cho.
# Nếu độ dài chuỗi nhỏ hơn 2, hãy trả về chuỗi trống.
# Chuỗi mẫu: 'w3resource' > w3 + ce => w3ce Kết quả mong đợi: 'w3ce'
# Chuỗi mẫu: 'w3' > w3 + w3 => w3w3 Kết quả mong đợi: 'w3w3'
# Chuỗi mẫu: 'w' => “”

a = input("Nhập chuỗi: ")
if len(a) < 2:
    print("chuỗi trống.")
else:
    print(a[0] + a[1] + a[-2] + a[-1])
