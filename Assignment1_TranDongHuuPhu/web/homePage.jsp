<%-- 
    Document   : homePage
    Created on : Jan 11, 2021, 7:43:08 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hana Shop</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <jsp:include page="menu.jsp"/>
        </header>
        <main>
            <div class="offer">
                <div class="small-container">
                    <div class="row">
                        <div class="col-2">
                            <img src="images/food.jpg">
                        </div>
                        <div class="col-2">
                            <img src="images/drink.jpg">
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <hr>
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
    </body>
</html>
