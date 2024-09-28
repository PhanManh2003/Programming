# The algorithm maintains two subarrays in a given array. O(n) = n^2
# . The subarray which already sorted.
# . The remaining subarray was unsorted.
import sys

a = [64, 25, 12, 22, 11]
n = len(a)
# Traverse through all array elements
for i in range(n):

    # Find the minimum element in remaining unsorted array
    min_idx = i
    for j in range(i + 1, n):
        if a[min_idx] > a[j]:
            min_idx = j

    # Swap the found minimum element with
    # the first element
    a[i], a[min_idx] = a[min_idx], a[i]

# Driver code to test above
print("Sorted array")
for i in range(n):
    print("%d" % a[i], end=" , ")
