package VehicleSparepart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VehicleSparepart.model.Feedback;

public class FeedbackDao {
	
	private static final String INSERT_FEEDBACK_SQL = "INSERT INTO feedbacks" +
            "  (userID, productID, ratings, message, feedbackDate) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String SELECT_FEEDBACK_BY_ID = "SELECT feedbackID, userID, productID, ratings, message, feedbackDate FROM feedbacks WHERE feedbackID = ?";
    private static final String SELECT_ALL_FEEDBACK = "SELECT * FROM feedbacks";
    private static final String DELETE_FEEDBACK_SQL = "DELETE FROM feedbacks WHERE feedbackID = ?";
    private static final String UPDATE_FEEDBACK_SQL = "UPDATE feedbacks SET userID = ?, productID = ?, ratings = ?, message = ?, feedbackDate = ? WHERE feedbackID = ?";

    //insert
    public void insertFeedback(Feedback feedback) {
        System.out.println(INSERT_FEEDBACK_SQL);

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FEEDBACK_SQL)) {
            preparedStatement.setString(1, feedback.getUserID());
            preparedStatement.setString(2, feedback.getProductID());
            preparedStatement.setString(3, feedback.getRatings());
            preparedStatement.setString(4, feedback.getMessage());
            preparedStatement.setString(5, feedback.getFeedbackDate());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public boolean updateFeedback(Feedback feedback) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FEEDBACK_SQL)) {
        	statement.setString(1, feedback.getUserID());
        	statement.setString(2, feedback.getProductID());
        	statement.setString(3, feedback.getRatings());
        	statement.setString(4, feedback.getMessage());
        	statement.setString(5, feedback.getFeedbackDate());
            statement.setInt(6, feedback.getFeedbackID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    //select by id
    public Feedback selectFeedback(int feedbackID) {
    	Feedback feedback = null;

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FEEDBACK_BY_ID)) {
            preparedStatement.setInt(1, feedbackID);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String userID = rs.getString("userID");
                String productID = rs.getString("productID");
                String ratings = rs.getString("ratings");
                String message = rs.getString("message");
                String feedbackDate = rs.getString("feedbackDate");

                feedback = new Feedback(feedbackID, userID, productID, ratings, message, feedbackDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    //select all
    public List<Feedback> selectAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FEEDBACK)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int feedbackID = rs.getInt("feedbackID");
                String userID = rs.getString("userID");
                String productID = rs.getString("productID");
                String ratings = rs.getString("ratings");
                String message = rs.getString("message");
                String feedbackDate = rs.getString("feedbackDate");

                feedbacks.add(new Feedback(feedbackID, userID, productID, ratings, message, feedbackDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    //delete
    public boolean deleteFeedback(int feedbackID) {
        boolean rowDeleted = false;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FEEDBACK_SQL)) {
            statement.setInt(1, feedbackID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public List<Feedback> selectFeedbackByUser(String userID) throws SQLException {
        List<Feedback> feedbackList = new ArrayList<>();
        String query = "SELECT * FROM feedbacks WHERE userID = ?";

        try (Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int feedbackID = resultSet.getInt("feedbackID");
                    String productID = resultSet.getString("productID");
                    String ratings = resultSet.getString("ratings");
                    String message = resultSet.getString("message");
                    String feedbackDate = resultSet.getString("feedbackDate");

                    Feedback feedback = new Feedback(feedbackID, userID, productID, ratings, message, feedbackDate);
                    feedbackList.add(feedback);
                }
            }
        }

        return feedbackList;
    }

}
