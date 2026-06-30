package com.example.ass4.data;

import com.example.ass4.R;
import com.example.ass4.model.Book;

import java.util.ArrayList;

public class MockData {
    public static ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Clean Code",               "Robert C. Martin",  R.drawable.book1));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt",        R.drawable.book2));
        books.add(new Book("Design Patterns",          "Gang of Four",       R.drawable.book3));
        books.add(new Book("Refactoring",              "Martin Fowler",      R.drawable.book4));
        books.add(new Book("The Clean Coder",          "Robert C. Martin",  R.drawable.book5));
        books.add(new Book("Head First Java",          "Kathy Sierra",       R.drawable.book6));
        books.add(new Book("Effective Java",           "Joshua Bloch",       R.drawable.book7));
        books.add(new Book("Introduction to Algorithms","Thomas H. Cormen", R.drawable.book8));
        books.add(new Book("Code Complete",            "Steve McConnell",    R.drawable.book9));
        books.add(new Book("The Mythical Man-Month",   "Frederick Brooks",   R.drawable.book10));
        return books;
    }
}
