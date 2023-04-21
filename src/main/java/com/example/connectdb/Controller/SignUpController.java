package com.example.connectdb.Controller;

import com.example.connectdb.Model.DAO.ProductDAO;
import com.example.connectdb.Model.POJO.Login;
import com.example.connectdb.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUpController", value = "/signup")
public class SignUpController extends HttpServlet {

    ProductService service = new ProductService();
    ProductDAO dao = new ProductDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("user");
            String password = req.getParameter("pass");
            String email = req.getParameter("email");

            if (userName != "" && password != "" && email != "") {
                boolean account = service.insertAccount(userName, password, email);
                if (account == false) {

                    String status = "Tên đăng nhập đã tồn tại!!!!";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("Signup.jsp").forward(req, resp);
                } else {
                    String status = "Đăng ký thành công!!";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("Signup.jsp").forward(req, resp);
                }


            } else {
                String status = "Đăng ký không thành công!!";
                req.setAttribute("status", status);
                req.getRequestDispatcher("Signup.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}

