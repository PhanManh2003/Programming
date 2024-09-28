# Bất cứ node nào cũng là instance của 1 class gồm 2 thuộc tính chính: value và pointer !!
class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


# Bản chất: nối node và đặt lại head, tail

class LinkedList:  # 10 phương thức ko tính init
    def __init__(self, value):
        new_node = Node(value)
        self.head = new_node  # biến self.head là 1 thực thể, ở đây là 1 node
        self.tail = new_node
        self.length = 1

    def print_list(self):
        temp = self.head
        while temp is not None:
            print(temp.value)
            temp = temp.next

    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node  # để nối
            self.tail = new_node
        self.length += 1
        return True

    def pop(self):
        if self.length == 0:
            return None
        temp = self.head
        pre = self.head
        while temp.next:
            pre = temp
            temp = temp.next
        self.tail = pre
        self.tail.next = None
        self.length -= 1
        if self.length == 0:
            self.head = None
            self.tail = None
        return temp

    def prepend(self, value):  # add new node to the beginning.
        new_node = Node(value)
        if self.length == 0:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.length += 1
        return True

    def pop_first(self):
        if self.length == 0:
            return None
        temp = self.head
        if self.length == 1:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
            temp.next = None
        self.length -= 1
        if self.length == 0:
            self.tail = None
        return temp

    def get(self, index):
        if index < 0 or index >= self.length:
            return None
        temp = self.head
        for _ in range(index):
            temp = temp.next
        return temp

    def set_value(self, index, value):
        temp = self.get(index)
        if temp:
            temp.value = value
            return True
        return False

    def insert(self, index, value):
        if index < 0 or index > self.length:
            return False
        if index == 0:
            return self.prepend(value)
        if index == self.length:
            return self.append(value)
        new_node = Node(value)
        temp = self.get(index - 1)
        new_node.next = temp.next
        temp.next = new_node
        self.length += 1
        return True

    def remove(self, index):
        # The method takes an index parameter indicating the position of the node to be removed.
        if index < 0 or index >= self.length:
            return None
        if index == 0:
            return self.pop_first()
        if index == self.length - 1:
            return self.pop()
        prev = self.get(index - 1)
        temp = prev.next
        prev.next = temp.next
        temp.next = None
        self.length -= 1
        return temp

    def reverse(self):
        temp = self.head
        self.head = self.tail
        self.tail = temp
        after = temp.next
        before = None
        for _ in range(self.length):
            after = temp.next
            temp.next = before
            before = temp
            temp = after

    # Các phương thức khác (5): count, max, min , sum, avg ( chú ý không nên dùng for để lặp )
    def count(self):
        count = 0
        temp = self.head
        while temp:
            count += 1
            temp = temp.next
        return count

    def max(self):
        if self.length == 0:
            return None
        max_value = self.head.value
        temp = self.head.next
        while temp:
            if temp.value > max_value:
                max_value = temp.value
            temp = temp.next
        return max_value

    def min(self):
        if self.length == 0:
            return None
        min_value = self.head.value
        temp = self.head.next
        while temp:
            if temp.value < min_value:
                min_value = temp.value
            temp = temp.next
        return min_value

    def sum(self):
        if self.length == 0:
            return None

        total = 0
        temp = self.head
        while temp:
            total += temp.value
            temp = temp.next
        return total

    def avg(self):
        if self.length == 0:
            return None

        size = self.count()
        total = self.sum()
        avg = total / size
        return avg


mine = LinkedList(1)
mine.append(3)
mine.append(5)
mine.append(7)

a = mine.count()
print(f"Number of Nodes: {a}")

b = mine.max()
print(f"Max value is: {b}")

c = mine.min()
print(f"Min value is: {c}")

d = mine.sum()
print(f"The sum of values is: {d}")

e = mine.avg()
print(f"The average value is: {e}")

mine.print_list()
