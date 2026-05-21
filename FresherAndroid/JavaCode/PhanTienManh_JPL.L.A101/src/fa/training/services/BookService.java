package fa.training.services;

import fa.training.entities.Book;
import fa.training.utils.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    /**
     * Add a book to the collection
     *
     * @param book Book to add
     * @return true if added successfully
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }

        // Validate ISBN
        if (!Validator.isValidIsbn(book.getIsbn())) {
            System.out.println("Invalid ISBN format!");
            return false;
        }

        // Check for duplicate ISBN
        if (findBookByIsbn(book.getIsbn()) != null) {
            System.out.println("Book with this ISBN already exists!");
            return false;
        }

        books.add(book);
        return true;
    }

    /**
     * Find book by ISBN
     *
     * @param isbn ISBN to search
     * @return Book if found, null otherwise
     */
    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search books by ISBN Results are sorted by ISBN and publication date
     *
     * @param isbn ISBN to search
     * @return List of books matching the ISBN
     */
    public List<Book> searchByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().contains(isbn))
                .sorted(Comparator.comparing(Book::getIsbn)
                        .thenComparing(Book::getPublicationDate))
                .collect(Collectors.toList());
    }

    /**
     * Search books by author Results are sorted by ISBN and publication date
     *
     * @param author Author name to search
     * @return List of books by the author
     */
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();

        // Duyệt qua tất cả sách
        for (Book book : books) {
            // Kiểm tra xem có tác giả nào match không
            boolean foundAuthor = false;
            for (String bookAuthor : book.getAuthors()) {
                if (bookAuthor.toLowerCase().contains(author.toLowerCase())) {
                    foundAuthor = true;
                    break;
                }
            }

            if (foundAuthor) {
                results.add(book);
            }
        }

        // Sắp xếp kết quả
        Collections.sort(results, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int isbnCompare = b1.getIsbn().compareTo(b2.getIsbn());
                if (isbnCompare != 0) {
                    return isbnCompare;
                }
                return b1.getPublicationDate().compareTo(b2.getPublicationDate());
            }
        });

        return results;
    }

    /**
     * Search books by publisher Results are sorted by ISBN and publication date
     *
     * @param publisher Publisher name to search
     * @return List of books by the publisher
     */
    public List<Book> searchByPublisher(String publisher) {
        List<Book> results = new ArrayList<>();

        // Duyệt qua tất cả sách
        for (Book book : books) {
            if (book.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                results.add(book);
            }
        }

        // Sắp xếp kết quả
        Collections.sort(results, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int isbnCompare = b1.getIsbn().compareTo(b2.getIsbn());
                if (isbnCompare != 0) {
                    return isbnCompare;
                }
                return b1.getPublicationDate().compareTo(b2.getPublicationDate());
            }
        });

        return results;
    }

    /**
     * Add author to a specific book by ISBN
     *
     * @return true if added successfully, false if author already exists or
     * book not found
     */
    public boolean addAuthorToBook(String isbn, String author) {
        Book book = findBookByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (book.addAuthor(author)) {
            System.out.println("Add successfully");
            return true;
        } else {
            System.out.println("Author existed");
            return false;
        }
    }

    /**
     * Get all books
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Get books by publication year and publisher
     *
     * @param year Publication year
     * @param publisher Publisher name
     * @return List of books matching the criteria
     */
    public List<Book> getBooksByYearAndPublisher(int year, String publisher) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year
                && book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }
}
