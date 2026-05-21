package fa.training.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {

    private String isbn;
    private Set<String> authors;
    private String publicationPlace;

    

    public Book() {
        super();
        this.authors = new HashSet<>();
    }

    public Book(int publicationYear, String publisher, Date publicationDate,
            String isbn, Set<String> authors, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.authors = authors != null ? authors : new HashSet<>();
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    
    /**
     * Add an author to the book
     * @param author Author name to add
     * @return true if author was added, false if already exists
     */
    public boolean addAuthor(String author) {
        return this.authors.add(author);
    }
    
    @Override
    public void display() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("========== BOOK INFORMATION ==========");
        System.out.println("ISBN: " + isbn);
        System.out.println("Authors: " + String.join(", ", authors));
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + dateFormat.format(getPublicationDate()));
        System.out.println("Publication Place: " + publicationPlace);
        System.out.println("======================================");
    }

}
