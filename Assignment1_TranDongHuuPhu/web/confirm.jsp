<%-- 
    Document   : confirm
    Created on : Jan 16, 2021, 6:51:35 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hana Shop</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <header>
            <jsp:include page="menu.jsp"/>
        </header>
        <!---------offer--------->
        <main>
            <center>
                <h1>${requestScope.CONFIRM}</h1>
            </center>
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