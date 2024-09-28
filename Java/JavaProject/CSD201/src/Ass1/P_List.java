package Ass1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P_List {

    Scanner sc = new Scanner(System.in);
    P_Node head, tail;

    public P_List() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Product x) {
        P_Node q = new P_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(P_Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        P_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void remove(P_Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        P_Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        P_Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    // 1.1 Load product data from file
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
                    this.addLast(x);
                }
                line = br.readLine(); // Đọc dòng tiếp theo
            }
            br.close();
//            System.out.println("Load file successfully !");
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found !");
        }
    }

    // 1.2  Input & add new product to the end
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
        P_Node p = head;
        while (p != null) {
            if (p.info.pcode.equals(x.pcode)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public boolean addProduct(Product x) {
        // Check xem sản phẩm có phù hợp không rồi add
        if (!this.check_duplicate_pcode(x)) {
            this.addLast(x);
            return true;
        }
        return false;

    }

    // 1.3 Display data
    void displayData() {
        P_Node p = head;
        while (p != null) {
            System.out.printf("(%3s,%3s,%3d,%3d,%3.0f)\n",
                    p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled, p.info.price);
            p = p.next;
        }
    }

    // 1.4 Save product data to file
    public boolean saveToFile(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            P_Node p = head;
            while (p != null) {
                String content = String.format("%5s |  %10s |  %8d |  %5d |  %6.1f |  %6.1f\n",
                        p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled,
                        p.info.price, p.info.price * p.info.saled);
                pw.write(content);
                p = p.next;
            }
            pw.close();
            System.out.println("Saved successfully!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 1.5 Search by pcode
    P_Node search(String xCode) {
        P_Node p = head;
        while (p != null) {
            if (p.info.pcode.equals(xCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // 1.6 Delete by pcode
    void dele(String xCode) {
        P_Node q = search(xCode);
        if (q == null) {
            return;
        } else if (this.isEmpty()) {
            System.out.println("Empty product list, cannot delete!");
        } else {
            remove(q);
            System.out.println("Product " + xCode + " deleted.");
        }

    }

    // 1.7 Sort by pcode
    void sortBySaled() { // BubbleSort by saled
        P_Node pi, pj;
        Product temp;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.info.saled < pi.info.saled) {
                    // Swap products
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }

    // 1.8. Add after position  k
    void insertAfter(P_Node q, Product x) {
        if (isEmpty() || q == null) {
            return;
        }
        P_Node q1 = q.next;
        P_Node p = new P_Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    P_Node pos(int k) {
        int i = 0;
        P_Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void add_after_pos(int k) {
        P_Node q = pos(k);
        if (q == null) {
            return;
        } else {
            Product x = this.inputProduct();
            if (!this.check_duplicate_pcode(x)) {
                insertAfter(q, x);
            } else {
                System.out.println("Duplicate pcode!");
            }
        }

    }

    // 1.9 Delete the node after the node having code = xCode
    void deleteNodeAfter(String xCode) {
        P_Node p = search(xCode);
        if (p == null) {
            return;
        } else if (p.next == null) {
            System.out.println("There is no product after " + xCode + "!");
            return;
        } else {
            remove(p.next);
            System.out.println("Product " + xCode + " deleted.");
        }
    }

    // 1.10 
    void updateQuantity(String pcode, int newQuantity) {
        P_Node p = search(pcode);
        if (p != null) {
            p.info.quantity = newQuantity;
            System.out.println("Quantity of product " + pcode + " updated.");
        } else {
            System.out.println("Product " + pcode + " not found!");
        }
    }

    // 1.14
}
