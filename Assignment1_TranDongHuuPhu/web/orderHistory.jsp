<%-- 
    Document   : historyOrder
    Created on : Jan 19, 2021, 2:26:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Order History</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <header>
            <jsp:include page="menu.jsp"/>
        </header>
        <main>
            <!---------offer--------->
            <div class="offer">
                <c:set var="list" value="${sessionScope.HISTORY}"></c:set>
                <h1>${requestScope.ERROR}</h1>
                <c:if test="${list!=null}">
                    <c:if test="${not empty list}">
                        <h1>Your history orders:</h1>
                        <table class="table" id="customers">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Order Date</th>
                                    <th>Total price</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="order" items="${list}" varStatus="counter">
                                <form action="MainController" method="POST">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${order.orderDate}</td>
                                        <td>${order.totalPrice}</td>
                                        <td><a href="MainController?btnAction=OrderDetail&orderID=${order.orderID}">Detail</a></td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </c:if>
                <a href="homePage.jsp" class="button">Back</a>
            </div>
            <!---------foooter--------->
            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="foooter-col-1">
                            <h3>Download Our App</h3>
                        </div>
                        <div class="foooter-col-2">
                            <img src="images/logo.jpg" width="125px">
                        </div>
                        <div class="foooter-col-3">
                            <ul>
                                <li>Blog</li>
                                <li>Policy</li>
                            </ul>
                        </div>
                        <div class="foooter-col-4">
                            <h3>Contact with us</h3>
                            <ul>
                                <li>Facebook</li>
                                <li>Twitter</li>
                                <li>Instagram</li>
                                <li>Youtube</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
