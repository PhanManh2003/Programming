package fa.training.entities;

import java.util.Date;

public class Magazine extends Publication {

    private String author;
    private int volumn;
    private int edition;

    public Magazine(int publicationYear, String publisher, Date publicationDate,
            String author, int volumn, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volumn = volumn;
        this.edition = edition;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volumn) {
        this.volumn = volumn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public void display() {
        System.out.println("Magazine Author: " + author);
        System.out.println("Volume: " + volumn);
        System.out.println("Edition: " + edition);
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + getPublicationDate());
    }

}
