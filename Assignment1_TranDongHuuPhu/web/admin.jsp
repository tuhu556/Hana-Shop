<%-- 
    Document   : admin
    Created on : Jan 16, 2021, 11:19:22 PM
    Author     : Admin
--%>
<%@page import="dao.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <header>
          <div class="header">
            <div class="container">
                <div class="navbar">
                    <div class="logo">
                        <img src="images/logo1.jpg" width="125px">
                    </div>
                    <nav>
                        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="admin.jsp" class="nav-link px-2 link-dark">Home</a></li>
                            <li><a href="MainController?btnAction=LoadProductAdmin" class="nav-link px-2 link-dark">Manage Products</a></li>
                            <li><a href="createProduct.jsp" class="nav-link px-2 link-dark">Create Product</a></li>
                            <li><a href="MainController?btnAction=Logout" class="nav-link px-2 link-dark">Logout</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="row">
            </div>
        </div>  
        </header>
        <main>
            <br>
            <center>
                <h2>Administrator: ${sessionScope.LOGIN_USER.fullName}</h2>
            </center>
        </main>
    </body>
</html>
