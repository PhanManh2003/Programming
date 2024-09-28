users = [{
    'userId': 1,
    'id': 1,
    'title': 'delectus aut autem',
    'completed': False,
},
    {
        'userId': 1,
        'id': 2,
        'title': 'quis ut nam facilis et officia qui',
        'completed': False,
    },
    {
        'userId': 4,
        'id': 3,
        'title': 'fugiat veniam minus',
        'completed': False,
    },
    {
        'userId': 2,
        'id': 4,
        'title': 'et porro tempora',
        'completed': True,
    }
]

# 1. In ra dict có title = “et porro tempora”
count_1 = 0
list_1 = []
for user in users:
    if user['title'] == 'et porro tempora':
        count_1 += 1
        list_1.append(user)

if count_1 > 0:
    print(f"\nDict có 'title' là 'et porro tempora' là:")
    for value in list_1:
        print(value)
else:
    print(f"\nList không có dict nào có 'title' là 'et porro tempora' hết @_@.")

# 2.	Tìm ra những list completed = False
count_2 = 0
list_2 = []
for user in users:
    if not user['completed']:
        count_2 += 1
        list_2.append(user)

if count_2 > 0:
    print(f"\nDict có 'completed' là 'False' là:")
    for value in list_2:
        print(value)
else:
    print(f"\nList không có dict nào có 'completed' là 'False' hết @_@.")

# 3.	Sắp xếp theo “userId”
for i in range(len(users) - 1):
    for j in range(i + 1, len(users)):
        if users[i]['userId'] > users[j]['userId']:
            temp = users[i]
            users[i] = users[j]
            users[j] = temp
print(f"\nList users sau khi sắp xếp theo UserId là: ")
for user in users:
    print(user)
