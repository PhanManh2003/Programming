# Cú pháp hàm map() trong Python: map(function, iterable, ...)
# Các tham số của hàm map()
# function: Hàm thực thi cho từng phần tử trong iterable.
# iterable: một list, tuple, dictionary... muốn duyệt.
# Bạn có thể truyền nhiều iterable cho hàm map().

# Giá trị trả về từ map() được gọi là map object. Đối tượng này có thể được truyền vào các hàm list()
# (để tạo list trong Python), hay set() (để tạo một set các phần tử mới)...

def binhphuong(n):
    return n * n


number = (2, 4, 6, 8)
ketqua = map(binhphuong, number)

# chuyen map object thanh list
print(tuple(ketqua))
