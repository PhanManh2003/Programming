package Ass2;

import java.io.IOException;
import java.util.Scanner;

public class OrderingList {

    Scanner sc = new Scanner(System.in);
    O_Node head, tail;

    P_Tree p_tree = new P_Tree();
    C_List c_list = new C_List();

    public OrderingList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Order x) {
        O_Node q = new O_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(O_Node p) {
        if (p != null) {
            System.out.printf("%3s ,%3s ,%3d\n",
                    p.info.pcode, p.info.ccode, p.info.quantity);
        }
    }

    void traverse() {
        O_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    public void loadProduct(String filename) throws IOException {
        String fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Ass2\\" + filename;
        this.p_tree.loadProductFromFile(fileName);
    }

    public void loadCustomer(String filename) throws IOException {
        String fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Ass2\\" + filename;
        this.c_list.loadCustomerFromFile(fileName);
    }

    public void loadFiles(String filename1, String filename2) throws IOException {
        this.p_tree.loadProductFromFile(filename1);
        this.c_list.loadCustomerFromFile(filename2);
    }

    public void breadthProduct() {
        this.p_tree.breadth(p_tree.root);
    }

    public void inOrderProduct() {
        this.p_tree.inOrder(p_tree.root);
    }

    // 3.1 Input data
    public void book(String pcode, String ccode, int quantity) {
        // Check if pcode and ccode exist in the respective lists
        P_Node p = p_tree.search(pcode);
        C_Node c = c_list.search(ccode);

        if (p == null || c == null) {
            System.out.println("not ok");
            return;
        }

        // Check if both pcode and ccode are found in the order list
        O_Node temp = head;
        while (temp != null) {
            if (temp.info.pcode.equals(pcode) && temp.info.ccode.equals(ccode)) {
                System.out.println("not ok");
                return;
            }
            temp = temp.next;
        }

        // Check if product is exhausted
        if (p.info.saled == p.info.quantity) {
            System.out.println("not ok");
            return;
        }

        // If pcode and ccode found in products and customers lists
        if (p.info.saled < p.info.quantity) {
            if (quantity <= p.info.quantity - p.info.saled) {
                // Data is accepted and added to the end of the Order list
                Order x = new Order(pcode, ccode, quantity);
                addLast(x);
                p.info.saled += quantity; // Update the sold quantity
                System.out.println("ok");
            } else {
                System.out.println("not ok");
            }
        }
    }

    // 3.2 Display ordering data
    void displayOrdering() {
        O_Node p = head;
        while (p != null) {
            System.out.printf("(%3s,%3s,%3d)\n", p.info.pcode, p.info.ccode, p.info.quantity);
            p = p.next;
        }
    }

    void displayData() {
        System.out.println("pcode  |  ccode  |  quantity");
        System.out.println("-----------------------------");
        O_Node p = head;
        while (p != null) {
            System.out.printf("%5s |  %5s |  %8d\n", p.info.pcode, p.info.ccode, p.info.quantity);
            p = p.next;
        }
    }

    // 3.3 Sort by pcode + ccode
    void sortByPcodeCcode() {
        // Bubble sort by pcode + ccode
        if (head == null) {
            return;
        }
        O_Node pi, pj;
        Order temp;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if ((pi.info.pcode + pi.info.ccode).compareTo(pj.info.pcode + pj.info.ccode) > 0) {
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
    }
}
