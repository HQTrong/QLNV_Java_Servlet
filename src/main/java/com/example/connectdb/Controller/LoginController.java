package com.example.connectdb.Controller;

import com.example.connectdb.Model.DAO.ProductDAO;
import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.POJO.Login;
import com.example.connectdb.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "accountServlet", value = "/login")
public class LoginController extends HttpServlet {
    ProductService service = new ProductService();
    ProductDAO dao = new ProductDAO();
    List<Employee> list = null;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("user");
            String password = req.getParameter("pass");
            Login user = service.getUser(userName);
            if (user.getUser() != null) {

                if (user.getPass().equals(password)) {
                    list = service.getEmployee();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("Show.jsp").forward(req, resp);
                } else {
                    //sai password
                    String status = "Mật khẩu không chính xác!!";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
                }

            } else {
                // sai username
                String status = "Tên đăng nhập không chính xác!!";
                req.setAttribute("status", status);
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}
