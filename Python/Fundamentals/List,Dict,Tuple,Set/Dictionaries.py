# A dictionary in python is a collection of key( each key is connected to a value)
# A value can be string, number , list or even dictionary
dic = {x: x * 2 for x in range(1, 6)}  # create dict
print(dic)

alien = {'color': 'red', 'point': 10}
print(alien['color'])
print(alien['point'])
# 1 Add new key-value to the dictionary
alien['x_position'] = 0
alien['y_position'] = 15
print(alien)

# 2 Start with an empty dictionary
superman = dict()
superman['color'] = 'blue'
superman['strength'] = '250'
print(superman)

# 3 Modify value in dictionary
bird = {'x_position': 0, 'y_position': 20, 'speed': 'medium'}
print(f"\nOriginal position: {bird['x_position']}")
# move bird to the right
if bird['speed'] == 'slow':
    x_increment = 1
if bird['speed'] == 'medium':
    x_increment = 2
if bird['speed'] == 'fast':
    x_increment = 3

bird['x_position'] = bird['x_position'] + x_increment
print(f"New position: {bird['x_position']}")

# 4 Remove a key-value pair
alien = {'color': 'red', 'point': 10}
del alien['color']
print(f"\n{alien}")

# 5 Dùng get() truy cập giá trị bất kì
# calling = favorite_languages.get('ronaldo', 'Nothing found yet!')
# print(calling)

# 6. Looping in dictionaries
languages = {
    'Jen': 'python',
    'Sarah': 'C',
    'Edward': 'ruby',
    'Alex': 'python',
    'William': 'ruby'
}
for k, v in languages.items():
    print(f"\n Name: {k}")
    print(f"Language: {v}")

    # 7 Nesting
    # 7.1 List of Dictionaries
    alien_0 = {'color': 'green', 'point': 5}
    alien_1 = {'color': 'red', 'point': 12}
    alien_2 = {'color': 'yellow', 'point': 23}
aliens = [alien_0, alien_1, alien_2]
for alien in aliens:
    print(alien)

# 7.2 Lists inside a Dictionaries ( more than 1 value associated with a key )
print()
salary = {
    'Ronaldo': [28, 27],
    'Messi': 27,
    'Zidane': 26,
}

print(salary.keys())  # bản chất là list
print(salary.items())  # bản chất là list of tuples
print(type(salary.items()))
print(sorted(salary.items()))  # return a list of sorted tuple ( hàm sorted trả về 1 list object đc sắp xếp )

for name, salary in sorted(salary.items()):  # looping in a list of sorted tuple
    print(f"\n{name}'s salary is: {salary} ")

# 7.3 Dictionaries inside a Dictionaries ( 1 key has a multiple key-value pair )
print("\n")
users = {
    'Einstein': {
        'specialization': 'physics',
        'birthday': '1944',
        'gender': 'man',
        'location': 'New York',
    },  # chú ý có 1 dấu comma giữa 2 dictionary
    'Marie_Curie': {
        'specialization': 'chemistry',
        'birthday': '1932',
        'gender': 'woman',
        'location': {
            'city': 'London',
            'country': 'England'
        },
    }
}

for username, user_info in users.items():
    print(f"Username: {username}")
    print(f"\t-specialization: {user_info['specialization']}")
    print(f"\t-birthday: {user_info['birthday']}")
    print(f"\t-gender: {user_info['gender']}")
    print(f"\t-location:: {user_info['location']}")
# truy cap gia tri bat ki
print(users['Marie_Curie'].get('location'))
print(users['Marie_Curie'].get('location').get('city'))
print(users['Marie_Curie']['location']['city'])

# 8. Bai Tap Đếm số lần xuất hiện của 1 phần tử trong 1 list ( ứng dụng của dict)
counts = dict()
names = ['csev', 'cwen', 'csev', 'zqian', 'cwen']
for name in names:
    counts[name] = names.count(name)
print(counts)

# Cách 2
# for name in names:
#     counts[name] = counts.get(name, 0) + 1
# print(counts)

# 9. add 2 dict
dict1 = {'a': 1, 'b': 2}
dict2 = {'c': 3, 'd': 4}
dict3 = dict1.update(dict2)
print(dict3)
