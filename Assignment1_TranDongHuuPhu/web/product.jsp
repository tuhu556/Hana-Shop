<%-- 
    Document   : product
    Created on : Jan 11, 2021, 7:43:16 AM
    Author     : Admin
--%>

<%@page import="dao.ProductDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <main>
            <hr>
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
                    <input type="submit" name="btnAction" value="Search"/>
                </form>
            </center>
            <div class="container">
                <div class="row">
                    <c:forEach items="${listProduct}" var="item">
                        <div class="col-md-3 col-sm-6">
                            <div class="product-grid2">
                                <div class="product-image2">
                                    <a href="#">
                                        <img class="pic-1" src="${item.image}" width="100px" height="250px">
                                        <img class="pic-2" src="${item.image}" width="100px" height="250px">
                                    </a>
                                    <c:url var="add" value="MainController">
                                        <c:param name="btnAction" value="Add"/>
                                        <c:param name="txtProductID" value="${item.ID}"/>
                                        <c:param name="txtProductName" value="${item.name}"/>
                                        <c:param name="txtPrice" value="${item.price}"/>
                                        <c:param name="txtCategory" value="${item.category}"/>
                                    </c:url>
                                    <a class="add-to-cart" href="${add}">Add to cart</a>
                                </div>
                                <div class="product-content">
                                    <h3 class="title"><a href="#">${item.name}</a></h3>
                                    <span class="price">${item.price} $</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!---------paging-------->
                <div class="paging">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:forEach begin="1" end="${requestScope.totalPages}" var="i">
                                <c:url var="page" value="SearchProductController">
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

            </div>
        </main>
        <hr>
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
