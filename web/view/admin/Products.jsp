<%-- 
    Document   : ListProduct
    Created on : Jun 15, 2022, 11:09:38 AM
    Author     : Tuan Phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/favicon.png" type="">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>
        <style>

            img:hover {
                box-shadow: 0 0 4px 2px rgba(0, 140, 186, 0.5);
            }
            .avatar {
                width: 50px;
                height: auto;
            }
        </style>

        <!-- Custom styles for this template -->
        <!--<link href="../css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <link href="../css/responsive.css" rel="stylesheet" />
        <link href="/Chatter/css/adminstyle.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body class="row">
        <div class="col-sm-3 g-3">
            <jsp:include page="Sidebar.jsp" />
        </div>
        <div class="col-sm-9 gy-2">
            <form class="input-group justify-content-end" action="/Chatter/admin/edit_product" method="get">
                <div class="form-floating">
                    <select class="form-select" id="floatingSelectGrid">
                        <option selected value="0">Product ID</option>
                        <option value="1">Product name</option>
                        <option value="2">Product </option>
                        <option value="3">Three</option>
                    </select>
                    <label for="floatingSelectGrid">Type of searched value</label>
                </div>
                <div class="form-floating ">
                    <input type="number" class="form-control" name="productid" id="searchbar" placeholder="ProductID" aria-label="ProductID" min="0" max="65536" aria-describedby="button-addon2">
                    <label for="searchbar">Product ID</label>
                </div>
                <button class="btn btn-outline-primary fa-2x fa-duotone fa-magnifying-glass-plus" type="submit" id="button-addon2">
                </button>
            </form>

            <c:set value="${requestScope.productDetailses}" var="products"/>

            <div class="card">
                <div class="card-header">List Products</div>
                <table class="table table-hover table-striped table-responsive-md card-body">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th class=" ">Name</th>
                            <!--<th class="col-sm-3 ">Title</th>-->
                            <!--<th class="col-sm-3 ">Description</th>-->
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Image</th>
                        </tr>
                    </thead>
                    <tbody class=" ">
                        <c:forEach items="${requestScope.productDetailses}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td><a href="/Chatter/productdetail?id=${product.id}" class="text-decoration-none text-danger" >${product.name}</a></td>
                                <!--<td>${product.title}</td>-->
                                <!--<td class="overflow-hidden">${product.description}</td>-->
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td><img class="avatar" src="/Chatter/${product.image}" alt="product ${product.name} image"/></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
                <c:forEach items="${requestScope.productDetailses}" var="product">
                    ${product}<br>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
