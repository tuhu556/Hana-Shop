<%-- 
    Document   : menu
    Created on : Apr 7, 2021, 11:05:43 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <div class="container1">
        <div class="navbar">
            <div class="logo">
                <img src="images/logo1.jpg" width="125px">
            </div>
            <nav>
                <c:set var="user" value="${sessionScope.LOGIN_USER}"/>
                <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="homePage.jsp" class="nav-link px-2 link-dark">Home</a></li>
                    <li><a href="MainController?btnAction=Load" class="nav-link px-2 link-dark">Product</a></li>
                    <li><a href="" class="nav-link px-2 link-dark">About</a></li>
                    <li><a href="" class="nav-link px-2 link-dark">Contact</a></li>
                        <c:if test="${user == null}">
                        <li><a href="loginPage.jsp" class="nav-link px-2 link-dark">Login</a></li>
                        </c:if>
                        <c:if test="${user != null}">
                        <li class="nav-link px-2 text-secondary">${sessionScope.LOGIN_USER.fullName}</li>
                        <li><a href="MainController?btnAction=Logout" class="nav-link px-2 link-dark">Logout</a></li>
                        <li><a href="MainController?btnAction=OrderHistory" class="nav-link px-2 link-dark">History Order</a></li>
                        <li><a href="cart.jsp" class="nav-link px-2 link-dark"><img src="images/cart.png" width="36px"></a></li>
                            </c:if>
                </ul>
            </nav>
        </div>
    </div>
    <div class="row1">
        <div class="col2">
            <h1>Let's discovery <br>and enjoy!</h1>
        </div>
        <div class="col2">
            <img src="images/sakura.jpg">
        </div>
    </div>
</div>
