<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.connectdb.Model.DAO.ProductDAO" %>
<%@ page import="com.example.connectdb.Model.POJO.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <link href="css/my.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
            rel="stylesheet"
    />
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<div class="login-box">
    <h1>Login</h1>
    <h5 style="color: red">${status}</h5>
    <form action="login" method="post">
        <label>User Name </label>
        <input type="text" placeholder="User Name" name="user"/>
        <label>Password </label>
        <input type="password" placeholder="Password" name="pass"/>
        <button>Login</button>
        <p>
            Not have an account? <a href="Signup.jsp">Sign Up Here</a>
        </p>
    </form>
</div>
</body>
</html>