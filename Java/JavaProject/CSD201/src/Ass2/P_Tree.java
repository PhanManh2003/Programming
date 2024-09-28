package Ass2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class P_Tree {

    Scanner sc = new Scanner(System.in);
    P_Node root;

    P_Tree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void visit(P_Node p) {
        if (p != null) {
            System.out.printf("%2s ,%2s ,%2d ,%2d ,%2.0f\n",
                    p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled, p.info.price);
        }
    }
// insert
    // cần 2 biến P_Node f, p trong đó p để làm điều kiện duyệt cây và f để thêm x vô cây

    void insert(Product x) {
        if (isEmpty()) {
            root = new P_Node(x);
            return;
        }
        P_Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.pcode.equals(x.pcode)) {
                System.out.println("The key " + x + " already exists!");
                return;
            }
            f = p;
            if (x.pcode.compareToIgnoreCase(p.info.pcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.pcode.compareToIgnoreCase(f.info.pcode) < 0) {
            f.left = new P_Node(x);
        } else {
            f.right = new P_Node(x);
        }

    }

    void insertMany(ArrayList<Product> productList) {
        for (Product product : productList) {
            insert(product);
        }
    }

    // Duyệt cây = DFS
    void preOrder(P_Node p) {
        if (p == null) { // when to stop
            return;
        }
        visit(p); // one step
        preOrder(p.left); // smaller problem
        preOrder(p.right);
    }

    void postOrder(P_Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    // Search từ 1 nút p để tìm x
    P_Node search(P_Node p, String pcode) {
        if (p == null) {
            return (null);
        }
        if (p.info.pcode.equals(pcode)) {
            return (p);
        }
        if (pcode.compareTo(p.info.pcode) < 0) {
            return (search(p.left, pcode));
        } else {
            return (search(p.right, pcode));
        }
    }

    // Balance
    // Duyệt tree bằng inorder rồi đưa vào mảng
    // Sort mảng ( duyệt bằng inorder thì auto mảng đc sort)
    // clear tree
    // dùng balance() để thêm node từ mảng vào cây mới
    void inOrder(ArrayList<Product> t, P_Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Product> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Product n = t.get(k);

        insert(n);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void balance(P_Node p) {
        ArrayList<Product> t = new ArrayList<>();
        inOrder(t, p);
        int n = t.size();
        this.clear();
        balance(t, 0, n - 1);
    }

    void replace_node(P_Node p_old, P_Node p_new) {
        P_Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.pcode.equals(p_old.info.pcode)) {
                break;
            }
            f = p;
            if (p_old.info.pcode.compareTo(p.info.pcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f != null) {
            if (p == f.left) {
                f.left = p_new;
            } else {
                f.right = p_new;
            }
        }
    }

    // Rotation
//    rotateRight: rotate the node Par to right about its left child Ch
//      - Ch become new root of the subtree
//	- left subtree of Par becomes Right subtree of Ch  
//	- right subtree of Ch becomes Par subtree 
    P_Node rotateRight(P_Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        P_Node q = p.left; // q là con trái của p
        p.left = q.right;
        q.right = p;
        return (q);
    }

    P_Node rotateLeft(P_Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        P_Node q = p.right;
        p.right = q.left;
        q.left = p;
        return (q);
    }

    // height
    int height(P_Node p) {
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
    int count(P_Node p) {
        if (p == null) {
            return 0;
        }
        int a, b, c;
        a = count(p.left);
        b = count(p.right);
        c = a + b + 1;
        return c;
    }

//--------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------
    //1.1.  LOAD DATA FROM FILE
    public void loadProductFromFile(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while ((line != null)) {
                String[] arr = line.split("\\|");
                if (arr.length >= 5) {
                    String pcode = arr[0].trim();
                    String pro_name = arr[1].trim();
                    int quantity = Integer.parseInt(arr[2].trim());
                    int saled = Integer.parseInt(arr[3].trim());
                    double price = Double.parseDouble(arr[4].trim());
                    Product x = new Product(pcode, pro_name, quantity, saled, price);
                    this.insert(x);
                }
                line = br.readLine(); // Đọc dòng tiếp theo
            }
            br.close();
//            System.out.println("Load file successfully !");
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found !");
        }
    }

    // 1.2. INPUT AND INSERT PRODUCT
    public Product inputProduct() {
        System.out.print("Enter pcode: ");
        String pcode = sc.nextLine();
        System.out.print("Enter pro_name: ");
        String pro_name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        int saled;
        do {
            System.out.print("Enter saled from 0-" + quantity + ": ");
            saled = Integer.parseInt(sc.nextLine());
        } while (saled > quantity);
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        Product x = new Product(pcode, pro_name, quantity, saled, price);
        return x;
    }

    public boolean check_duplicate_pcode(Product x) {
        P_Node p = root;
        while (p != null) {
            if (p.info.pcode.equals(x.pcode)) {
                return true;
            }
            if (x.pcode.compareToIgnoreCase(p.info.pcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return false;
    }

    public boolean addProduct(Product x) {
        if (!this.check_duplicate_pcode(x)) {
            this.insert(x);
            return true;
        }
        return false;

    }

    // 1.3 INORDER TRAVERSE
    void inOrder(P_Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    // 1.4. BFS TRAVERSE
    // Duyệt cây = BFS từ node bất kì
    void breadth(P_Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        P_Node r;
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

    // 1.5. INORDER TRAVERSE TO FILE
//    void inOrder_traverse_to_file(P_Node p, String fileName) {
//        if (p == null) {
//            return;
//        }
//        inOrder_traverse_to_file(p.left, fileName);
//        saveProduct(p, fileName);
//        inOrder_traverse_to_file(p.right, fileName);
//    }
//
//    public void saveProduct(P_Node p, String fileName) {
//        try {
//            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
//            String content = String.format("%3s |  %3s |  %3d |  %3d | %3.0f\n",
//                    p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled,
//                    p.info.price);
//            pw.write(content);
//            pw.close();
//            System.out.println("Saved successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    void inOrder_traverse_to_file(P_Node root, String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, false))) {
            // Start fresh by overwriting the file
            inOrder_traverse_to_file(root, pw);  // Pass the PrintWriter to the recursive function
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void inOrder_traverse_to_file(P_Node p, PrintWriter pw) {
        if (p == null) {
            return;
        }
        inOrder_traverse_to_file(p.left, pw);  // Recur on left child
        saveProduct(p, pw);                     // Save current node
        inOrder_traverse_to_file(p.right, pw); // Recur on right child
    }

    void saveProduct(P_Node p, PrintWriter pw) {
        String content = String.format("%3s | %3s | %3d | %3d | %3.0f\n",
                p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled, p.info.price);
        pw.write(content);  // Write the product data
        pw.flush();  // Ensure data is written to the file
    }

    // 1.6. SEARCH BY PCODE : Search toàn bộ cây để tìm Node chứa pcode
    P_Node search(String pcode) {
        P_Node p = root;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                return p;
            }
            if (pcode.compareTo(p.info.pcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    // Update quantity
    void updateQuantity(String pcode, int newQuantity) {
        P_Node p = search(pcode);
        if (p != null) {
            p.info.quantity = newQuantity;
            System.out.println("Quantity of product " + pcode + " updated.");
        } else {
            System.out.println("Product " + pcode + " not found!");
        }
    }

    // 1.7. DELETE BY PCODE BY COPYING
    void deleByCopy(String pcode) {
        // Find node p that contain x
        P_Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                break;
            }
            f = p;
            if (pcode.compareTo(p.info.pcode) < 0) {
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
            P_Node q = p.left; // p is the root of the left-son
            P_Node frp, rp;
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

}
