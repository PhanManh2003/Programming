class HashTable:
    def __init__(self, size=7):
        self.data_map = [None] * size

    def __hash(self, key):
        my_hash = 0
        for letter in key:
            my_hash = (my_hash + ord(letter) + 23) % len(self.data_map)
        return my_hash

    def print_table(self):
        for i, val in enumerate(self.data_map):
            print(i, ": ", val)

    def set_item(self, key, value):
        index = self.__hash(key)
        if self.data_map[index] is None:
            self.data_map[index] = []
        # Check if the key already exists in the bucket
        for item in self.data_map[index]:
            if item[0] == key:
                item[1] = value  # Update the value if the key already exists
                return  # Exit the method after updating the value
        # If the key doesn't exist, add it to the bucket
        self.data_map[index].append([key, value])

    def get_item(self, key):
        index = self.__hash(key)
        if self.data_map[index] is not None:
            for item in self.data_map[index]:
                if item[0] == key:
                    return item[1]  # Return the value if the key is found
        return None

    def keys(self):
        all_keys = []
        for i in range(len(self.data_map)):
            if self.data_map[i] is not None:
                for j in range(len(self.data_map[i])):
                    all_keys.append(self.data_map[i][j][0])
        return all_keys

a = HashTable()

a.set_item('bolts', 1400)
a.set_item('bolts', 1200)
a.set_item('washers', 50)
a.set_item('lumber', 70)

print(a.keys())
print(a.get_item('washers'))

a.print_table()
