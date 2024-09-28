def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        i = j = k = 0

        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

    return arr


arr = [5, 8, 43, 67, 9, 32]
print(merge_sort(arr))
# Hàm merge_sort nhận một mảng số nguyên arr và sắp xếp nó bằng cách sử dụng thuật toán sắp xếp trộn.
#
# Các bước của thuật toán:
#
# Kiểm tra độ dài của mảng đầu vào, nếu nó lớn hơn 1, tiếp tục.
# Chia mảng đầu vào thành hai nửa.
# Đệ quy sắp xếp từng nửa.
# Trộn hai nửa lại với nhau theo thứ tự tăng dần.
# Trả về mảng đã sắp xếp.
# Với cách triển khai này, độ phức tạp thời gian trung bình của thuật toán sắp xếp trộn là O(nlogn).
