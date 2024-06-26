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

import VehicleSparepart.dao.ProductDao;
import VehicleSparepart.model.Product;


@WebServlet("/ProductByUserServlet")
public class ProductByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;   
    
    public ProductByUserServlet() {
    	this.productDao = new ProductDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newProductUser":
                    showNewFormProductUser(request, response);
                    break;
                case "/insertProductUser":
                    insertProductUser(request, response);
                    break;
                case "/deleteProductUser":
                    deleteProductUser(request, response);
                    break;
                case "/editProductUser":
                    showEditFormProductUser(request, response);
                    break;
                case "/updateProductUser":
                    updateProductUser(request, response);
                    break;
                case "/listAllProducts":
                	listAllProducts(request, response);
                    break;    
                case "/addToCart":
                    addToCart(request, response);
                    break;
                default:
                    listProductsUser(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewFormProductUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProductUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String userID = request.getParameter("userID");

        Product newProduct = new Product(productName, description, category, price, quantity, userID);
        productDao.insertProducts(newProduct);
        response.sendRedirect("sell_Item");
    }

    private void deleteProductUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        productDao.deleteProduct(productID);
        response.sendRedirect("sell_Item");
    }

    private void showEditFormProductUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	int productID = Integer.parseInt(request.getParameter("productID"));
        Product existingProduct = productDao.selectProduct(productID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-form.jsp");
        request.setAttribute("Product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void updateProductUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String userID = request.getParameter("userID");

        Product product = new Product(productID, productName, description, category, price, quantity, userID);
        productDao.updateProducts(product);
        response.sendRedirect("sell_Item");
    }

    private void listProductsUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Get the userID from the session attribute
    	
        String userID = (String) request.getSession().getAttribute("userID");
        
        // Call the DAO method to fetch products by userID
        List<Product> listProductsUser = productDao.selectProductsByUserID(userID);

        // Set the attribute for the list of products
        request.setAttribute("listProductsUser", listProductsUser);

        // Forward the request to the product-list.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("sell-Item.jsp");
        dispatcher.forward(request, response);
    }


    private void listAllProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProducts = productDao.selectAllProducts();
        request.setAttribute("listProducts", listProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_products.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Get product details from request parameters
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");

        // Set product details as request attributes
        request.setAttribute("productID", productID);
        request.setAttribute("productName", productName);
        request.setAttribute("price", price);

        // Forward the request to the buy-form.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("buy-form.jsp");
        dispatcher.forward(request, response);
    }

}

