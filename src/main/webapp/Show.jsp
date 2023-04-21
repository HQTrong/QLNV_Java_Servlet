<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 3/17/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Admin</title>
    <style>
        a{
            text-decoration: none;
            color: white;
        }

        button {
            border-radius: 15px 15px 15px 15px;
        }

        table, th, td {
            border: 1px solid black;
            /*border-collapse: collapse;*/
        }
        label
        {
            font-weight: 600;
        }
    </style>
    <script type="text/javascript"></script>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<center style="padding-top: 30px">
    <h1>CHÀO MỪNG BẠN ĐẾN VỚI TRANG ADMIN</h1>
    <h3>${status}</h3>
    <form method="get" action="search">
        <label>Employee ID: </label>
        <input type="text" placeholder="" name="employee_id"/>
        <label>Name: </label>
        <input type="tetx" placeholder="" name="name"/>
        <button style="background-color: greenyellow;"><b>Search</b></button>
    </form>
    <button style="background-color: blue;"><a href="add"><b>Create Employee</b></a></button>
    <button style="background-color: blue;"><a href="sort"><b>Sort Staff ID</b></a></button>
            <table>
                <tr>
                    <th>Staff ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Department Name</th>

                </tr>
                <c:choose>
                <c:when test="${list!=null}">
                <c:forEach items="${list}" var="sp" >
                    <tr>
                        <td>${sp.employeeId}</td>
                        <td>${sp.name}</td>
                        <td>${sp.birthday}</td>
                        <td>${sp.phone}</td>
                        <td>${sp.address}</td>
                        <td>${sp.departmentName}</td>
                        <td>
                            <button style="background-color: blue;"><a href="update?employeeId=${sp.employeeId}"><b>Update</b></a>
                            </button>
                            <button style="background-color: red;"><a href="#" onclick="ShowMess('${sp.employeeId}')"><b>Delete</b></a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${employee!=null}">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.name}</td>
                    <td>${employee.birthday}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.address}</td>
                    <td>${employee.departmentName}</td>
                    <td>
                        <button style="background-color: blue;"><a
                                href="update?employeeId=${employee.employeeId}"><b>Update</b></a></button>
                        <button style="background-color: red;"><a href="#" onclick="ShowMess('${employee.employeeId}')"><b>Delete</b></a>
                        </button>
                    </td>
                </tr>

            </table>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>

</center>

</body>
<script type="text/javascript">
    function ShowMess(employeeId) {
        var option = confirm('Bạn có đồng ý xóa thông tin nhân viên!!');
        if (option === true) {
            window.location.href = 'remove?employeeId=' + employeeId;
        }
    }

</script>

</html>
