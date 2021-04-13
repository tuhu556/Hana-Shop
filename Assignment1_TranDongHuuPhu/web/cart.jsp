<%-- 
    Document   : cart
    Created on : Jan 14, 2021, 7:40:40 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hana Shop</title>
        <link rel="stylesheet" type="text/css" href="css/product.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <jsp:include page="menu.jsp"/>
        </header>
        <!---------body--------->
        <main>
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:set var="totalPrice" value="${0}"/>

            <c:if test="${cart != null}">
                <c:if test="${not empty cart}">


                    <table class="table" border="1" id="customers">
                        <thead>
                            <tr>
                                <th>NO.</th>
                                <th>Product Id</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${cart.getCart()}" varStatus="counter">
                            <form action="MainController">
                                <p class="text-danger" role="alert">${requestScope.ERROR_CART}</p>
                                <tr>
                                <input type="hidden" name="txtProductID" value="${order.value.ID}"/>
                                <td>${counter.count}</td>
                                <td>${order.value.ID}</td>
                                <td>${order.value.name}</td>
                                <td><input type="number"  name="txtQuantity" value="${order.value.quantity}" min="1" /></td>
                                <td>${order.value.price}</td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update"/>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Delete"/>
                                </td>
                                </tr>
                                <c:set var="totalPrice" value="${totalPrice + order.value.price*order.value.quantity}"/>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        <h2>TOTAL PRICE: <c:out value="${totalPrice}"/>
                        </h2>
                    </div>
                    <c:if test="${requestScope.ERROR_CART ==  NULL}">
                        <form action="MainController" method="POST">
                            <input name="btnAction" value="Confirm" type="submit" class="button">
                        </form>
                    </c:if>

                </c:if>
            </c:if>
        </main>
        <!---------footer--------->
        <div class="footer">
            <div class="container1">
                <div class="row1">
                    <div class="foooter-col-1">
                        <h3>Download Our App</h3>
                    </div>
                    <div class="foooter-col-2">
                        <img src="images/logo.jpg" width="125px" >
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
    </body>
</html>
