package com.example.connectdb.Controller;

import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "Sort",value = "/sort")
public class SortController extends HttpServlet {
    ProductService service= new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            List<Employee> list = null;
            list=service.Sort();
            req.setAttribute("list",list);
            req.getRequestDispatcher("/Show.jsp").forward(req,resp);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
