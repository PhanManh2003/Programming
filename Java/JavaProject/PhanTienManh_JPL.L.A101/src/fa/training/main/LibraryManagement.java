package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Functional Requirements
1. The program must have a function to add a new book but keep isbn is unique
2. The program must have a function to add a new magazine but keep sorted by
publication date
3.The program must have a function to display the list of all books and magazines that 
have the same input publication year and publisher. 
4. The program must have a function to add an author to a specific book, if the author
existed, the program should print a message “Author existed”, otherwise print “Add
successfully”.
5. The program must have a function to display the list of top 10 magazines which have  the largest volume. 
6. The program must have count all Publication by publication year
7. The program must provide functions to search flexibly match at least one criteria:
- by isbn
- by author
- by publisher
Search results should be sorted by publication date.
 */
public class LibraryManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new magazine");
            System.out.println("3. Display list of all books, magazines "
                    + "that have same publication year and publisher");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 magazines by volume");
            System.out.println("6. Count all publications by year");
            System.out.println("7. Search for publication by ISBN, author, or publisher");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a new book
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter publisher: ");
                    String bookPublisher = scanner.nextLine();
                    Date bookDate = getDate(
                            "Enter publicationDate(dd/MM/yyyy):",
                            "Invalid!", "dd/MM/yyyy");
                    // Parse publication date
                    System.out.print("Enter publication place: ");
                    String publicationPlace = scanner.nextLine();
                    System.out.print("Enter authors (comma separated): ");
                    Set<String> authors = new HashSet<>();
                    for (String author : scanner.nextLine().split(",")) {
                        authors.add(author.trim());
                    }

                    Book newBook = new Book(bookYear,
                            bookPublisher,
                            bookDate, isbn,
                            authors, publicationPlace);
                    bookService.addBook(newBook);
                    break;

                case 2:
                    // Add a new magazine
                    System.out.print("Enter publication year: ");
                    int magYear = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter publisher: ");
                    String magPublisher = scanner.nextLine();

                    // Parse publication date
                    Date magDate = getDate(
                            "Enter publicationDate(dd/MM/yyyy):",
                            "Invalid!", "dd/MM/yyyy");

                    System.out.print("Enter author: ");
                    String magAuthor = scanner.nextLine();
                    System.out.print("Enter volume: ");
                    int volume = scanner.nextInt();
                    System.out.print("Enter edition: ");
                    int edition = scanner.nextInt();

                    Magazine newMagazine = new Magazine(magYear,
                            magPublisher, magDate,
                            magAuthor, volume, edition);
                    magazineService.addMagazine(newMagazine);
                    break;

                case 3:
                    // Display books by year and publisher
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    bookService.displayBooksByYearAndPublisher(year, publisher);
                    magazineService.displayMagazinesByYearAndPublisher(year, publisher);
                    break;

                case 4:
                    // Add an author to a book
                    System.out.print("Enter ISBN of the book: ");
                    String bookIsbn = scanner.nextLine();
                    System.out.print("Enter author to add: ");
                    String authorToAdd = scanner.nextLine();
                    bookService.addAuthorToBook(bookIsbn, authorToAdd);
                    break;

                case 5:
                    // Display top 10 magazines by volume
                    magazineService.displayTop10MagazinesByVolume();
                    break;

                case 6:
                    // Count publications by year
                    System.out.print("Enter year: ");
                    int countYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bookService.countPublicationsByYear(countYear);
                    magazineService.countPublicationsByYear(countYear);
                    break;

                case 7:
                    // Search for publication by ISBN, author, or publisher
                    System.out.print("Enter ISBN, author, or publisher: ");
                    String searchQuery = scanner.nextLine();
                    searchPublications(searchQuery, bookService, magazineService);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }

    private static void searchPublications(String query,
            BookService bookService, MagazineService magazineService) {
        boolean found = false;

        // Search books by ISBN, author, or publisher
        for (Book book : bookService.getBooks()) {
            if (book.getIsbn().equals(query)
                    || book.getPublisher().equals(query)
                    || book.getAuthor().contains(query)) {
                book.display();
                found = true;
            }
        }

        // Search magazines by ISBN, author, or publisher
        for (Magazine magazine : magazineService.getMagazines()) {
            if (magazine.getAuthor().equals(query)
                    || magazine.getPublisher().equals(query)) {
                magazine.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No publications found for the given query.");
        }
    }

    // util
    private static Date getDate(String messageInfo, String messageErrorDate,
            final String REGEX) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(messageInfo);
            try {
                // Parse a string back into a Date object
                Date date = dateFormat.parse(scanner.nextLine());
                return date;
            } catch (Exception e) {
                System.out.println(messageErrorDate);
            }
        } while (true);
    }
}
