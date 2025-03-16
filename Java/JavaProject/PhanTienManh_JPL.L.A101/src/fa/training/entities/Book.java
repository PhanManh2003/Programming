package fa.training.entities;

import java.util.Date;
import java.util.Set;

public class Book extends Publication {

    private String isbn;
    private Set<String> author;
    private String publicationPlace;

    public Book(int publicationYear, String publisher, Date publicationDate,
            String isbn, Set<String> author, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    @Override
    public void display() {
        System.out.println("Book ISBN: " + isbn);
        System.out.println("Authors: " + String.join(", ", author));
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Publication Place: " + publicationPlace);
    }

}
