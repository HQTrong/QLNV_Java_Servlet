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

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Add", value = "/add")
public class AddController extends HttpServlet {
    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> listdp = service.getDepartment();
            req.setAttribute("listdp", listdp);
            req.getRequestDispatcher("Add.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> list = null;
            List<Employee> listdp = service.getDepartment();
            String employeeId = req.getParameter("employee_id");
            String name = req.getParameter("name");
            String birthday = req.getParameter("birthday");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String departmentId =req.getParameter("department_name");
            if (employeeId != "" && name != "" && birthday != "" && phone != "" && address != "") {

                boolean employee = service.insertEmployee(employeeId, name, birthday, phone, address, departmentId);
                if (employee == false) {


                    String status = "Employee ID đã tồn tại. Vui lòng nhập lại!!";
                    req.setAttribute("status", status);
                    req.setAttribute("listdp", listdp);
                    req.getRequestDispatcher("Add.jsp").forward(req, resp);
                } else {
                    String status = "Thêm nhân viên thành công!!";
                    list = service.getEmployee();
                    req.setAttribute("status", status);
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("Show.jsp").forward(req, resp);
                }

            } else {
                String status = "Thêm nhân viên không thành công!!";
                req.setAttribute("status", status);
                req.setAttribute("listdp", listdp);
                req.getRequestDispatcher("Add.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
