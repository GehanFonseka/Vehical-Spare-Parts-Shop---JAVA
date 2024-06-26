package VehicleSparepart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VehicleSparepart.model.Product;

public class ProductDao {
	
	private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" +
            "  (productName, description, category, price, quantity, userID) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_PRODUCTS_BY_ID = "SELECT productID, productName, description, category, price, quantity, userID FROM products WHERE productID = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
    private static final String DELETE_PRODUCTS_SQL = "DELETE FROM products WHERE productID = ?";
    private static final String UPDATE_PRODUCTS_SQL = "UPDATE products SET productName = ?, description = ?, category = ?, price = ?, quantity = ?, userID = ? WHERE productID = ?";

    //insert
    public void insertProducts(Product product) {
        System.out.println(INSERT_PRODUCTS_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setString(4, product.getPrice());
            preparedStatement.setString(5, product.getQuantity());
            preparedStatement.setString(6, product.getUserID());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateProducts(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL)) {
        	statement.setString(1, product.getProductName());
        	statement.setString(2, product.getDescription());
        	statement.setString(3, product.getCategory());
        	statement.setString(4, product.getPrice());
        	statement.setString(5, product.getQuantity());
        	statement.setString(6, product.getUserID());
            statement.setInt(7, product.getProductID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Product selectProduct(int productID) {
    	Product product = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID)) {
            preparedStatement.setInt(1, productID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String userID = rs.getString("userID");

                product = new Product(productID, productName, description, category, price, quantity, userID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    //select all
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String userID = rs.getString("userID");

                products.add(new Product(productID, productName, description, category, price, quantity, userID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    //delete
    public boolean deleteProduct(int productID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL)) {
            statement.setInt(1, productID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public List<Product> selectProductsByUserID(String userID) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE userID = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int productID = resultSet.getInt("productID");
                    String productName = resultSet.getString("productName");
                    String description = resultSet.getString("description");
                    String category = resultSet.getString("category");
                    String price = resultSet.getString("price");
                    String quantity = resultSet.getString("quantity");
                    Product product = new Product(productID, productName, description, category, price, quantity, userID);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
        return products;
    }



}
