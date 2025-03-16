package services;

import daos.BookDao;
import entities.Book;

import java.util.List;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
public class BookServiceImpl implements BookService{
    private BookDao bookDao;
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Override
    public List<Book> fillAll() {
        return bookDao.fillAll();
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id);
    }
}
