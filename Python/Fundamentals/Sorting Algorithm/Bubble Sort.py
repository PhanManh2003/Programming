# Bubble Sort is the simplest sorting algorithm that works by
# repeatedly swapping the adjacent elements  if they are in the wrong order.

# This algorithm is not suitable for large data sets
# as its average and worst-case time complexity is quite high with O(n) = n^2

def bubbleSort(a):  # Input: arr[] = [5, 1, 4, 2, 8]
    n = len(a)

    # Traverse through all array elements
    for i in range(n):

        # Last i elements are already in place
        for j in range(0, n - i - 1):

            # traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # than the next element
            if a[j] > a[j + 1]:
                a[j], a[j + 1] = a[j + 1], a[j]


# Driver code to test above
if __name__ == "__main__":
    a = [5, 1, 4, 2, 8]

    bubbleSort(a)

    print("Sorted array is:")
    for i in range(len(a)):
        print("%d" % a[i], end=" ")
