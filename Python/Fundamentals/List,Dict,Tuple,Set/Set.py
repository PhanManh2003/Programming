# 1 set với kiểu dữ liệu hỗn hợp
set1 = {'hello', 5, (1, 5, 7)}
print(set1)  # {(1, 5, 7), 5, 'hello'}

# 2 Truy cập các phần tử trong set ( ko dùng index được )
print("\n2)")
myset = {5, 7, 6, 4}
for item in myset:
    print(item)

# 3 Thêm phần tử ( add , update )
print("\n3)")
myset = {4, 8, 7, 5}
myset.add(10)
x = 1
myset.add(x)
myset.add('hello')
print(myset)

name = {'hieu', 'hoai', 'anh', 'loc'}
name.update(['john', 'lina', 'hary', 0, 0, 0, 1, 2])  # phải để phần tử trong dấu []
print(name)  # return {'hoai', 'anh', 'loc', 'lina', 'john', 'hary', 'hieu'}

# 4 Loại bỏ phần tử ( remove, discard, pop)
# 4.1 remove
print("\n4.1)")
set2 = {'apple', 'banana', 'cherry'}
set2.remove('banana')
print(set2)
# Nếu xóa phần tử bằng remove thì trong trường hợp phần tử cần xóa không có trong set thì sẽ phát sinh lỗi.

# 4.2 discard
print("\n4.2)")
this_set = {'apple', 'watermelon', 'jack fruit'}
this_set.discard('apple')
print(this_set)
# Khi xóa bằng discard, nếu phần tử không có trong set thì sẽ không phát sinh lỗi.


# 4.3 pop ( xóa phần tử cuối cùng )
print("\n4.3)")
this_set = {"apple", "banana", "cherry"}
x = this_set.pop()
print(x)
print(this_set)

# 4.4 clear xóa toàn bộ phần tử trong set , del sẽ xóa set


# 5. Hàm đặc biệt với set
# | & - ^
# 5.1 Phép tuyển( nối hai set trong python)
print("\n5.1)")
A = {1, 2, 3, 4}
B = {3, 4, 5, 6, 7}
# 2 cách dưới sẽ cùng cho một kết quả
print(A | B)
print(A.union(B))

# 5.2 Phép hội
print("\n5.2)")
A = {1, 2, 3, 4}
B = {3, 4, 5, 6}
print(A & B)  # return {3, 4}
print(A.intersection(B))  # return {3, 4}

# 5.3 Phép trừ
print("\n5.3)")
A = {1, 2, 3, 4}
B = {3, 4, 5, 6}
print(A - B)  # return {1, 2}
print(A.difference(B))  # return {1, 2}

# 5.4 Phép đối xứng ( ngược lại với phép giao)
print("\n5.4)")
A = {1, 2, 3, 4}
B = {3, 4, 5, 6, 7, 8}

print(A ^ B) # return {1, 2, 5, 6, 7, 8}
print(A.symmetric_difference(B))  # return {1, 2, 5, 6, 7, 8}

# 6. Hàm quen thuộc khác ( giống với list)
# 6.1 Hàm sorted
print("\n6.1)")
number = {1, 2, 3, 5, 0}
print(sorted(number, reverse=True))  # return [5, 3, 2, 1, 0]# sắp xếp giảm dần
print(sorted(number, reverse=False))  # return [0, 1, 2, 3, 5]# sắp xếp tăng dần

# 6.2 Hàm sum,min,max
print("\n6.2)")
number = {1, 2, 3, 5, 0}
print(min(number))
print(max(number))
print(sum(number))
