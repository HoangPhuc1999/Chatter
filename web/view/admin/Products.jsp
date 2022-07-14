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

        <div class="col-sm-3 gy-3 overflow-hidden">
            <jsp:include page="Sidebar.jsp" />
        </div>
        <div class="col-sm-9 gy-2">
            <form class="input-group justify-content-end" action="/Chatter/admin/edit_product" method="get">
                <div class="form-floating">
                    <select onchange="selectForm();" onfocus="this.selectedIndex = 0;" class="form-select" name="searchtype" id="floatingSelectGrid" >
                        <option selected value="0">Product ID</option>
                        <option value="1">Product name</option>
                        <option value="2">Product price</option>
                        <option value="3">Modify date</option>
                    </select>

                    <label for="floatingSelectGrid">Search by</label>
                </div>
                <div class="form-floating"  id="searchByID" >
                    <input  type="number" class="form-control" name="productid" placeholder="ProductID" aria-label="ProductID" min="0" max="65536"  aria-describedby="button-addon2">
                    <label for="searchbar">Product ID</label>
                </div>
                <div class="form-floating col-sm-2"  id="searchByName" >
                    <input  type="text" class="form-control" name="productname" placeholder="ProductID" aria-label="ProductID" aria-describedby="button-addon2" >
                    <label for="searchbar">Product Name</label>
                </div>
                <div class="form-floating col-sm-2"  id="searchByPrice" >
                    <input  type="number" step="0.01" class="form-control" name="productprice" placeholder="ProductID" aria-label="ProductID" min="0" max="65536" aria-describedby="button-addon2">
                    <label for="searchbar">Product Price</label>
                </div>
                <div class="form-floating col-sm-2"  id="searchByDate" >
                    <input  type="date" class="form-control" name="productid" placeholder="ProductID" aria-label="ProductID" min="0" max="65536" aria-describedby="button-addon2">
                    <label for="searchbar">Modify Date</label>
                </div>
                <button class="btn btn-outline-primary fa-2x fa-duotone fa-magnifying-glass-plus" type="submit" id="button-addon2">
                </button>
            </form>

            <c:set value="${requestScope.productDetailses}" var="products"/>

            <div class="card">
                <div class="card-header">List Products${pageScope.searchtype}</div>
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
                    ${product}<br><br>
                </c:forEach>
            </div>
        </div>
        <script>
            document.getElementById('products_page').classList.add('active');
            document.getElementById('products_page').classList.remove('link-dark');
             document.getElementById("searchByID").style.display = "inline";
             document.getElementById("searchByName").style.display = "none";
             document.getElementById("searchByPrice").style.display = "none";
             document.getElementById("searchByDate").style.display = "none";

            function selectForm() {
                var type = document.getElementById("floatingSelectGrid").value;
                var byproductid = document.getElementById("searchByID");
                byproductid.style.display = type == 0 ? "inline" : "none";
                var byproductname = document.getElementById("searchByName");
                byproductname.style.display = type == 1 ? "inline" : "none";
                var byproductprice = document.getElementById("searchByPrice");
                byproductprice.style.display = type == 2 ? "inline" : "none";
                var byproductprice = document.getElementById("searchByDate");
                byproductprice.style.display = type == 3 ? "inline" : "none";
            }

            const input = document.getElementById('floatingSelectGrid');
            const image = document.getElementById('img-preview');

            input.addEventListener('change', (e) => {
                if (e.target.files.length) {
                    const src = URL.createObjectURL(e.target.files[0]);
                    image.src = src;
                }
            });

        </script>  
    </body>
</html>
