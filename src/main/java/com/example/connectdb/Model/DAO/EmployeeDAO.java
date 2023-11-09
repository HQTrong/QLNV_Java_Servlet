package com.example.connectdb.Model.DAO;

import com.example.connectdb.Client.postgresDB;
import com.example.connectdb.Model.POJO.Employee;
import com.example.connectdb.Model.POJO.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    postgresDB db = new postgresDB();

    public List<Login> getInfor() throws SQLException {
        List<Login> list = new ArrayList<>();
        Statement stmt = null;
        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select user from login;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Login u = new Login();
                u.setUser(rs.getString(1));
                u.setPass(rs.getString(2));
                list.add(u);
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;

    }




    public Login getUser(String userName) throws SQLException {
        Login u = new Login();
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "select * from account where username=?;";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                u.setUser(rs.getString(1));
                u.setPass(rs.getString(2));
                u.setEmail(rs.getString(3));
            }
            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return u;

    }


    public boolean insertAccount(String userName, String pass, String email) throws SQLException {
        Login u = new Login();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into account(username,pass,email)" + "values (?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, email);
            is = true;
            ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.executeUpdate(sql);

            rs.close();
            c.close();


        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return is;

    }

    public boolean insertEmployee(String employeeId, String name, String birthday, String phone, String address, String departmentId) throws SQLException {
        Employee employee = new Employee();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into employee(employee_id,name,birthday,phone,address,department_id)" + "values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, birthday);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, departmentId);
            is = true;
            ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.executeUpdate(sql);

            rs.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }

    public Employee getEmployeeByID(String employeeId) throws SQLException {
        Employee employee = new Employee();
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB(); // connect
            String sql="select employee_id,name,birthday,phone,address,department_name from employee e join department d on e.department_id =d.department_id and e.employee_id =?;";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                employee.setEmployeeId(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setBirthday(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setDepartmentName(rs.getString(6));
            }
            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return employee;

    }

    public List<Employee> getEmployeeByName(String name) throws SQLException {
        List<Employee> list = new ArrayList<>();

        //PreparedStatement preparedStatement = null;
        Statement stmt = null;
        try {
            Connection c = db.connectDB(); // connect
            // String sql = "select * from employee where name=?;";
            String sql="select employee_id,name,birthday,phone,address,department_name from employee e join department d on e.department_id =d.department_id and name LIKE '%" + name + "%';";
            //preparedStatement = c.prepareStatement(sql);
            stmt = c.createStatement();
            //preparedStatement.setString(1,name);
            //ResultSet rs = preparedStatement.executeQuery();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setBirthday(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setDepartmentName(rs.getString(6));
                list.add(employee);
            }
            stmt.close();
            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;

    }

    public Employee getEmployeeByName_ID(String name, String employeeId) throws SQLException {
        Employee employee = new Employee();
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB();
            String sql = "select employee_id,name,birthday,phone,address,department_name from employee e join department d on e.department_id =d.department_id and name LIKE '%" + name + "%' and employee_id=?;";
            preparedStatement = c.prepareStatement(sql);
            //preparedStatement.setString(1,name);
            preparedStatement.setString(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                employee.setEmployeeId(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setBirthday(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setDepartmentName(rs.getString(6));
            }
            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return employee;

    }

    public List<Employee> getEmployee() throws SQLException {
        List<Employee> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();
            String sql ="select employee_id,name,birthday,phone,address,department_name from employee e join department d on e.department_id =d.department_id ; ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setBirthday(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setDepartmentName(rs.getString(6));
                list.add(employee);
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;
    }
    public List<Employee> Sort() throws SQLException{
        List<Employee> list=new ArrayList<>();
        Statement stmt = null;
        try
        {
            Connection c = db.connectDB();
            stmt =c.createStatement();
            String sql="select employee_id,name,birthday,phone,address,department_name from employee e join department d on e.department_id =d.department_id  order by employee_id;";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next())
            {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString(1));
                employee.setName(rs.getString(2));
                employee.setBirthday(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setDepartmentName(rs.getString(6));
                list.add(employee);
            }

        }catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;
    }

    public boolean remove(String employeeId) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB();
            String sql = "delete from  employee where employee_id=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }

    public boolean upDate(String employeeId, String name, String birthday, String phone, String address, String departmentId) throws SQLException {
        Employee employee = new Employee();
        PreparedStatement preparedStatement = null;
        boolean is = false;
        try {
            Connection c = db.connectDB();
            String sql = "UPDATE employee\n" +
                    "SET name=?,birthday =?,phone=?,address =?,department_id=?\n" +
                    "WHERE employee_id=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, birthday);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, departmentId);
            preparedStatement.setString(6, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            rs.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }
public List<Employee> getDepartment() throws SQLException{
        List<Employee> list = new ArrayList<>();
        Statement stmt =null;
        try
        {
           Connection c= db.connectDB();
            stmt =c.createStatement();
            String sql = "select department_id,department_name from department;";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next())
            {
                Employee employee = new Employee();
                employee.setDepartmentId(rs.getString(1));
                employee.setDepartmentName(rs.getString(2));
                list.add(employee);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;
}
}
