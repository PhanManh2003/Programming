package dal;

import java.util.ArrayList;
import java.util.List;
import model.Product;
import java.sql.*;

public class ProductDAO extends DBContext {

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        // READ:
        //    connect with DB
        connection = getConnection();
        //    Chuẩn bị câu lệnh sql
        String sql = "SELECT * FROM dbo.Product";
        try {
            //    Tạo đối tượng preparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            //    setParameter (optional)
            //    executeQuery
            ResultSet rs = statement.executeQuery();
            //    Trả về kết quả
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name").trim();
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Product product = new Product(id, name, quantity, price);
                list.add(product);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Product> findByName(String keyword) {
        List<Product> listProduct = new ArrayList<>();
        // Connect with DB
        connection = getConnection();
        // chuẩn bị câu lệnh sql
        String sql = "SELECT * FROM dbo.Product WHERE name LIKE ?";
        try {
            // tạo đối tượng preparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            // setParameter(optional)
            statement.setString(1, "%" + keyword + "%");
            // Execute
            ResultSet rs = statement.executeQuery();
            // Tra ve ket qua
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name").trim();
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Product product = new Product(id, name, quantity, price);
                listProduct.add(product);
            }
            return listProduct;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int insert(Product product) {
        // Connect with DB
        connection = getConnection();
        // chuẩn bị câu lệnh sql
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([name]\n"
                + "           ,[quantity]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            // tạo đối tượng preparedStatement
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // setParameter(optional)
            statement.setObject(1, product.getName());
            statement.setObject(2, product.getQuantity());
            statement.setObject(3, product.getPrice());

            // Execute
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            // Tra ve ket qua
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    public void update(Product product) {
        // Connect with DB
        connection = getConnection();
        // chuẩn bị câu lệnh sql
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + " WHERE [id] = ?";
        try {
            // tạo đối tượng preparedStatement
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // setParameter(optional)
            statement.setObject(1, product.getName());
            statement.setObject(2, product.getQuantity());
            statement.setObject(3, product.getPrice());
            statement.setObject(4, product.getId());

            // Update
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Product product) {
        // Connect with DB
        connection = getConnection();
        // chuẩn bị câu lệnh sql
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE [id]= ?";
        try {
            // tạo đối tượng preparedStatement
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // setParameter(optional)
            statement.setObject(1, product.getId());

            // Delete
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
