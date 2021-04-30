<%-- 
    Document   : createProduct
    Created on : Jan 18, 2021, 3:05:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Create Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
    <body>
        <c:set var="categoryMap" value="${sessionScope.CATEGORY_MAP}"/> 
        <c:set var="error" value="${requestScope.ERROR}"></c:set>
        <c:if test="${requestScope.SUCCESS != null}">
            <script>
                window.window.alert("${requestScope.SUCCESS}");
            </script>
        </c:if>
            <form action="MainController" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin" method="POST">
                <h2 class="w3-center">Create new Product</h2>

                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-hotel"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" type="text" name="txtProductID" value="${param.txtProductID}" placeholder="Product ID" required/>${error.productIDError}
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-hotel"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" type="text" name="txtProductName" value="${param.txtProductName}" placeholder="Product Name" required/>
                </div>
            </div>
            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fas fa-window-restore"></i></div>
                <div class="form-row align-items-center">
                    <div class="col-auto my-1">
                        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="txtCategory">
                            <c:forEach var="entry" items="${categoryMap}">
                                <option value="${entry.key}" <c:if test="${product.category eq entry.key}"> selected</c:if>>${entry.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-tags"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" type="text" name="txtPrice" value="${param.txtPrice}" placeholder="Price" required/>${error.priceError}
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-audio-description"></i></div>
                <div class="w3-rest">
                    <textarea class="w3-input w3-border" name="txtDescription" value="${param.txtDescription}" placeholder="Drescription" maxlength="300"></textarea>
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fas fa-sort-amount-up-alt"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" type="number" name="txtQuantity" value="${param.txtQuantity}" min ="1" placeholder="Quantity" required/>${error.quantityError}
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px"><i class="w3-xxlarge fas fa-images"></i></div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" type="text" name="txtImage" value="${param.txtImage}" placeholder="Link Image" maxlength="500" required/>${error.imageError}
                </div>
            </div>

            <p class="w3-center">
                <input type="submit" name="btnAction" value="Create" class="w3-button w3-section w3-blue w3-ripple"/>
                <input class="w3-button w3-section w3-blue w3-ripple" type="reset" value="Reset"/>
                <a href="admin.jsp" class="w3-button w3-section w3-blue w3-ripple">Back</a>
            </p>
        </form>

    </body>
</html>
