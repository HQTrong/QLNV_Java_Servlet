package com.example.connectdb.Controller;

import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Search", value = "/search")

public class SearchController extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = null;
        String employeeId = req.getParameter("employee_id");
        String name = req.getParameter("name");

        {
            try {
                if (employeeId.isEmpty() && name.isEmpty()) {
                    list = service.getEmployee();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Show.jsp").forward(req, resp);
                } else if (name.isEmpty()) {
                    Employee employee = service.getEmployeeByID(employeeId);
                    req.setAttribute("employee", employee);
                    req.getRequestDispatcher("/Show.jsp").forward(req, resp);
                } else if (employeeId.isEmpty()) {
                    list = service.getEmployeeByName(name);
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Show.jsp").forward(req, resp);
                } else {
                    Employee employee = service.getEmployeeByName_ID(name, employeeId);
                    req.setAttribute("employee", employee);
                    req.getRequestDispatcher("/Show.jsp").forward(req, resp);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void destroy() {
    }
}
