package VehicleSparepart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VehicleSparepart.model.Cart;

public class CartDao {

	private static final String INSERT_CART_SQL = "INSERT INTO cart" +
            "  (userID, productID, productName, quantity, totalPrice) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String SELECT_CART_BY_ID = "SELECT cartID, userID, productID, productName, quantity, totalPrice FROM cart WHERE cartID = ?";
    private static final String SELECT_ALL_CART = "SELECT * FROM cart";
    private static final String DELETE_CART_SQL = "DELETE FROM cart WHERE cartID = ?";
    private static final String UPDATE_CART_SQL = "UPDATE cart SET userID = ?, productID = ?, productName = ?, quantity = ?, totalPrice = ? WHERE cartID = ?";

    //insert
    public void insertCart(Cart cart) {
        System.out.println(INSERT_CART_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setString(1, cart.getUserID());
            preparedStatement.setString(2, cart.getProductID());
            preparedStatement.setString(3, cart.getProductName());
            preparedStatement.setString(4, cart.getQuantity());
            preparedStatement.setString(5, cart.getTotalPrice());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateCart(Cart cart) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CART_SQL)) {
        	statement.setString(1, cart.getUserID());
        	statement.setString(2, cart.getProductID());
        	statement.setString(3, cart.getProductName());
        	statement.setString(4, cart.getQuantity());
        	statement.setString(5, cart.getTotalPrice());
            statement.setInt(6, cart.getCartID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Cart selectCart(int cartID) {
        Cart cart = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID)) {
            preparedStatement.setInt(1, cartID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String userID = rs.getString("userID");
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String quantity = rs.getString("quantity");
                String totalPrice = rs.getString("totalPrice");

                cart = new Cart(cartID, userID, productID, productName, quantity, totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    //select all
    public List<Cart> selectAllCart() {
        List<Cart> cart = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CART)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int cartID = rs.getInt("cartID");
                String userID = rs.getString("userID");
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String quantity = rs.getString("quantity");
                String totalPrice = rs.getString("totalPrice");

                cart.add(new Cart(cartID, userID, productID, productName, quantity, totalPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    //delete
    public boolean deleteCart(int cartID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CART_SQL)) {
            statement.setInt(1, cartID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public List<Cart> selectCartsByUserID(String userID) throws SQLException {
        List<Cart> carts = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE userID = ?";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int cartID = resultSet.getInt("cartID");
                    String productID = resultSet.getString("productID");
                    String productName = resultSet.getString("productName");
                    String quantity = resultSet.getString("quantity");
                    String totalPrice = resultSet.getString("totalPrice");
                    Cart cart = new Cart(cartID, userID, productID, productName, quantity, totalPrice);
                    carts.add(cart);
                }
            }
        }
        return carts;
    }
}
