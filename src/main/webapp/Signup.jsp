<%--
  Created by IntelliJ IDEA.
  User: TRONG
  Date: 2/22/2023
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign Up</title>
    <link href="css/my.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
            rel="stylesheet"
    />
</head>
<body style="background-image: url(https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm222batch5-kul-03.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=08fbfb223887d33030e97becaf4e20dc); background-repeat: no-repeat; background-size:100%;">
<div class="signup-box">
    <h1>Sign Up</h1>
    <h5 style="color: red">${status}
        <h5>
            <form action="signup" method="post">
                <label>User Name </label>
                <input type="text" placeholder="User Name" name="user"/>
                <label>Email </label>
                <input type="email" placeholder="User Name" name="email"/>
                <label>Password </label>
                <input type="password" placeholder="Password" name="pass"/>
                <button>SignUp</button>
                <p>
                    Already have an account? <a href="Login.jsp">Sign Up Here</a>
                </p>
            </form>
</div>
</body>
</html>






