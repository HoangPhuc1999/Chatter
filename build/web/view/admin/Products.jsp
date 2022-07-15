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
                border-radius: 0 !important;
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

            <div class="row">
                <div class="col-sm-3">
                    <button class="btn btn-outline-success"  data-bs-toggle="modal" data-bs-target="#AddProductModal">
                        <i class="fa-duotone fa-blueberries"></i>
                        Add Product</button>

                    <div class="modal fade" id="AddProductModal" tabindex="-1" aria-labelledby="addProductModal" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header text-bg-success">
                                    <h5 class="modal-title" id="addProductModalLabel">Add new product</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body form_container d-flex g-lg-6">

                                    <form action="add_product" method="POST" class="row g-3 form-control" enctype="multipart/form-data" id="addFormModal" >
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label for="inputProductname" class="col-form-label">Product name</label>
                                                <input id="productname"  name="productname"  type="text" class="form-control" placeholder="Enter the product name" onkeyup="checkProductName()" required autofocus>
                                                <span id="dumlicate_productname"></span>
                                            </div> 
                                            <div class="col-md-2">
                                                <label for="inputQuantity" class=" col-form-label">Quantity</label>
                                                <input id="inputQuantity" name="quantity" type="number" class="form-control" placeholder="" min="0" max="65536">
                                            </div>
                                            <div class="col-md-3">
                                                <label for="inputPrice" class="col-form-label">Product price</label>
                                                <div class="btn-group">
                                                    <input id="inputPrice" name="price" type="number" step="0.01" class="form-control" title="Please input a number!" placeholder="" min="0" max="65536">
                                                    <span class="input-group-text" id="basic-addon2">$</span>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <label for="inputTitle" class="col-sm-2 col-form-label">Title</label>
                                                <input id="inputTitle" name="title" type="text" class="form-control" placeholder="Example title" required value="">
                                            </div>

                                            <div class="col">
                                            </div>

                                            <div class="col-md-6 p-3">
                                                <label for="inputDescription" class="col-sm-2 col-form-label">Description</label>
                                                <textarea id="inputDescription" name="description" type="text" class="form-control" placeholder="Enter product description" required></textarea>

                                            </div>
                                            <div class="col-md-6">
                                            </div>

                                            <div class="g-0 p-3">
                                                <label class="form-check-label" for="form-check">
                                                    Category 
                                                </label>
                                                <c:forEach items="${requestScope.categorys}" var="category">
                                                    <input type="checkbox" class="btn-check" name="category" value="${category.cid}" id="btnradio${category.cid}">
                                                    <label class="btn btn-outline-primary rounded-pill" for="btnradio${category.cid}">${category.cname}</label>
                                                </c:forEach>
                                            </div>

                                            <div class="col-md-6">
                                                <label for="formFile" class="form-label">Product Image</label>
                                                <input accept="image/*" class="form-control" type="file" id="formFile" name="image">
                                                <img id="img-preview" class="img-thumbnail" max-width=180px src="image/1.png" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-outline-success" type="submit" id="add-product"  form="addFormModal">
                                        Add Product
                                    </button>
                                    <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <form class="col input-group justify-content-end" action="/Chatter/admin/edit_product" method="get" id="searchForm">
                    <div class="form-floating">
                        <select onchange="selectForm();" class="form-select" name="searchtype" id="floatingSelectGrid" >
                            <option selected value="0">Product ID</option>
                            <option value="1">Product name</option>
                            <option value="2">Product price</option>
                            <option value="3">Modify date</option>
                        </select>


                        <label for="floatingSelectGrid">Search by</label>
                    </div>
                    <div class="form-floating"  id="searchByID" >
                        <input  type="number" class="form-control" name="productid" placeholder="ProductID" aria-label="ProductID" min="0" max="65536"  aria-describedby="button-addon2">
                        <label for="">Product ID</label>
                    </div>
                    <div class="form-floating col-sm-3"  id="searchByName" >
                        <input  type="text" class="form-control" name="productname" placeholder="ProductID" aria-label="ProductID" aria-describedby="button-addon2" >
                        <label for="">Product Name</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByMinPrice" >
                        <input  type="number" step="0.01" class="form-control" name="minprice" placeholder="ProductPrice" aria-label="ProductPrice" min="0" max="65536" aria-describedby="button-addon2">
                        <label for="">Min Price</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByMaxPrice" >
                        <input  type="number" step="0.01" class="form-control" name="maxprice" placeholder="ProductPrice" aria-label="ProductPrice" min="0" max="65536" aria-describedby="button-addon2">
                        <label for="">Max Price</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByStartDate" >
                        <input  type="date" value="2018-06-12" class="form-control" name="startdate" placeholder="ProductID" 
                                aria-label="ProductID" min="2018-06-07" max="2218-06-07"   aria-describedby="button-addon2">
                        <label for="">Start Date</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByEndDate" >
                        <input  type="date" value="2018-06-12"  class="form-control" name="enddate" placeholder="ProductID"
                                aria-label="ProductID" min="2018-06-07" max="2218-06-07" aria-describedby="button-addon2">
                        <label for="">End Date</label>
                    </div>
                    <button class="btn btn-outline-primary fa-2x fa-duotone fa-magnifying-glass-plus" type="submit" id="button-addon2">
                    </button>
                </form>
            </div>

            <c:set value="${requestScope.productDetailses}" var="products"/>

            <div class="bg bg-light rounded-3">
                <div class="text-center display-6 text-info">
                    <i class="fa-thin fa-list-tree"></i>
                    List Products</div>
                <table class="table table-hover table-striped table-responsive-md card-body text-center">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Image</th>
                            <th class=" ">Name</th>
                            <!--<th class="col-sm-3 ">Title</th>-->
                            <!--<th class="col-sm-3 ">Description</th>-->
                            <th>Price</th>
                            <th class="">Quantity</th>
                            <th>Category</th>
                            <th class=" text-center">Modify time</th>
                            <th class=" text-center">Action</th>
                        </tr>
                    </thead>
                    <tbody >
                        <c:forEach items="${requestScope.productDetailses}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td><img class="avatar img-thumbnail" src="/Chatter/${product.image}" alt="product ${product.name} image"/></td>
                                <td class="col-sm-2"><a href="/Chatter/productdetail?id=${product.id}" class="text-decoration-none text-danger" >${product.name}</a></td>
                                <!--<td>${product.title}</td>-->
                                <!--<td class="overflow-hidden">${product.description}</td>-->
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td class="col-sm-2">
                                    <c:forEach items="${product.categorys}" var="category">
                                        <span class="badge rounded-pill bg-info">${category.cname}</span>
                                    </c:forEach>
                                </td>
                                <td class="text-center">${product.modifyAt}</td>
                                <td class="text-lg-center">
                                    <button type="submit" class="btn btn-outline-warning btn-box">
                                        <i class="fa-duotone fa-file-lines"></i>
                                        Edit
                                    </button>

                                    <button type="reset" class="btn btn-outline-danger btn-box" onclick="controlEditmode(0);controlViewmode(1);">
                                        <i class="fa-duotone fa-eraser"></i>
                                        Delete
                                    </button>
                                </td>
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
            document.getElementById("searchByMinPrice").style.display = "none";
            document.getElementById("searchByMaxPrice").style.display = "none";
            document.getElementById("searchByStartDate").style.display = "none";
            document.getElementById("searchByEndDate").style.display = "none";

            function selectForm() {
                var type = document.getElementById("floatingSelectGrid").value;

                document.getElementById("searchByID").style.display = type == 0 ? "inline" : "none";
                document.getElementById("searchByName").style.display = type == 1 ? "inline" : "none";
                document.getElementById("searchByMinPrice").style.display = type == 2 ? "inline" : "none";
                document.getElementById("searchByMaxPrice").style.display = type == 2 ? "inline" : "none";
                document.getElementById("searchByStartDate").style.display = type == 3 ? "inline" : "none";
                document.getElementById("searchByEndDate").style.display = type == 3 ? "inline" : "none";
                document.getElementById("searchForm").reset();
                document.getElementById("floatingSelectGrid").value = type;

            }

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
</html>