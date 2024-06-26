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

import VehicleSparepart.dao.PaymentDao;
import VehicleSparepart.model.Payment;


@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaymentDao paymentDao;
	
    public PaymentServlet() {
        this.paymentDao = new PaymentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newPayment":
                    showNewFormPayment(request, response);
                    break;
                case "/insertPayment":
                    insertPayment(request, response);
                    break;
                case "/deletePayment":
                    deletePayment(request, response);
                    break;
                case "/editPayment":
                    showEditFormPayment(request, response);
                    break;
                case "/updatePayment":
                    updatePayment(request, response);
                    break;
                default:
                    listPayments(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void showNewFormPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String paymentAmount = request.getParameter("paymentAmount");
        String paymentMethod = request.getParameter("paymentMethod");
        String paymentDate = request.getParameter("paymentDate");

        Payment newPayment = new Payment(userID, paymentAmount, paymentMethod, paymentDate);
        paymentDao.insertPayment(newPayment);
        response.sendRedirect("list_payment");
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        paymentDao.deletePayment(paymentID);
        response.sendRedirect("list_payment");
    }

    private void showEditFormPayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        Payment existingPayment = paymentDao.selectPayment(paymentID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-form.jsp");
        request.setAttribute("Payment", existingPayment);
        dispatcher.forward(request, response);
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        String userID = request.getParameter("userID");
        String paymentAmount = request.getParameter("paymentAmount");
        String paymentMethod = request.getParameter("paymentMethod");
        String paymentDate = request.getParameter("paymentDate");

        Payment payment = new Payment(paymentID, userID, paymentAmount, paymentMethod, paymentDate);
        paymentDao.updatePayment(payment);
        response.sendRedirect("list_payment");
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Payment> listPayments = paymentDao.selectAllPayments();
        request.setAttribute("listPayments", listPayments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payment-list.jsp");
        dispatcher.forward(request, response);
    }
	

}
