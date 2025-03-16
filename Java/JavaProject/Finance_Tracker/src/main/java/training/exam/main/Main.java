package training.exam.main;

import training.exam.entity.DatabaseManager;
import training.exam.entity.Transaction;
import training.exam.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();
        int choice = 0;
        do {
            // Display the menu
            System.out.println("=====================================");
            System.out.println("           MAIN MENU            ");
            System.out.println("=====================================");
            System.out.println("1. Option 1: Add User");
            System.out.println("2. Option 2: Add Transaction");
            System.out.println("3. Option 3: Remove Transaction");
            System.out.println("4. Option 4: Get User Transaction");
            System.out.println("5. Option 5: Get Monthly Report By User");
            System.out.println("6. Option 6: Exit");

            // get input
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // handle input
            switch (choice) {
                case 1:
                    System.out.println("You selected: Add User");
                    String username, password;
                    User newUser = new User();
                    do {
                        System.out.print("Enter username: ");
                        username = scanner.next();
                        System.out.print("Enter password: ");
                        password = scanner.next();
                        newUser.setUsername(username);
                        newUser.setPassword(password);
                        if (newUser.validateUser()) {
                            break;
                        } else {
                            System.out.println("Password should be 10 character long and contain 1 special character");
                            System.out.println("Username cannot contain number");
                        }
                    } while (true);
                    db.AddUser(newUser);
                    break;
                case 2:
                    System.out.println("You selected: Add Transaction");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false);
                    System.out.print("Enter user_id: ");
                    int user_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter type(expense|income): ");
                    String type = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter date: ");
                    Date date = null;
                    try {
                        date = dateFormat.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    Transaction t = new Transaction();
                    t.setUserId(user_id);
                    t.setAmount(amount);
                    t.setCategory(category);
                    t.setType(type);
                    t.setDescription(desc);
                    t.setDate(date);
                    db.addTransaction(t);
                    break;
                case 3:
                    System.out.println("You selected: Remove Transaction");
                    System.out.print("Enter transactionId: ");
                    int transactionId = scanner.nextInt();
                    db.removeTransaction(transactionId);
                    break;
                case 4:
                    System.out.println("You selected: Get User Transaction");
                    System.out.print("Enter userId: ");
                    int userId = scanner.nextInt();
                    List<Transaction> trans = db.getUserTransaction(userId);
                    if (trans.size() > 0) {
                        for (Transaction tran : trans) {
                            System.out.println(tran);
                        }
                    }
                    break;
                case 5:
                    System.out.println("You selected: Get Monthly Report By User");
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option (1-6).");
            }
        } while (choice != 6);
        scanner.close();
    }
}
