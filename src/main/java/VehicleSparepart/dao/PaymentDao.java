package VehicleSparepart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VehicleSparepart.model.Payment;



public class PaymentDao {
	
	private static final String INSERT_PAYMENT_SQL = "INSERT INTO payments" +
            "  (userID, paymentAmount, paymentMethod, paymentDate) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_PAYMENT_BY_ID = "SELECT userID, paymentAmount, paymentMethod, paymentDate FROM payments WHERE paymentID = ?";
    private static final String SELECT_ALL_PAYMENT = "SELECT * FROM payments";
    private static final String DELETE_PAYMENT_SQL = "DELETE FROM payments WHERE paymentID = ?";
    private static final String UPDATE_PAYMENT_SQL = "UPDATE payments SET userID = ?, paymentAmount = ?, paymentMethod = ?, paymentDate = ? WHERE paymentID = ?";

    //insert
    public void insertPayment(Payment payment) {
        System.out.println(INSERT_PAYMENT_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_SQL)) {
            preparedStatement.setString(1, payment.getuserID());
            preparedStatement.setString(2, payment.getPaymentAmount());
            preparedStatement.setString(3, payment.getPaymentMethod());
            preparedStatement.setString(4, payment.getPaymentDate());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updatePayment(Payment payment) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENT_SQL)) {
        	statement.setString(1, payment.getuserID());
        	statement.setString(2, payment.getPaymentAmount());
        	statement.setString(3, payment.getPaymentMethod());
        	statement.setString(4, payment.getPaymentDate());
            statement.setInt(5, payment.getPaymentID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Payment selectPayment(int paymentID) {
        Payment payment = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ID)) {
            preparedStatement.setInt(1, paymentID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String userID = rs.getString("userID");
                String paymentAmount = rs.getString("paymentAmount");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");

                payment = new Payment(paymentID, userID, paymentAmount, paymentMethod, paymentDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    //select all
    public List<Payment> selectAllPayments() {
        List<Payment> payments = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int paymentID = rs.getInt("paymentID");
                String userID = rs.getString("userID");
                String paymentAmount = rs.getString("paymentAmount");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");

                payments.add(new Payment(paymentID, userID, paymentAmount, paymentMethod, paymentDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    //delete
    public boolean deletePayment(int paymentID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT_SQL)) {
            statement.setInt(1, paymentID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public List<Payment> selectPaymentsByUserID(String userID) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments WHERE userID = ?";
        
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int paymentID = resultSet.getInt("paymentID");
                    String paymentAmount = resultSet.getString("paymentAmount");
                    String paymentMethod = resultSet.getString("paymentMethod");
                    String paymentDate = resultSet.getString("paymentDate");
                    
                    Payment payment = new Payment(paymentID, userID, paymentAmount, paymentMethod, paymentDate);
                    payments.add(payment);
                }
            }
        }
        return payments;
    }

}
