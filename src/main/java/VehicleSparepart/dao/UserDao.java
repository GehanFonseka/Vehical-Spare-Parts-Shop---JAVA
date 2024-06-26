package VehicleSparepart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VehicleSparepart.model.User;

public class UserDao {

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (name, email, phoneNumber, address, password) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String SELECT_USERS_BY_ID = "SELECT userID, name, email, phoneNumber, address, password FROM users WHERE userID = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE userID = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, phoneNumber = ?, address = ?, password = ? WHERE userID = ?";

    //insert
    public void insertUsers(User user) {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPassword());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateUsers(User user) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getUserID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public User selectUser(int userID) {
        User user = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID)) {
            preparedStatement.setInt(1, userID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String password = rs.getString("password");

                user = new User(userID, name, email, phoneNumber, address, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //select all
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String password = rs.getString("password");

                users.add(new User(userID, name, email, phoneNumber, address, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    //delete
    public boolean deleteUser(int userID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, userID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
