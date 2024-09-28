package Ass2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

//    public static void displayMenu() {
//        System.out.println("Product list:");
//        System.out.println("1.1. Load data from file");
//        System.out.println("1.2. Input & insert data");
//        System.out.println("1.3. In-order traverse");
//        System.out.println("1.4. Breadth-first traverse");
//        System.out.println("1.5. In-order traverse to file");
//        System.out.println("1.6. Search by pcode");
//        System.out.println("1.7. Delete by pcode by copying");
//        System.out.println("1.8. Simply balancing");
//        System.out.println("1.9. Count number of products");
//
//        System.out.println("\nCustomer list:");
//        System.out.println("2.1. Load data from file");
//        System.out.println("2.2. Input & add to the end");
//        System.out.println("2.3. Display data");
//        System.out.println("2.4. Save customer list to file");
//        System.out.println("2.5. Search by ccode");
//        System.out.println("2.6. Delete by ccode");
//
//        System.out.println("\nOrder list:");
//        System.out.println("3.1. Input data");
//        System.out.println("3.2. Display data with total value");
//        System.out.println("3.3. Sort by pcode + ccode");
//        System.out.print("\nEnter your choice (e.g., 1.1, 2.3, 3.2): ");
//    }
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        P_Tree p_tree = new P_Tree();
//        C_List c_list = new C_List();
//        OrderingList o_list = new OrderingList();
        String fileNameProduct = "D:\\Java\\JavaProject\\CSD201\\src\\Ass2\\product.txt";
        String fileNameCustomer = "D:\\Java\\JavaProject\\CSD201\\src\\Ass2\\customer.txt";
        OrderingList t = new OrderingList();
        t.loadProduct("product.txt");
        t.loadCustomer("customer.txt");
        t.breadthProduct(); // (1)
        System.out.println("");
        t.inOrderProduct(); // (2)
        t.book("P9", "C1", 1); // not ok
        t.book("P4", "C1", 1); // ok
        t.book("P4", "C2", 1); // not ok
        t.breadthProduct(); // (3)
        System.out.println("");
        t.traverse(); // (4)

//        do {
//            displayMenu();
//            String choice = sc.nextLine();
//            switch (choice) {
//                case "11":
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    System.out.println("Breadth-First Traverse:");
//                    p_tree.breadth(p_tree.root);
//                    System.out.println("In-Order Traverse:");
//                    p_tree.inOrder(p_tree.root);
//                    break;
//                case "12":
//                    // Tìm code = 4 và sửa quantity = 2 và BR
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    p_tree.updateQuantity("4", 72);
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "13":
//                    // Xóa
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    p_tree.deleByCopy("2");
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "14":
//                    // Thêm
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    Product x = new Product("7", "H", 5, 2, 1);
//                    p_tree.addProduct(x);
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "15A":
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    // Back_up p_tree
//                    P_Tree p_tree2 = new P_Tree();
//                    p_tree2.loadProductFromFile(fileNameProduct);
//                    // Find root 3 in p_tree2 and balance so that p_tree2 is balanced subtree of root3
//                    P_Node root3 = p_tree2.search("3");
//                    p_tree2.balance(root3);
//                    // Attach p_tree2 to root3 in p_tree
//                    p_tree.replace_node(p_tree.search("3"), p_tree2.root);
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "15B":
//                    // Cân bằng cây con gốc 3
////                    p_tree.loadProductFromFile(fileNameProduct);
////                    P_Node root3 = p_tree.search("5");
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    p_tree.balance(p_tree.root);
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "1.1":
//                    p_tree.loadProductFromFile(fileNameProduct);
//                    System.out.println("Breadth-First Traverse:");
//                    p_tree.breadth(p_tree.root);
//                    System.out.println("In-Order Traverse:");
//                    p_tree.inOrder(p_tree.root);
//                    break;
//                case "1.2":
//                    Product newProd = p_tree.inputProduct();
//                    if (p_tree.addProduct(newProd)) {
//                        System.out.println("Add product successfully.");
//                    } else {
//                        System.out.println("Duplicated pcode!");
//                    }
//                    break;
//                case "1.3":
//                    p_tree.inOrder(p_tree.root);
//                    break;
//                case "1.4":
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "1.5":
//                    p_tree.inOrder_traverse_to_file(p_tree.root, fileNameProduct);
//                    break;
//                case "1.6":
//                    System.out.print("Enter pcode: ");
//                    String pcode = sc.nextLine();
//                    P_Node result = p_tree.search(pcode);
//                    if (result != null) {
//                        p_tree.visit(result);
//                    } else {
//                        System.out.println("Not found!");
//                    }
//                    break;
//                case "1.7":
//                    System.out.print("Enter pcode to delete: ");
//                    pcode = sc.nextLine();
//                    p_tree.deleByCopy(pcode);
//                    p_tree.inOrder(p_tree.root);
//                    break;
//
//                case "1.8":
//                    p_tree.balance(p_tree.root);
//                    p_tree.breadth(p_tree.root);
//                    break;
//                case "1.9":
//                    int total = p_tree.count(p_tree.root);
//                    System.out.println("Total: " + total);
//                    break;
//                case "2.1":
//                    // Gọi phương thức load data từ file cho khách hàng          
//                    c_list.loadCustomerFromFile(fileNameCustomer);
//                    c_list.displayData();
//                    break;
//                case "2.2":
//                    // Gọi phương thức input và thêm vào cuối danh sách cho khách hàng
//                    Customer newCustomer = c_list.inputCustomer();
//                    if (c_list.addCustomer(newCustomer)) {
//                        System.out.println("Add customer successfully.");
//                    } else {
//                        System.out.println("Duplicate customer ccode!");
//                    }
//                    break;
//                case "2.3":
//                    // Gọi phương thức hiển thị thông tin khách hàng
//                    c_list.displayData();
//                    break;
//                case "2.4":
//                    // Gọi phương thức lưu danh sách khách hàng vào file
//                    c_list.saveToFile(fileNameCustomer);
//                    break;
//                case "2.5":
//                    // Gọi phương thức tìm kiếm khách hàng theo ccode
//                    System.out.print("Enter ccode to search: ");
//                    String ccode = sc.nextLine();
//                    if (c_list.search(ccode) != null) {
//                        System.out.println("Customer " + ccode + " found:");
//                        c_list.visit(c_list.search(ccode));
//                        System.out.println("");
//                    } else {
//                        System.out.println("Customer " + ccode + " not found!");
//                    }
//                    break;
//                case "2.6":
//                    // Gọi phương thức xóa khách hàng theo ccode
//                    System.out.print("Enter ccode to delete: ");
//                    ccode = sc.nextLine();
//                    c_list.dele(ccode);
//                    break;
//                case "3.1":
//                    // Gọi phương thức nhập thông tin đơn hàng
//                    o_list.loadFiles(fileNameProduct, fileNameCustomer);
//                    o_list.sell("P1", "C3", 3);
//                    break;
//                case "3.2":
//                    // Gọi phương thức hiển thị thông tin đơn hàng với tổng giá trị
//                    o_list.displayData();
//                    break;
//                case "3.3":
//                    // Gọi phương thức sắp xếp danh sách đơn hàng theo pcode + ccode
//                    o_list.sortByPcodeCcode();
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        } while (true);
    }
}
