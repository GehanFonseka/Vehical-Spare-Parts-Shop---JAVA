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

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FeedbackDao feedbackDao;
    
    public FeedbackServlet() {
       this.feedbackDao = new FeedbackDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newFeedback":
                    showNewFormFeedback(request, response);
                    break;
                case "/insertFeedback":
                    insertFeedback(request, response);
                    break;
                case "/deleteFeedback":
                    deleteFeedback(request, response);
                    break;
                case "/editFeedback":
                    showEditFormFeedback(request, response);
                    break;
                case "/updateFeedback":
                    updateFeedback(request, response);
                    break;
                default:
                    listFeedbacks(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void showNewFormFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String ratings = request.getParameter("ratings");
        String message = request.getParameter("message");
        String feedbackDate = request.getParameter("feedbackDate");

        Feedback newFeedback = new Feedback(userID, productID, ratings, message, feedbackDate);
        feedbackDao.insertFeedback(newFeedback);
        response.sendRedirect("list_feedback");
    }

    private void deleteFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        feedbackDao.deleteFeedback(feedbackID);
        response.sendRedirect("list_feedback");
    }

    private void showEditFormFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        Feedback existingFeedback = feedbackDao.selectFeedback(feedbackID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-form.jsp");
        request.setAttribute("Feedback", existingFeedback);
        dispatcher.forward(request, response);
    }

    private void updateFeedback(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int feedbackID = Integer.parseInt(request.getParameter("feedbackID"));
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String ratings = request.getParameter("ratings");
        String message = request.getParameter("message");
        String feedbackDate = request.getParameter("feedbackDate");

        Feedback feedback = new Feedback(feedbackID, userID, productID, ratings, message, feedbackDate);
        feedbackDao.updateFeedback(feedback);
        response.sendRedirect("list_feedback");
    }

    private void listFeedbacks(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Feedback> listFeedbacks = feedbackDao.selectAllFeedback();
        request.setAttribute("listFeedbacks", listFeedbacks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("feedback-list.jsp");
        dispatcher.forward(request, response);
    }
	

}
