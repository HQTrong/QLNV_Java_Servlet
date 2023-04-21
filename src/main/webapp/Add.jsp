<%--
  Created by IntelliJ IDEA.
  User: HQ_TRỌNG
  Date: 3/15/2023
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ADD</title>
    <style>
        button {
            border-radius: 15px 15px 15px 15px;
        }

        table,
        th,
        td {
            border: 1px solid black;
            /*border-collapse: collapse;*/
        }

        .add {
            display: flex;
            justify-content: flex-start;
            flex-direction: column;
            padding-left: 45%;
        }

        label, input,option,select {
            height: 30px;
            width: 200px;
            text-align: left;
            font-size: 20px;
        }

        label {
            font-weight: 600;
        }

        button {
            height: 30px;
            width: 200px;
            text-align: center;
            font-size: 20px;
        }

        h2 {
            padding-top: 80px;
            text-align: center;
            font-size: 50px;
        }
        h3{
            color: red;
        }
    </style>
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<h2>Create Employee</h2>
<form action="add" method="post">
    <div class="add">
        <label>Employee ID: </label>
        <input type="text" placeholder="" name="employee_id"/>

        <label>Name: </label>
        <input type="tetx" placeholder="" name="name"/>

        <label>Birthday: </label>
        <input type="text" name="birthday">

        <label> Number phone: </label>
        <input type="text" name="phone">

        <label>Address: </label>
        <input type="text" name="address">
        <label> Department name: </label>
        <select name="department_name">
            <c:forEach items="${listdp}" var ="dp">
            <option value="${dp.departmentId}" >${dp.departmentName}</option>
            </c:forEach>
        </select> <br>
        <button style="color: white; background-color: blue; width: 100px; height: 30px"><b>Add</b></button>
    </div>
    <center>
    <h3>${status}</h3>
    </center>
</form>
</body>
</html>
