age = int(input("What's your age?: "))
if age <= 0:
    print("Not valid, type again!")
elif age < 16:
    print("Not old enough!")
else:
    print("Old enough, you can study!")
