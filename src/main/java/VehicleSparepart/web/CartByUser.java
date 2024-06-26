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

import VehicleSparepart.dao.CartDao;
import VehicleSparepart.model.Cart;


@WebServlet("/CartByUser")
public class CartByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao cartDao;
    
    public CartByUser() {
    	this.cartDao = new CartDao();
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newCartUser":
                    showNewFormCartUser(request, response);
                    break;
                case "/insertCartUser":
                    insertCartUser(request, response);
                    break;
                case "/deleteCartUser":
                    deleteCartUser(request, response);
                    break;
                case "/editCartUser":
                    showEditFormCartUser(request, response);
                    break;
                case "/updateCartUser":
                    updateCartUser(request, response);
                    break;
                default:
                    listCartUser(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void showNewFormCartUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("buy-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCartUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String totalPrice = request.getParameter("totalPrice");

        Cart newCart = new Cart(userID, productID, productName, quantity, totalPrice);
        cartDao.insertCart(newCart);
        response.sendRedirect("buy_list");
    }

    private void deleteCartUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        cartDao.deleteCart(cartID);
        response.sendRedirect("buy_list");
    }

    private void showEditFormCartUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        Cart existingCart = cartDao.selectCart(cartID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("buyUpdate-form.jsp");
        request.setAttribute("Cart", existingCart);
        dispatcher.forward(request, response);
    }

    private void updateCartUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String totalPrice = request.getParameter("totalPrice");

        Cart cart = new Cart(cartID, userID, productID, productName, quantity, totalPrice);
        cartDao.updateCart(cart);
        response.sendRedirect("buy_list");
    }

    private void listCartUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Get the userID from the session attribute
        String userID = (String) request.getSession().getAttribute("userID");
        
        // Call the DAO method to fetch carts by userID
        List<Cart> listCartUser = cartDao.selectCartsByUserID(userID);

        // Set the attribute for the list of carts
        request.setAttribute("listCartUser", listCartUser);

        // Forward the request to the cart-list.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("buy-list.jsp");
        dispatcher.forward(request, response);
    }

	

}
