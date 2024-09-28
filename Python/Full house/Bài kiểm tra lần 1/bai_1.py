a = "Toi da hoc lap trinh o full house 120 buoi."
count_upper = 0
count_lower = 0
count_number = 0

for i in a:
    if i.isupper():
        count_upper += 1
    if i.islower():
        count_lower += 1
    if i.isdigit():
        count_number += 1

print(f"Chữ hoa: {count_upper}")
print(f"Chữ thường: {count_lower}")
print(f"Chữ số: {count_number}")