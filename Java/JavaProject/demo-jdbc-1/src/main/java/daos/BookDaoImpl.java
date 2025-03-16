package daos;

import entities.Book;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
public class BookDaoImpl implements BookDao{
    @Override
    public List<Book> fillAll() {
        List<Book> books = new LinkedList<>();
        //try(connection): try-with-resources
        try(Connection connection = DatabaseConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPublishedDate(resultSet.getDate("publishedDate").toLocalDate());
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public boolean save(Book book) {
        try(Connection connection = DatabaseConnection.getConnection()){
            String sql = "INSERT INTO books (title, publishedDate) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setDate(2, Date.valueOf(book.getPublishedDate()));
            return statement.executeUpdate() == 1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public boolean delete(String id) {
//        try(Connection connection = DatabaseConnection.getConnection()){
//           Statement statement = connection.createStatement();
//           return statement.executeUpdate("Delete from books where id = 1 or 1 = 1") == 1;
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public boolean delete(Integer id) {
        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id =?");
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        //sql-injection
        System.out.println(bookDao.delete(1));
        System.out.println(bookDao.fillAll());
    }
}
