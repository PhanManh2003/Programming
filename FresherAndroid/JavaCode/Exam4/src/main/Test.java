package main;

import java.util.Scanner;

import service.Management;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management manager = new Management();
        int choice = 0;

        do {
            System.out.println("\n=== Contact Management ===");
            System.out.println("1. Add contact");
            System.out.println("2. Edit contact");
            System.out.println("3. Search by name");
            System.out.println("4. Sort contacts");
            System.out.println("5. Display all");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number! ");
            }

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    manager.addContact(name, phone);
                    break;
                case 2:
                    System.out.print("Old phone: ");
                    String oldP = sc.nextLine();
                    System.out.print("New phone: ");
                    String newP = sc.nextLine();
                    manager.editContact(oldP, newP);
                    break;
                case 3:
                    System.out.print("Search name: ");
                    String q = sc.nextLine();
                    manager.searchByName(q);
                    break;
                case 4:
                    manager.sortContacts();
                    break;
                case 5:
                    manager.displayAll();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
