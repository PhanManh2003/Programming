prompt = "if you tell me who you are. i can serve you best."
prompt += "\n What is your first name ? "  # add thêm chuỗi vào prompt

name = input(prompt)
print(f"\n hello, {name.title()}")

# 1 intro for while loop
current_number = 1
while current_number <= 5:
    print(current_number)
    current_number += 1  # tăng thêm 1 ( viết tắt của current_number = current_number + 1)

# 2 let users choose when to quit a program
prompt = "\n Tell me something, I will repeat back to you:"
prompt += "\n Enter 'quit' to end an program."
message = ''
while message != 'quit'.lower():
    message = input(prompt)
    print(message)

# 3 Using a flag
prompt = "\n Tell me something, we repeat back to you:"
active = True
while active:
    message = input(prompt)
    if message == 'quit':
        active = False
        break
    else:
        print(message)
# 4 Using break to exit Loop ( same like #3)
# 5 Using continue in a loop (turn back  )

number = 0
while number < 10:
    number += 1
    if number % 2 == 0:
        continue  # ko thực hiện đoạn code sau mà quay trở lại từ đầu ( turn back )
    print(number)  # ko dc viết cùng indent với continue

# 6 Moving Items from one list to another
unconfirmed_users = ['ronaldo', 'messi', 'benzema']
confirmed_users = []

while unconfirmed_users:  # check if list unconfirmed_users has elements
    current_user = unconfirmed_users.pop()
    print(f"Verifying users: {current_user.title()}")
    confirmed_users.append(current_user)

print(f"The following users have been confirmed:")
for i in confirmed_users:
    print(i.title())
#7 Removing all items of the same value from a list
pets = ['dog','cat','cat','cat','mouse']
print(pets)
while 'cat' in pets:
    pets.remove('cat')
print(pets)
#8 Filling a Dictionary with user input


