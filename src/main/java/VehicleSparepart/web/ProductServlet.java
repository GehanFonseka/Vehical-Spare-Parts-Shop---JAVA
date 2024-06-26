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



@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    
    public ProductServlet() {
       this.productDao = new ProductDao();   
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/newProduct":
                    showNewFormProduct(request, response);
                    break;
                case "/insertProduct":
                    insertProduct(request, response);
                    break;
                case "/deleteProduct":
                    deleteProduct(request, response);
                    break;
                case "/editProduct":
                    showEditFormProduct(request, response);
                    break;
                case "/updateProduct":
                    updateProduct(request, response);
                    break;
                default:
                    listProducts(request, response);
                    break;
            }  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void showNewFormProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String userID = request.getParameter("userID");

        Product newProduct = new Product(productName, description, category, price, quantity, userID);
        productDao.insertProducts(newProduct);
        response.sendRedirect("list_product");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        productDao.deleteProduct(productID);
        response.sendRedirect("list_product");
    }

    private void showEditFormProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	int productID = Integer.parseInt(request.getParameter("productID"));
        Product existingProduct = productDao.selectProduct(productID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("Product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
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
        response.sendRedirect("list_product");
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProducts = productDao.selectAllProducts();
        request.setAttribute("listProducts", listProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }
    
    

}
