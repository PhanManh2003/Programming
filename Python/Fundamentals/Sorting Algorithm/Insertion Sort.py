# Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards.
# The aay is virtually split into a sorted and an unsorted part.
# Values from the unsorted part are picked and placed at the correct position in the sorted part.
# O(n^2)
def insertionSort(a):
    # Traverse through 1 to len(a)
    for i in range(1, len(a)):

        key = a[i]

        # Move elements of a[0..i-1], that are
        # greater than key, to one position ahead
        # of their current position
        j = i - 1
        while j >= 0 and key < a[j]:
            a[j + 1] = a[j]
            j -= 1
        a[j + 1] = key


# Driver code to test above
a = [12, 11, 13, 5, 6]
insertionSort(a)
for i in range(len(a)):
    print("% d" % a[i])
