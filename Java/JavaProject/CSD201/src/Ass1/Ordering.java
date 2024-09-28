package Ass1;

import java.io.IOException;
import java.util.Scanner;

public class Ordering {

    Scanner sc = new Scanner(System.in);
    O_Node head, tail;

    P_List p_list = new P_List();
    C_List c_list = new C_List();

    public Ordering() {
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

    public void loadFiles(String filename1, String filename2) throws IOException {
        String fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Ass1\\" + filename1;
        this.p_list.loadProductFromFile(fileName);
        fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Ass1\\" + filename2;
        this.c_list.loadCustomerFromFile(fileName);       
    }

    // 3.1 Input data
   public void sell(String pcode, String ccode, int quantity) {
    // Check if pcode and ccode exist in the respective lists
    Product p = p_list.search(pcode).info;
    Customer c = c_list.search(ccode).info;

    if (p == null || c == null) {
        System.out.println("Product code or customer code not found. Data not accepted.");
        return;
    }

    // Check if both pcode and ccode are found in the order list
    O_Node temp = head;
    while (temp != null) {
        if (temp.info.pcode.equals(pcode) && temp.info.ccode.equals(ccode)) {
            System.out.println("Data not accepted. Duplicate order found.");
            return;
        }
        temp = temp.next;
    }

    // Check if product is exhausted
    if (p.saled == p.quantity) {
        System.out.println("Not successful because quantity=selled");
        return;
    }

    // If pcode and ccode found in products and customers lists
    if (p.saled < p.quantity) {
        if (quantity <= p.quantity - p.saled) {
            // Data is accepted and added to the end of the Order list
            Order x = new Order(pcode, ccode, quantity);
            addLast(x);
            p.saled += quantity; // Update the sold quantity
            System.out.println("Successful");
        } else {
            System.out.println("Not successful because quantity exceeds the product number.");
        }
    }
}

 
    // 3.2 Display ordering data
    void displayProduct() {
        this.p_list.displayData();
    }

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
