package VehicleSparepart.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VehicleSparepart.dao.DBConnect;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("password");
        HttpSession session = request.getSession();

        Connection con = null;
        try {
            con = DBConnect.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
            pst.setString(1, uemail);
            pst.setString(2, upwd);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                session.setAttribute("name", rs.getString("name"));
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("userID", rs.getString("userID"));
                request.getRequestDispatcher("user-dash.jsp").forward(request, response);
            } else if ("admin@gmail.com".equals(uemail) && "admin".equals(upwd)) {
                session.setAttribute("name", "Admin");
                session.setAttribute("email", uemail);
                session.setAttribute("userID", "admin");
                request.getRequestDispatcher("admin-dash.jsp").forward(request, response);
            } else {
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("signin-signup.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
