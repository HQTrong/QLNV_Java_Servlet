package com.example.connectdb.Controller;

import com.example.connectdb.Model.DAO.ProductDAO;
import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.List;
@WebServlet(name = "UpDate", value = "/update")

public class UpDateController extends HttpServlet {
    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String employeeId = req.getParameter("employeeId");
            Employee empl = service.getEmployeeByID(employeeId);
            List<Employee> list = service.getDepartment();
            req.setAttribute("empl", empl);
            req.setAttribute("list", list);
            req.getRequestDispatcher("Update.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String employeeId = req.getParameter("employee_id");
            String name = req.getParameter("name");
            String birthday = req.getParameter("birthday");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");

            String departmentId =req.getParameter("department_name");


            boolean employee = service.upDate(employeeId, name, birthday, phone, address, departmentId);
            if (employee == true) {
                List<Employee> list = service.getEmployee();
                req.setAttribute("list", list);
                req.getRequestDispatcher("Show.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
