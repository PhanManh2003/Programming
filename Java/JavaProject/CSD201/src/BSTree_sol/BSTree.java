package BSTree_sol;

import java.util.*;

/*
Có 2 cách duyệt cây đó là : Depth-First Search(pre,in,post) ,Breadth-First Search, 
DFS có thể được triển khai bằng đệ quy hoặc dùng Stack nhưng đệ quy đc dùng nhiều nhất
Cách tìm kiếm trên cây hiệu quả nhất : binary search
 */
public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }
// insert
    // cần 2 biến Node f, p trong đó p để làm điều kiện duyệt cây và f để thêm x vô cây

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exists!");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    // Duyệt cây = BFS từ node bất kì
    void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    // Duyệt cây = DFS
    void preOrder(Node p) {
        if (p == null) { // when to stop
            return;
        }
        visit(p); // one step
        preOrder(p.left); // smaller problem
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    // Search từ 1 nút p để tìm x
    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info == x) {
            return (p);
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    // Search toàn bộ cây để tìm x
    Node search(int x) {
        Node p = root;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    // Delete by Copy
    void deleByCopy(int x) {
        // Find node p that contain x
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }

        // p is a leaf-node        
        if (p.left == null && p.right == null) {
            if (f == null) {  // p==root và p.info = x
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        // p has left-son only
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        // p has right-son only
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left; // p is the root of the left-son
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right-most node
            p.info = rp.info;
            if (frp == null) { // q không có con phải
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

    // Balance
    // Duyệt tree bằng inorder rồi đưa vào mảng
    // Sort mảng ( duyệt bằng inorder thì auto mảng đc sort)
    // clear tree
    // dùng balance() để thêm node từ mảng vào cây mới
    void inOrder(ArrayList<Integer> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Integer> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        int x = t.get(k);
        insert(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void balance() {
        ArrayList<Integer> t = new ArrayList<Integer>();
        inOrder(t, root);
        int n = t.size();
        clear();
        balance(t, 0, n - 1);
    }

    // Rotation
//    rotateRight: rotate the node Par to right about its left child Ch
//      - Ch become new root of the subtree
//	- left subtree of Par becomes Right subtree of Ch  
//	- right subtree of Ch becomes Par subtree 
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left; // q là con trái của p
        p.left = q.right;
        q.right = p;
        return (q);
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return (q);
    }

    // height
    int height(Node p) {
        if (p == null) {
            return 0;
        }
        int a, b, c;
        a = height(p.left);
        b = height(p.right);
        c = (a > b) ? a : b;
        return c + 1;
    }

    // count
    int count(Node p) {
        if (p == null) {
            return 0;
        }
        int a, b, c;
        a = count(p.left);
        b = count(p.right);
        c = a + b + 1;
        return c;
    }
}
