
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
        <link href="../css/adminstyle.css" rel="stylesheet" />


        <title> Chatter </title>
        <script>
            var productnames = [];

            <c:forEach items="${requestScope.products}" var="product">
            productnames.push('${product.name}');
            </c:forEach>
        </script>
    </head>
    <body class="row main_content">


        <div class="col-sm-3 g-2">
            <jsp:include page="Sidebar.jsp" />

        </div>   
        <div class="col-sm-9 gy-2">
            <h3 class="text-info p-3" >
                <span class="text-info fa-duotone fa-user-group"></span>
                Add new product </h3>
            <div class="form_container d-flex g-lg-6">
                <form enctype="multipart/form-data"  action="add_product" method="POST" class="row g-3 form-control" >
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
                        <div class="col-md-4">
                            <label for="inputPrice" class="col-form-label">Product price</label>
                            <div class="btn-group">
                                <input id="inputPrice" name="price" type="text" class="form-control" pattern="[0-9]+(.?[0-9]+)?" title="Please input a number!" placeholder="" value=${last}>
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
                            <input accept="image/*" class="form-control" type="file" id="formFile">
                            <img id="img-preview" class="img-thumbnail" max-width=180px src="image/1.png" />
                        </div>

                    </div>
                    <div class="text-center">
                        <button class="btn btn-box btn-success - col-sm-2" type="submit" id="add-product">
                            Add Product
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script>
            document.getElementById('products_page').classList.add('active');
            document.getElementById('products_page').className.replace('link-dark', '');


            function checkProductName() {
                let productname = document.getElementById('productname').value;
                const isDumlicate = productnames.some(element => {
                    return element === productname;
                });

                if (isDumlicate) {
                    document.getElementById('dumlicate_productname').style.color = 'red';
                    document.getElementById('dumlicate_productname').innerHTML =
                            'Product already exist!';
                    document.getElementById('add-product').disabled = true;
                    document.getElementById('add-product').style.opacity = (0.4);
                } else if (productname.trim() === '') {
                    document.getElementById('dumlicate_productname').style.color = 'red';
                    document.getElementById('dumlicate_productname').innerHTML =
                            'Please enter the product\'s name!';
                    document.getElementById('add-product').disabled = true;
                    document.getElementById('add-product').style.opacity = (0.4);
                } else
                {
                    document.getElementById('dumlicate_productname').style.color = 'green';
                    document.getElementById('dumlicate_productname').innerHTML =
                            '';
                    document.getElementById('add-product').disabled = false;
                    document.getElementById('add-product').style.opacity = (1);
                }
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