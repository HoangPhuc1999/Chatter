<%-- 
    Document   : Cart
    Created on : Jun 6, 2022, 10:37:05 AM
    Author     : khuat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="shortcut icon" href="images/favicon.png" type="">

        <title> Chatter </title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <div class="bg-box">
                <img src="images/hero-bg.jpg" alt="">
            </div>
            <!-- header section strats -->
            <jsp:include page="Header.jsp" />
            <!-- end header section -->
        </div>

        <!-- book section -->
        <section class="book_section layout_padding">
            <h3>Check out </h3>
            <!-- Shopping cart table -->
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col" class="border-0 bg-light">
                                <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                            </th>
                            <th scope="col" class="border-0 bg-light">
                                <div class="py-2 text-uppercase">Đơn Giá</div>
                            </th>
                            <th scope="col" class="border-0 bg-light">
                                <div class="py-2 text-uppercase">Số Lượng</div>
                            </th>
                            <th scope="col" class="border-0 bg-light">
                                <div class="py-2 text-uppercase">Xóa</div>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="0"></c:set>
                        <c:set var="Discounted_Price" value="0"></c:set>
                        <c:forEach items="${sessionScope.user.cart}" var="o">
                            <c:set var="total" value="${total+(o.product.price * o.quantity)}"></c:set>
                            <c:set var="Discounted_Price" value="${Discounted_Price+((o.product.price * o.quantity *(100 - Discount)) /100)}"></c:set>
                                <tr>
                                    <th scope="row">
                                        <div class="p-2">
                                            <a href="productdetail?id=${o.product.id}>
                                            <img src="${o.product.image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"> <a href="productdetail?id=${o.product.id}" class="text-dark d-inline-block">${o.product.name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                        </div>
                                    </div>
                                </th>
                                <td class="align-middle"><strong>${o.product.price}</strong></td>
                                <td class="align-middle">
                                    <a href="cart?&action=discard&id=${o.product.id}"><button class="btnSub">-</button></a>
                                    <strong>${o.quantity}</strong>
                                    <a href="cart?&action=add&id=${o.product.id}"><button class="btnAdd">+</button></a>
                                </td>
                                <td class="align-middle"><a href="cart?action=remove&id=${o.product.id}" class="text-dark">
                                        <button type="button" class="btn btn-danger">Delete</button>
                                    </a>
                                </td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- End -->
        </div>
    </div>

    <div class="row py-5 p-4 bg-white rounded shadow-sm">
        <div class="col-lg-6">
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
            <div class="p-4">
                <div class="input-group mb-4 border rounded-pill p-2">
                    <form id="couponCheck" action="coupon" method="POST">
                        <input type="text" name="couponCode" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                    </form>
                    <div class="input-group-append border-0">
                        <button id="button-addon3" type="submit" form="couponCheck" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                    </div>
                    <p class="text-danger">${message}</p>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
            <div class="p-4">
                <ul class="list-unstyled mb-4">
                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${total}$</strong></li>
                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>0$</strong></li>
                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Discount</strong><strong>${Discount}%</strong></li>
                    <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                        <h5 class="font-weight-bold">${Discounted_Price}$</h5>
                    </li>
                </ul><a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
            </div>
        </div>
    </div>
</section>
<!-- end book section -->

<!-- footer section -->
<jsp:include page="Footer.jsp" />
<!-- footer section -->

<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- popper js -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
</script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- owl slider -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
</script>
<!-- isotope js -->
<script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
<!-- nice select -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>


</body>

</html>
