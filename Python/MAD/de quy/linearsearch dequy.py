# HE172481 - AI1805
def linear_search_recursive(arr, target, index=0):
    if index >= len(arr):
        return -1

    # Base case: the target element is found at the current index
    if arr[index] == target:
        return index

    # Recursive case: continue searching for the target element in the remaining part of the array
    return linear_search_recursive(arr, target, index + 1)


arr = [4, 5, 6, 7, 2, 3]
target = 6
print(linear_search_recursive(arr, target))
