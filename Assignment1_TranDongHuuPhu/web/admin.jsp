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
    </head>
    <body>
    <body>
        <div class="header">
            <div class="container">
                <div class="navbar">
                    <div class="logo">
                        <img src="images/logo1.jpg" width="125px">
                    </div>
                    <nav>
                        <ul>
                            <li><a href="admin.jsp">Home</a></li>
                            <li><a href="MainController?btnAction=LoadProductAdmin">Manage Products</a></li>
                            <li><a href="createProduct.jsp">Create Product</a></li>
                            <li><a href="MainController?btnAction=Logout">Logout</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="row">
            </div>
        </div>
    </body>
</html>
