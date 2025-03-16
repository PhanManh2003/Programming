package daos;

import entities.Book;

import java.util.List;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
public interface BookDao {
    List<Book> fillAll();
    boolean save(Book book);
    boolean delete(Integer id);
}
