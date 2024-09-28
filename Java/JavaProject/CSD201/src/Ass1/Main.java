package Ass1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

//    public static void displayMenu() {
//        System.out.println("Product list:");
//        System.out.println("1.1. Load data from file");
//        System.out.println("1.2. Input & add to the end");
//        System.out.println("1.3. Display data");
//        System.out.println("1.4. Save product list to file");
//        System.out.println("1.5. Search by pcode");
//        System.out.println("1.6. Delete by pcode");
//        System.out.println("1.7. Sort by pcode");
//        System.out.println("1.8. Add after position k");
//        System.out.println("1.9. Delete the node after the node having code = xCode");
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
        Ordering t = new Ordering();

        t.loadFiles("product.txt", "customer.txt");
        t.sell("P1", "C1", 1); // Successful
        t.sell("P1", "C2", 1); // Not successful because quantity=selled
        t.sell("P2", "C2", 2); // Successful
        t.displayProduct();
        t.displayOrdering();
        System.out.println();
        /* OUTPUT
        (P1, A, 3, 3, 1)
        (P2, B, 9, 4, 1)
        (P3, C, 5, 4, 1)

        (P1, C1, 1)
        (P2, C2, 2)
         */

//        Scanner sc = new Scanner(System.in);
//        do {
//            displayMenu();
//            String choice = sc.nextLine();
//            switch (choice) {
//                case "11":
//                    // Gọi phương thức load data từ file cho sản phẩm
//                    // D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\product1.txt
//                    String fileName;
//                    fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\product1.txt";
//                    p_list.loadProductFromFile(fileName);
//                    p_list.displayData();
//                    break;
//                case "14":
//                    // Allow a user to add new information about a product. After 
//                    // checking validation of data (including that the pcode could not be duplicated), 
//                    //the product is added to the end of the list.
//                    Product newProduct = new Product("5", "F", 3, 2, 1);
//                    if (p_list.addProduct(newProduct)) {
//                        System.out.println("Add product successfully.");
//                    } else {
//                        System.out.println("Duplicate product pcode!");
//                    }
//                    p_list.displayData();
//                    break;
//                case "1.3":
//                    // Gọi phương thức hiển thị thông tin sản phẩm
//                    p_list.displayData();
//                    break;
//                case "1.4":
//                    // Gọi phương thức lưu danh sách sản phẩm vào file
//                    System.out.print("Enter file name: ");
//                    fileName = sc.nextLine();
//                    p_list.saveToFile(fileName);
//                    break;
//                case "1.5":
//                    // Gọi phương thức tìm kiếm sản phẩm theo pcode
//                    System.out.print("Enter pcode to search: ");
//                    String pcode = sc.nextLine();
//                    if (p_list.search(pcode) != null) {
//                        System.out.println("Product " + pcode + " found:");
//                        p_list.visit(p_list.search(pcode));
//                        System.out.println("");
//                    } else {
//                        System.out.println("Product " + pcode + " not found!");
//                    }
//                    break;
//                case "12":
//                    // Gọi phương thức xóa sản phẩm theo pcode
//                    p_list.dele("1");
//                    p_list.displayData();
//                    break;
//                case "15":
//                    // Gọi phương thức sắp xếp danh sách sản phẩm theo pcode
//                    p_list.sortBySaled();
//                    p_list.displayData();
//                    break;
//                case "1.8":
//                    // Gọi phương thức thêm sản phẩm sau vị trí k
//                    System.out.print("Enter k position to add product after it: ");
//                    int k = sc.nextInt();
//                    p_list.add_after_pos(k);
//                    break;
//                case "1.9":
//                    // Gọi phương thức xóa node sau node có mã xCode
//                    System.out.print("Enter pcode to delete node after it: ");
//                    pcode = sc.nextLine();
//                    p_list.deleteNodeAfter(pcode);
//                    break;
//                case "13":
//                    // Update product quantity
//                    p_list.updateQuantity("4", 77);
//                    p_list.displayData();
//                    break;
//                case "2.1":
//                    // Gọi phương thức load data từ file cho khách hàng
//                    // D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\customers.txt
//                    fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\customers.txt";
//                    c_list.loadProductFromFile(fileName);
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
//                    System.out.print("Enter file name: ");
//                    fileName = sc.nextLine();
//                    c_list.saveToFile(fileName);
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
//                    fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\product1.txt";
//                    p_list.loadProductFromFile(fileName);
//                    fileName = "D:\\Java\\JavaProject\\CSD201\\src\\Assignment1\\customers.txt";
//                    c_list.loadProductFromFile(fileName);
//                    o_list.inputData(p_list, c_list);
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
