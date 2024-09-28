# 1, Tạo ra cây T
# 2, Cho người dùng nhập liên tục các số nguyên (khác nhau): mỗi số sẽ lưu trữ vào cây T
# 3, In ra cây T theo thứ tự: - trước , - sau , - giữa
# 4, Cho người dùng nhập N vào thông báo [có/không] có giá trị đó trên cây.

# 1, Tạo ra cây T
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def insert(root, data):  # dùng đệ quy
    if root is None:
        return Node(data)
    if data < root.data:
        root.left = insert(root.left, data)
    else:
        root.right = insert(root.right, data)
    return root  # Bản chất:  tree, linkedlist dc gán bằng 1 node (tree gán với 1 root , linkedlist gán với 1 head)


def preorder_traversal(root):
    if root:
        print(root.data, end=' ')
        preorder_traversal(root.left)  # đệ quy đến  root.left bằng None thì chuyển sang preorder_traversal(root.right)
        preorder_traversal(root.right)  # đệ quy đến  root.right bằng None thì kết thúc in


def inorder_traversal(root):
    if root:
        inorder_traversal(root.left)
        print(root.data, end=' ')
        inorder_traversal(root.right)


def postorder_traversal(root):
    if root:
        postorder_traversal(root.left)
        postorder_traversal(root.right)
        print(root.data, end=' ')


def search(root, data):
    if root is None or root.data == data:
        return root
    if root.data < data:
        return search(root.right, data)
    return search(root.left, data)


T = None

# 2, Cho người dùng nhập liên tục các số nguyên (khác nhau): mỗi số sẽ lưu trữ vào cây T
while True:
    value = input("Nhập số nguyên (nhập 'q' để dừng): ")
    if value == 'q':
        break
    try:
        value = int(value)
        if search(T, value) is not None:
            print("Giá trị đã tồn tại trên cây.")
            continue
        T = insert(T, value)
    except ValueError:
        print("Giá trị không hợp lệ.")

# 3, In ra cây T theo thứ tự: - trước , - sau , - giữa
print("\nDuyệt cây theo thứ tự trước (preorder):")
preorder_traversal(T)
print("\nDuyệt cây theo thứ tự sau (postorder):")
postorder_traversal(T)
print("\nDuyệt cây theo thứ tự giữa (inorder):")
inorder_traversal(T)

# 4, Cho người dùng nhập N vào thông báo [có/không] có giá trị đó trên cây.
value_to_search = input("\nNhập giá trị bạn muốn tìm kiếm trên cây: ")
result = search(T, int(value_to_search))
if result is not None:
    print("Giá trị", value_to_search, "được tìm thấy trên cây.")
else:
    print("Giá trị", value_to_search, "không tồn tại trên cây.")
