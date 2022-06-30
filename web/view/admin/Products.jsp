<%-- 
    Document   : ListProduct
    Created on : Jun 15, 2022, 11:09:38 AM
    Author     : Tuan Phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.productDetailses}<br><br><br><br><br><br><br><br>
        <c:forEach items="${requestScope.productDetailses}" var="product">
            ${product.toString()} <br><br>
        </c:forEach>
    </body>
</html>
