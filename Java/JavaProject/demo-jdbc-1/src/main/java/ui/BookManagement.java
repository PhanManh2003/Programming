package ui;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.HorizontalAlign;
import daos.BookDaoImpl;
import entities.Book;
import services.BookService;
import services.BookServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
public class BookManagement {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl(new BookDaoImpl());
        printTable(bookService.fillAll());
        Book book = new Book();
        book.setTitle("Kill the mocking bird");
        book.setPublishedDate(LocalDate.now());
        bookService.save(book);
        printTable(bookService.fillAll());
    }


    public static void printTable(List<Book> books){
        System.out.println(AsciiTable.getTable(books, Arrays.asList(
            new Column()
                .with(book -> Integer.toString(book.getId())),
            new Column().header("Title")
                .headerAlign(HorizontalAlign.CENTER)
                .dataAlign(HorizontalAlign.CENTER)
                .with(book -> book.getTitle()),
            new Column()
                .header("Published Date")
                .dataAlign(HorizontalAlign.CENTER)
                .with(planet -> planet.getPublishedDate().toString()))));
    }
}
