package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.utils.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
Functional Requirements
1. The program must have a function to add a new book with unique isbn
2. The program must have a function to add a new magazine 
3. The program must have a function to display the list of all books and magazines that 
   have the same publication year and publisher. 
4. The program must have a function to add an author to a specific book, if the author
   existed, the program should print a message "Author existed", otherwise print "Add successfully".
5. The program must have a function to display the list of top 10 magazines which have the largest volume. 
6. The program must provide functions to search book by:
   - isbn
   - author
   - publisher
   Search results should be sorted by isbn, publication date.
 */
public class LibraryManagement {

    private static BookService bookService = new BookService();
    private static MagazineService magazineService = new MagazineService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = getIntInput("Please choose function you'd like to do: ");
            System.out.println();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    displayBooksAndMagazines();
                    break;
                case 4:
                    addAuthorToBook();
                    break;
                case 5:
                    displayTop10Magazines();
                    break;
                case 6:
                    searchBook();
                    break;
                case 0:
                    System.out.println("Thank you for using Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }

    /**
     * Display main menu
     */
    private static void displayMenu() {
        System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
        System.out.println("1. Add a book");
        System.out.println("2. Add a magazine");
        System.out.println("3. Display books and magazines");
        System.out.println("4. Add author to book");
        System.out.println("5. Display top 10 of magazines by volume");
        System.out.println("6. Search book by (isbn, author, publisher)");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    /**
     * Function 1: Add a book
     */
    private static void addBook() {
        System.out.println("===== ADD A NEW BOOK =====");

        // Input ISBN
        String isbn;
        do {
            isbn = getStringInput("Enter ISBN (10-17 characters, e.g., 678-3-16-1486): ");
            if (!Validator.isValidIsbn(isbn)) {
                System.out.println("Invalid ISBN format! Please try again.");
            }
        } while (!Validator.isValidIsbn(isbn));

        // Input publication year
        int year = getIntInput("Enter publication year: ");

        // Input publisher
        String publisher = getStringInput("Enter publisher: ");

        // Input publication date
        Date publicationDate = getDateInput("Enter publication date (dd/MM/yyyy): ");

        // Input publication place
        String publicationPlace = getStringInput("Enter publication place: ");

        // Input authors
        Set<String> authors = new HashSet<>();
        int numAuthors = getIntInput("Enter number of authors: ");
        for (int i = 1; i <= numAuthors; i++) {
            String author = getStringInput("Enter author " + i + ": ");
            authors.add(author);
        }

        // Create and add book
        Book book = new Book(year, publisher, publicationDate, isbn, authors, publicationPlace);

        if (bookService.addBook(book)) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Failed to add book!");
        }
    }

    /**
     * Function 2: Add a magazine
     */
    private static void addMagazine() {
        System.out.println("===== ADD A NEW MAGAZINE =====");

        // Input publication year
        int year = getIntInput("Enter publication year: ");

        // Input publisher
        String publisher = getStringInput("Enter publisher: ");

        // Input publication date
        Date publicationDate = getDateInput("Enter publication date (dd/MM/yyyy): ");

        // Input author
        String author = getStringInput("Enter author: ");

        // Input volume
        int volume = getIntInput("Enter volume: ");

        // Input edition
        int edition = getIntInput("Enter edition: ");

        // Create and add magazine
        Magazine magazine = new Magazine(year, publisher, publicationDate, author, volume, edition);

        if (magazineService.addMagazine(magazine)) {
            System.out.println("Magazine added successfully!");
        } else {
            System.out.println("Failed to add magazine!");
        }
    }

    /**
     * Function 3: Display books and magazines by publication year and publisher
     */
    private static void displayBooksAndMagazines() {
        System.out.println("===== DISPLAY BOOKS AND MAGAZINES =====");

        int year = getIntInput("Enter publication year: ");
        String publisher = getStringInput("Enter publisher: ");

        List<Book> books = bookService.getBooksByYearAndPublisher(year, publisher);
        List<Magazine> magazines = magazineService.getMagazinesByYearAndPublisher(year, publisher);

        System.out.println("\n----- BOOKS -----");
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                book.display();
            }
        }

        System.out.println("\n----- MAGAZINES -----");
        if (magazines.isEmpty()) {
            System.out.println("No magazines found.");
        } else {
            for (Magazine magazine : magazines) {
                magazine.display();
            }
        }
    }

    /**
     * Function 4: Add author to a specific book
     */
    private static void addAuthorToBook() {
        System.out.println("===== ADD AUTHOR TO BOOK =====");

        String isbn = getStringInput("Enter book ISBN: ");
        String author = getStringInput("Enter author name: ");

        bookService.addAuthorToBook(isbn, author);
    }

    /**
     * Function 5: Display top 10 magazines by volume
     */
    private static void displayTop10Magazines() {
        System.out.println("===== TOP 10 MAGAZINES BY VOLUME =====");

        List<Magazine> topMagazines = magazineService.getTop10MagazinesByVolume();

        if (topMagazines.isEmpty()) {
            System.out.println("No magazines found.");
        } else {
            int rank = 1;
            for (Magazine magazine : topMagazines) {
                System.out.println("\n--- Rank " + rank++ + " ---");
                magazine.display();
            }
        }
    }

    /**
     * Function 6: Search book
     */
    private static void searchBook() {
        System.out.println("===== SEARCH BOOK =====");
        System.out.println("1. Search by ISBN");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Publisher");

        int choice = getIntInput("Choose search option: ");
        List<Book> results = new ArrayList<>();

        switch (choice) {
            case 1:
                String isbn = getStringInput("Enter ISBN: ");
                results = bookService.searchByIsbn(isbn);
                break;
            case 2:
                String author = getStringInput("Enter author name: ");
                results = bookService.searchByAuthor(author);
                break;
            case 3:
                String publisher = getStringInput("Enter publisher: ");
                results = bookService.searchByPublisher(publisher);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n----- SEARCH RESULTS -----");
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Found " + results.size() + " book(s):");
            for (Book book : results) {
                book.display();
            }
        }
    }

    /**
     * Get string input from user
     */
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Get integer input from user
     */
    private static int getIntInput(String prompt) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please try again.");
            }
        }

        return value;
    }

    /**
     * Get date input from user
     */
    private static Date getDateInput(String prompt) {
        Date date = null;
        boolean valid = false;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);

        while (!valid) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine().trim();
                date = dateFormatter.parse(dateStr);
                valid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please use dd/MM/yyyy format.");
            }
        }

        return date;
    }
}
