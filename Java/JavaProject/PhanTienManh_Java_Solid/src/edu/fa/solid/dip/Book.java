package edu.fa.solid.dip;

public class Book implements ShelfItem {

    @Override
    public void seeReviews() {
        System.out.println("Viewing book reviews.");
    }

    public void readSample() {
        System.out.println("Reading book sample.");
    }
}
