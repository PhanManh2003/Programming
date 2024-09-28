def selection_sort(array: list):
    for i in range(len(array)):
        min_index = i
        for j in range(i + 1, len(array)): # đi tìm phần tử nhỏ nhất của dãy rồi tách ra thành sorted array
            if array[j] < array[min_index]:
                min_index = j
        array[i], array[min_index] = array[min_index], array[i]
    return array


array = [1, 5, 6, 4, 2, 15, 11]
print(selection_sort(array))
