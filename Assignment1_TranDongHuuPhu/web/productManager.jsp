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
        <title>ProductManager</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
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
                        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="admin.jsp" class="nav-link px-2 link-dark">Home</a></li>
                            <li><a href="MainController?btnAction=LoadProductAdmin" class="nav-link px-2 link-dark">Manage Products</a></li>
                            <li><a href="createProduct.jsp" class="nav-link px-2 link-dark">Create Product</a></li>
                            <li><a href="MainController?btnAction=Logout" class="nav-link px-2 link-dark">Logout</a></li>
                            <li><a href="#"><img src="images/cart.png" width="36px" ></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="row">
            </div>
        </div>
        <!---------offer--------->
        <div class="offer">
            <h1>Admin: ${sessionScope.LOGIN_USER.fullName} </h1>
            <c:set var="categoryMap" value="${sessionScope.CATEGORY_MAP}"/> 
            <center>
                <form action="MainController">
                    Search: <input type="text" name="txtSearch" value="${param.search}" class="search"/>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="txtCategory">
                        <option value="All">All</option>
                        <c:forEach var="entry" items="${categoryMap}">
                            <option value="${entry.key}" <c:if test="${requestScope.category eq entry.key}"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" name="btnAction" value="SearchProduct"/>
                </form>
            </center>
            <hr>

            <c:set var="list" value="${requestScope.LIST}"></c:set>
            <c:if test="${list!=null}">
                <c:if test="${not empty list}">
                    <form action="MainController" method="POST">
                        <center>${requestScope.ERROR.nameError} ${requestScope.ERROR.priceError} ${requestScope.ERROR.descriptionError}</center>
                        <table border="1" class="table">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Product ID</th>
                                    <th>Category</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Description</th>
                                    <th>Quantity</th>
                                    <th>Link-Image</th>
                                    <th>Create Date</th>
                                    <th>Update Date</th>
                                    <th>Status</th>
                                    <th>Update</th>
                                    <th><input type="submit" name="btnAction" value="DeletePro"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${list}" varStatus="counter">
                                    <tr>
                                <form action="MainController" method="POST">
                                    <td>${counter.count}</td>
                                    <td>${product.ID}</td>
                                    <td><select id="categoryCmb" name="txtCategory">
                                            <c:forEach var="entry" items="${categoryMap}">
                                                <option value="${entry.key}" <c:if test="${product.category eq entry.key}"> selected</c:if>>${entry.value}</option>
                                            </c:forEach>
                                        </select></td>
                                    <td><input type="text" name="txtProductName" value="${product.name}" required=""></td>
                                    <td><input type="text" name="txtPrice" min="1" value="${product.price}" required=""></td>
                                    <td><input type="text" name="txtDescription" value="${product.description}"></td>
                                    <td><input type="number" name="txtQuantity" min="1" value="${product.quantity}" required=""></td>
                                    <td><input type="url" name="txtImage" value="${product.image}"></td>
                                    <td>${product.createDate}</td>
                                    <td>${product.updateDate}</td>

                                    <td>
                                        <input type="checkbox" name="txtStatus" <c:if test="${product.status}">checked</c:if> ></td>

                                        <td>
                                            <input type="hidden" name="txtProductID" value="${product.ID}">
                                        <input type="submit" name="btnAction" value="UpdatePro">
                                    </td>
                                </form>
                                <td>
                                    <input type="checkbox" name="txtSelectedProduct" value="${product.ID}"> 
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                    <br
                        <!---------paging-------->
                        <div class="paging">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${requestScope.totalPages}" var="i">
                                    <c:url var="page" value="SearchController">
                                        <c:param name="btnAction" value="Search"></c:param>
                                        <c:param name="txtSearch" value="${requestScope.search}"></c:param>
                                        <c:param name="txtCategory" value="${requestScope.category}"></c:param>
                                        <c:param name="index" value="${i}"></c:param>
                                    </c:url>
                                    <li class="page-item" ${indexPage==i?"active":""}><a class="page-link" href=${page}>${i}</a></li>

                                </c:forEach>

                            </ul>
                        </nav>
                    </div>
                </c:if>
            </c:if>
        </div>
    </body>
</html>
