<%-- 
    Document   : loginPage
    Created on : Jan 11, 2021, 7:43:26 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hana Shop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="navbar">
                    <div class="logo">
                        <img src="images/logo1.jpg" width="125px">
                    </div>
                    <nav>
                        <ul>
                            <li><a href="homePage.jsp">Home</a></li>
                            <li><a href="MainController?btnAction=Load">Product</a></li>
                            <li><a href="">About</a></li>
                            <li><a href="">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="account-page">
                <div class="container">
                    <div class="row">
                        <div class="col-2">
                            <img src="images/sakura.jpg">
                        </div>
                        <div class="col-2">
                            <div class="form-container">
                                <div class="form-container">
                                    <div class="form-btn">
                                        <span>Login</span>
                                    </div>
                                    <form action="MainController" method="post">
                                        <p class="text-danger" role="alert">
                                            ${requestScope.LOGIN_ERROR}
                                        </p>
                                        <input type="text" name="txtUserID" placeholder="UserID" required>
                                        <input type="password" name="txtPassword" placeholder="Password" required>
                                        <button type="submit" name="btnAction" value="Login" class="btn">Login</button>
                                        <a href="">Forgot Password</a> <br/>
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Assignment1_TranDongHuuPhu/Login-google&response_type=code
                                           &client_id=288720029751-fst8bgnrs8odh0iqdhi3potcs2grcf83.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
    </body>
</html>
