
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="../images/favicon.png" type="">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>


        <!-- Custom styles for this template -->
        <!--<link href="../css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <!--<link href="../css/responsive.css" rel="stylesheet" />-->
        <link href="/Chatter/css/adminstyle.css" rel="stylesheet" />
        <style>
            img:hover {
                box-shadow: 0 0 4px 2px rgba(0, 140, 186, 0.5);
            }
        </style>

        <title> Edit Product </title>

    </head>
    <body class="row main_content">


        <div class="col-sm-3 g-2 overflow-hidden">
            <jsp:include page="Sidebar.jsp" />
        </div>

        <div class="col-9 gy-2">
            <form class="input-group justify-content-end" action="/Chatter/admin/edit_product" method="get">
                <div class="form-floating">
                    <input type="number" class="form-control" name="productid" id="searchbar" placeholder="ProductID" aria-label="ProductID" min="0" max="65536" aria-describedby="button-addon2">
                    <label for="searchbar">Product ID</label>
                </div>
                <button class="btn btn-outline-primary fa-2x fa-duotone fa-magnifying-glass-plus" type="submit" id="button-addon2">
                </button>
            </form>

            <h3 class="text-info" >
                <span class="text-info fa-duotone fa-candy-corn"></span>
                Edit product
            </h3>
            <c:set var = "product" scope = "session" value = "${requestScope.product}"/>
            <c:if test="${product == null}">
                <p >
                    <em><mark><strong class="lead text-secondary ">Product not found!</strong></mark></em>
                </p>
            </c:if>
            <c:if test="${product != null}">

                <p class="h5 text-danger">
                    ${product.name} <em class="display-6 blockquote-footer">(Product ID: ${product.id})</em>
                </p>

                <div class="form_container g-lg-6">
                    <form action="edit_product" method="POST" class="row g-3 form-control" enctype="multipart/form-data" >
                        <div class="row">
                            <div class="col-md-6">
                                <label for="inputProductname" class="col-form-label">Product name</label>
                                <input id="productname"  name="productname" value="${product.name}" type="text" class="form-control" placeholder="Enter the product name" onkeyup="checkProductName()" required autofocus>
                                <span id="dumlicate_productname"></span>
                            </div> 
                            <div class="col-md-2">
                                <label for="inputQuantity" class=" col-form-label">Quantity</label>
                                <input id="inputQuantity" name="quantity" value="${product.quantity}" type="number" class="form-control" placeholder="" min="0" max="65536">
                            </div>
                            <div class="col-md-3">
                                <label for="inputPrice" class="col-form-label">Product price</label>
                                <div class="btn-group">
                                    <input id="inputPrice" name="price" value="${product.price}"  type="number" step="0.01" class="form-control" min="0" max="65536" title="Please input a number!" placeholder="">
                                    <span class="input-group-text" id="basic-addon2">$</span>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <label for="inputTitle" class="col-sm-2 col-form-label">Title</label>
                                <input id="inputTitle" name="title" value="${product.title}"  type="text" class="form-control" placeholder="Example title" required value="">
                            </div>

                            <div class="col">
                            </div>

                            <div class="col-md-6 p-3">
                                <label for="inputDescription" class="col-sm-2 col-form-label">Description </label>
                                <textarea id="inputDescription" name="description"
                                          type="text" class="form-control" placeholder="Enter product description" required>${product.description}</textarea>

                            </div>
                            <div class="col-md-6">
                            </div>

                            <div class="g-0 p-3">

                                <label class="form-check-label" for="form-check">
                                    Category 
                                </label>
                                <c:forEach items="${requestScope.categorys}" var="category">
                                    <c:set var="checked" value=""></c:set>
                                    <c:forEach items="${product.categorys}" var="pcategory">
                                        <c:if test="${category.cid eq pcategory.cid}">
                                            <c:set var="checked" value="checked"></c:set>
                                        </c:if>
                                    </c:forEach>
                                    <input type="checkbox" class="btn-check" ${checked} name="category" value="${category.cid}" id="btnradio${category.cid}">
                                    <label class="btn btn-outline-primary rounded-pill" for="btnradio${category.cid}">${category.cname}</label>
                                </c:forEach>
                            </div>

                            <div class="col-md-6">
                                <label for="formFile" class="form-label">Product Image</label>
                                <input accept="image/*" class="form-control" type="file" id="formFile" name="image">
                                <img id="img-preview" class="img-thumbnail" src="/Chatter/${product.image}" />
                            </div>
                        </div>

                        <div class="text-center">
                            <input id="inputTitle" name="productid" value="${product.id}"  type="hidden">

                            <button class="btn btn-box btn-outline-success col-2" type="submit" id="add-product">
                                Edit Product
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>

        <div class=" text-bg-dark g-md-2 row" >
            <div class="col-2">
            </div>
            <div class="col-10">
                <br>
                <jsp:include page="../../Footer.jsp" />
            </div>
        </div>
        <script>
            document.getElementById('products_page').classList.add('active');
            document.getElementById('products_page').classList.remove('link-dark');



            const input = document.getElementById('formFile');
            const image = document.getElementById('img-preview');

            input.addEventListener('change', (e) => {
                if (e.target.files.length) {
                    const src = URL.createObjectURL(e.target.files[0]);
                    image.src = src;
                }
            });

        </script>  

    </body>
