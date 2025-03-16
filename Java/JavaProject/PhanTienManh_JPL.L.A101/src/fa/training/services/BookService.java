package fa.training.services;

import fa.training.entities.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return books;
    }

    // 1. add a new book with unique ISBN
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                System.out.println("ISBN already exists!");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // 4. add an author to a specific book
    public void addAuthorToBook(String isbn, String author) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.getAuthor().contains(author)) {
                    System.out.println("Author already exists.");
                } else {
                    b.getAuthor().add(author);
                    System.out.println("Add successfully.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    //6. Function to count all Publications by publication year
    public void countPublicationsByYear(int year) {
        long count = books.stream().filter(b -> b.getPublicationYear() == year).count();
        System.out.println("Number of books published in " + year + ": " + count);

    }
    //3. Functional Req 3

    public void displayBooksByYearAndPublisher(int year, String publisher) {
        System.out.println("\nBooks published in " + year + " by " + publisher + ":");
        boolean found = false;
        for (Book book : books) {
            if (book.getPublicationYear() == year && book.getPublisher().equalsIgnoreCase(publisher)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the given criteria.");
        }
    }

}
