# I, LIST OPERATIONS
# 1 Concepts
fruits = ['apple', 'orange', 'lemon', 'watermelon', 5, 6, 7]  # string thuong dc dat trong apostrophe ''
print(fruits)
print(fruits[0].upper())
print(fruits[-1])
print(fruits[-2])

# 2 Changing, add, remove elements in a list
footballer = ['ronaldo', 'messi', 'bale']  # define a list
print(footballer)
footballer[0] = 'xavi'  # change
print(footballer)

# 3 Add a new element
footballer.append('zidane')
print(footballer)

# 4 Insert element
footballer.insert(1, 'hakimi')
print(footballer)

# 5.1 Remove an item if know the value
footballer.remove('bale')
print(footballer)

#  5.2 Remove an item using del + list_name[index] ( không sử dụng được phần tử đã xóa )
# hàm del không xóa được phần tử của 1 chuỗi
del footballer[0]
print(footballer)

# 5.3 Remove using pop() ( sử dụng được phần tử sau khi xóa )
removed_footballer = footballer.pop(2)
print(footballer)
print(removed_footballer)
print(f"The best CAM in fifa online 4 is {removed_footballer.title()}")

# 6.1 Sort a list
members = ['Manh', 'Dung', 'Nam', 'Binh', 'Phong', 'Thu']
members.sort()
print(members)

members.sort(reverse=True)  # nguoc Alphabet
print(members)

# 6.2 Sort mà không ảnh hưởng giá trị
print(sorted(members))
print(f"Here is the sorted list: {sorted(members)} ")
print(sorted(members, reverse=True))

# 6.3 Printing in reverse order
members.reverse()
print(members)

# II, LIST WORKING

# 1 Make a list of numbers
score = list(range(1, 6))
print(score)

# 2 Find min max sum
digit = list(range(1, 11))

print(min(digit))
print(max(digit))
print(sum(digit))

# 3 List self-format
alex = [value ** 4 for value in range(1, 5)]  # No colon ':' after loop only
print(alex)

# 4 Working with part of a list
players = ['messi', 'ronaldo', 'neymar', 'torres', 'gullit', 'kaka']
print(players[1:4])  # print 1th -> 3th
print(players[:5])  # beginning to 4th index , : before a number means print from begining to that index and vice versa
print(players[2:])  # from the second one to the ends
print(players[-2:])  # the last 2 items

# 5 Copying a list
a1 = [1, 2, 3, 5, 34, 44, 32, 84, 3, 3, 3]
print(a1.count(3))  # hàm đếm phần tử 3 trong mảng
a2 = a1[:]  # ko nhập a2 = a1 vì khi thay đổi a1 thì a2 cũng bị thay đổi theo y hệt
print(a2)

