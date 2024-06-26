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


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartDao cartDao;
    
    public CartServlet() {
        this.cartDao = new CartDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newCart":
                    showNewFormCart(request, response);
                    break;
                case "/insertCart":
                    insertCart(request, response);
                    break;
                case "/deleteCart":
                    deleteCart(request, response);
                    break;
                case "/editCart":
                    showEditFormCart(request, response);
                    break;
                case "/updateCart":
                    updateCart(request, response);
                    break;
                default:
                    listCart(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	private void showNewFormCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String totalPrice = request.getParameter("totalPrice");

        Cart newCart = new Cart(userID, productID, productName, quantity, totalPrice);
        cartDao.insertCart(newCart);
        response.sendRedirect("list_cart");
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        cartDao.deleteCart(cartID);
        response.sendRedirect("list_cart");
    }

    private void showEditFormCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        Cart existingCart = cartDao.selectCart(cartID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart-form.jsp");
        request.setAttribute("Cart", existingCart);
        dispatcher.forward(request, response);
    }

    private void updateCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String totalPrice = request.getParameter("totalPrice");

        Cart cart = new Cart(cartID, userID, productID, productName, quantity, totalPrice);
        cartDao.updateCart(cart);
        response.sendRedirect("list_cart");
    }

    private void listCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Cart> listCart = cartDao.selectAllCart();
        request.setAttribute("listCart", listCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart-list.jsp");
        dispatcher.forward(request, response);
    }
	

}
