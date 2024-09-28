while True:
    try:
        a = float(input("Enter the value of one side of the triangle: "))
        b = float(input("Enter the value of the 2nd side of the triangle: "))
        c = float(input("Enter the value of the 3rd side of the triangle: "))
        if a >= b+c or b >= a+c or c >= b+a:
            print("Not exist this triangle!")
            continue
        break
    except ValueError:
        print("ValueError!")
p = (a+b+c)/2

s = (p*(p-a)*(p-b)*(p-c))**0.5

print(f"Area: {s}")