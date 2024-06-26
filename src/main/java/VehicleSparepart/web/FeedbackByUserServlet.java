package VehicleSparepart.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VehicleSparepart.dao.FeedbackDao;
import VehicleSparepart.model.Feedback;


@WebServlet("/FeedbackByUserServlet")
public class FeedbackByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FeedbackDao feedbackDao;
    
    public FeedbackByUserServlet() {
    	this.feedbackDao = new FeedbackDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newFeedbackUser":
                    showNewFormFeedbackUser(request, response);
                    break;
                case "/insertFeedbackUser":
                    insertFeedbackUser(request, response);
                    break;
                case "/deleteFeedbackUser":
                    deleteFeedbackUser(request, response);
                    break;
                case "/editFeedbackUser":
                    showEditFormFeedbackUser(request, response);
                    break;
                case "/updateFeedbackUser":
                    updateFeedbackUser(request, response);
                    break;
                default:
                    listFeedbacksUser(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void showNewFormFeedbackUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackUser-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFeedbackUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String ratings = request.getParameter("ratings");
        String message = request.getParameter("message");
        String feedbackDate = request.getParameter("feedbackDate");

        Feedback newFeedback = new Feedback(userID, productID, ratings, message, feedbackDate);
        feedbackDao.insertFeedback(newFeedback);
        response.sendRedirect("list_feedbackUser");
    }

    private void deleteFeedbackUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        feedbackDao.deleteFeedback(feedbackID);
        response.sendRedirect("list_feedbackUser");
    }

    private void showEditFormFeedbackUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        Feedback existingFeedback = feedbackDao.selectFeedback(feedbackID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackUser-form.jsp");
        request.setAttribute("Feedback", existingFeedback);
        dispatcher.forward(request, response);
    }

    private void updateFeedbackUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String ratings = request.getParameter("ratings");
        String message = request.getParameter("message");
        String feedbackDate = request.getParameter("feedbackDate");

        Feedback feedback = new Feedback(feedbackID, userID, productID, ratings, message, feedbackDate);
        feedbackDao.updateFeedback(feedback);
        response.sendRedirect("list_feedbackUser");
    }

    private void listFeedbacksUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	// Get the userID from the session attribute
    	
        String userID = (String) request.getSession().getAttribute("userID");
        
        // Call the DAO method to fetch products by userID
        List<Feedback> listFeedbacksUser = feedbackDao.selectFeedbackByUser(userID);
        
        // Set the attribute for the list of products
        request.setAttribute("listFeedbacksUser", listFeedbacksUser);
        
        // Forward the request to the product-list.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedbackUser-list.jsp");
        dispatcher.forward(request, response);
    }
	

}
