package Ass2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_List {

    Scanner sc = new Scanner(System.in);
    C_Node head, tail;

    public C_List() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Customer x) {
        C_Node q = new C_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(C_Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        C_Node p = head;
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

    void remove(C_Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        C_Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;
        }
        C_Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    // 2.1 Load customer data from file
    public void loadCustomerFromFile(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while ((line != null)) {
                String[] arr = line.split("\\|");
                if (arr.length >= 3) {
                    String ccode = arr[0].trim();
                    String cus_name = arr[1].trim();
                    String phone = arr[2].trim();
                    Customer x = new Customer(ccode, cus_name, phone);
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

    // 2.2  Input & add new customer to the end
    public Customer inputCustomer() {
        System.out.print("Enter ccode: ");
        String ccode = sc.nextLine();
        System.out.print("Enter cus_name: ");
        String cus_name = sc.nextLine();
        String phone;
        boolean validPhone = false;
        do {
            System.out.print("Enter phone number: ");
            phone = sc.nextLine();
            // Validate that the phone number contains only digits
            if (phone.matches("[0-9]+")) {
                validPhone = true;
            } else {
                System.out.println("Phone number must contain digits only. Please try again.");
            }
        } while (!validPhone);
        Customer x = new Customer(ccode, cus_name, phone);
        return x;
    }

    public boolean check_duplicate_ccode(Customer x) {
        C_Node p = head;
        while (p != null) {
            if (p.info.ccode.equals(x.ccode)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public boolean addCustomer(Customer x) {
        // Check xem khách hàng có phù hợp không rồi add
        if (!this.check_duplicate_ccode(x)) {
            this.addLast(x);
            return true;
        }
        return false;

    }

    // 2.3 Display data
    void displayData() {
        System.out.println("ccode  |       Cus_name      |     Phone     ");
        System.out.println("----------------------------------------");
        C_Node p = head;
        while (p != null) {
            System.out.printf("%5s |  %20s |  %11s\n",
                    p.info.ccode, p.info.cus_name, p.info.phone); // Add '\n' at the end
            p = p.next;
        }
    }

    // 2.4 Save customer data to file
    public boolean saveToFile(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            C_Node p = head;
            while (p != null) {
                String content = String.format("%5s |  %20s |  %11s\n",
                        p.info.ccode, p.info.cus_name, p.info.phone);
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

    // 2.5 Search by ccode
    C_Node search(String xCode) {
        C_Node p = head;
        while (p != null) {
            if (p.info.ccode.equals(xCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // 2.6 Delete by ccode
    void dele(String xCode) {
        C_Node q = search(xCode);
        if (q == null) {
            return;
        } else if (this.isEmpty()) {
            System.out.println("Empty customer list, cannot delete!");
        } else {
            remove(q);
            System.out.println("Customer " + xCode + " deleted.");
        }
    }

}
