package com.example.connectdb.Model.Service;

import com.example.connectdb.Model.DAO.ProductDAO;
import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.POJO.Login;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDAO dao = new ProductDAO();
    public Login getUser(String userName) throws SQLException {
        Login user = dao.getUser(userName);
        return user != null ? user : null;
    }

    public boolean insertAccount(String userName, String pass, String email) throws SQLException {

        Login user = dao.getUser(userName);

        if ((user.getUser()) == null) {
            boolean account = dao.insertAccount(userName, pass, email);

            return account == true ? account : false;
        }
        return false;

    }

    public List<Employee> getEmployee() throws SQLException {
        List<Employee> list = dao.getEmployee();
        return !list.isEmpty() ? list : null;
    }

    public List<Employee> Sort() throws SQLException {
        List<Employee> list = dao.Sort();
        return !list.isEmpty() ? list : null;
    }

    public Employee getEmployeeByID(String employeeId) throws SQLException {
        Employee employee = dao.getEmployeeByID(employeeId);
        return employee != null ? employee : null;
    }

    public Employee getEmployeeByName_ID(String name, String employeeId) throws SQLException {
        Employee employee = dao.getEmployeeByName_ID(name, employeeId);
        return employee != null ? employee : null;
    }

    public List<Employee> getEmployeeByName(String name) throws SQLException {
        List<Employee> list = dao.getEmployeeByName(name);
        return !list.isEmpty() ? list : null;
    }

    public boolean insertEmployee(String employeeId, String name, String birthday, String phone, String address, String departmentId) throws SQLException {

        Employee employee = dao.getEmployeeByID(employeeId);

        if ((employee.getEmployeeId() == null)) {
            boolean result = dao.insertEmployee(employeeId, name, birthday, phone, address, departmentId);

            return result == true ? result : false;
        }
        return false;

    }

    public boolean remove(String employeeId) throws SQLException {
        Employee employee = dao.getEmployeeByID(employeeId);
        if ((employee.getEmployeeId()) != null) {
            boolean result = dao.remove(employeeId);
            return result == true ? result : false;
        }
        return false;

    }

    public boolean upDate(String employeeId, String name, String birthday, String phone, String address, String departmentId) throws SQLException {
        Employee employee = dao.getEmployeeByID(employeeId);
        if (employee.getEmployeeId() != null) {
            boolean result = dao.upDate(employeeId, name, birthday, phone, address, departmentId);
            return result == true ? result : false;
        }
        return false;
    }

    public List<Employee> getDepartment() throws SQLException {
        List<Employee> list = dao.getDepartment();
        return !list.isEmpty() ? list : null;
    }
}
