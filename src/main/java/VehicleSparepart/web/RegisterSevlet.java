package VehicleSparepart.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VehicleSparepart.dao.UserDao;
import VehicleSparepart.model.User;


@WebServlet("/RegisterSevlet")
public class RegisterSevlet extends HttpServlet {
	private UserDao userDao;

    public RegisterSevlet() {
        this.userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            insertByUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void insertByUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        User newUser = new User(name, email, phoneNumber, address, password);
        userDao.insertUsers(newUser);
        response.sendRedirect("signin-signup.jsp");
    }

}
