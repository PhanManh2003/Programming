package edu.fa.solid.dip;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private List<ShelfItem> items;  // List to hold items

    public Shelf() {
        items = new ArrayList<>();
    }

    public void addItem(ShelfItem item) {
        items.add(item);
    }

    public void customizeShelf() {
        System.out.println("Customizing the shelf.");
    }
}
