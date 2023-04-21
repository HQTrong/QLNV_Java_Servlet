package com.example.connectdb.Controller;

import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.Service.ProductService;
import com.oracle.wls.shaded.org.apache.bcel.generic.FALOAD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.javadoc.internal.doclets.formats.html.HtmlConfiguration;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Remove", urlPatterns = "/remove")

public class RemoveController extends HttpServlet {
    ProductService service = new ProductService();
    List<Employee> list_rm = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String employeeId = req.getParameter("employeeId");
            boolean is = service.remove(employeeId);
            if (is == true) {
                list_rm = service.getEmployee();
                req.setAttribute("list", list_rm);
                req.getRequestDispatcher("/Show.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
