dict_1 = {
    'name': 'Anh Nguyen',
    'age': 18,
    'food': 'milk',
}

dict_2 = {
    'full_name': 'Anh Nguyen',
    'age': 19,
    'birth_day' :22/3/3333,
}

coincide = 0
spot_key = []
for key_dict_1 in dict_1.keys():
    for key_dict_2 in dict_2.keys():
        if key_dict_1 == key_dict_2:
            coincide += 1
            spot_key.append(key_dict_1)

not_coincide = len(dict_1.keys()) - coincide
print(f"Có {coincide} key trùng đó là key: {spot_key}")
print(f"Số key không trùng nhau là: {not_coincide}")

