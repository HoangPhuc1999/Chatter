<%-- 
    Document   : ProductDetail
    Created on : 12-Jun-2022, 5:23:06 PM
    Author     : Hoang Phuc
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
    Product x = (Product) request.getAttribute("product_detail");
    List<Review> list = (List<Review>) request.getAttribute("reviewproductlist");
    double ratting = (Double) request.getAttribute("ratting");
    DecimalFormat df = new DecimalFormat("0.0");
%>  
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
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
        <link href="css/phucstyle.css" rel="stylesheet" />
        <link href="css/star.css" rel="stylesheet" />
        <link href="newcss/style.css" rel="stylesheet">


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
        <div class="container-fluid pb-5">
            <div class="row px-xl-5">
                <div class="col-lg-5 mb-30">
                    <div id="product-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner bg-light">
                            <img class="w-100 h-100" src="<%=x.getImage()%>" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-7 h-auto mb-30">
                    <div class="h-100 bg-light p-30">
                        <h3>  <%=x.getName()%></h3>
                        <div class="d-flex mb-3">
                            <div class="text-primary mb-2">
                                <%                           for (int i = 0; i <= ratting; i++) {
                                %>
                                <i class="fas fa-star"></i>
                                <% }%> 
                            </div>
                            <small class="pt-1">  <%=df.format(ratting)%> stars  </small>
                            <small class="pt-1">(<%=list.size()%> reviews)</small>
                        </div>
                        <h3 class="font-weight-semi-bold mb-4">$ <%=x.getPrice()%></h3>
                        <p class="mb-4"> <%=x.getDescription()%></p>


                        <div class="d-flex align-items-center mb-4 pt-2">
                           
                            <a href="cart?&action=buy&id=<%=x.getId()%>&quantity=1"                               
                               <button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To
                                    Cart</button>
                            </a>
                        </div>

                    </div>
                </div>
            </div>
            <div class="row px-xl-5">
                <div class="col">
                    <div class="bg-light p-30">

                        <div >
                            <div class="row">
                                <div class="col-md-6">
                                    <h4 class="mb-4"><%=list.size()%> review for  <%=x.getName()%></h4>
                                    <%                           for (Review y : list) {
                                    %>
                                    <div class="media mb-4">
                                        <img src=<%=y.getReviewImageUrl()%> alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                                        <div class="media-body">
                                            <h6><%=y.getName()%><small> - <i><%=y.getDate()%></i></small></h6>
                                            <div class="text-primary mb-2">
                                                <%                           for (int i = 0; i < Integer.parseInt(y.getRating()); i++) {
                                                %>
                                                <i class="fas fa-star"></i>

                                                <% }%> 
                                            </div>
                                            <p><%=y.getReviewContent()%></p>
                                        </div>
                                    </div>
                                    <% }%> 
                                </div>
                                <div class="col-md-6">
                                    <h4 class="mb-4">Leave a review ${reviewmessage}    </h4>
                                    <small>Your email address will not be published. Required fields are marked *</small>
                                    <form action="review?id=<%=x.getId()%>" method="post">
                                        <div class="d-flex my-3">
                                            <p class="mb-0 mr-2">Your Rating * :</p>

                                            <div id="rating">
                                                <input type="radio" id="star5" name="rate" value="5" />
                                                <label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                                <input type="radio" id="star4" name="rate" value="4" />
                                                <label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                                <input type="radio" id="star3" name="rate" value="3" />
                                                <label class = "full" for="star3" title="Meh - 3 stars"></label>
                                                <input type="radio" id="star2" name="rate" value="2" />
                                                <label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                                <input type="radio" id="star1" name="rate" value="1" />
                                                <label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                            </div>
                                        </div>
<!--                                        <div class="form-group">
                                            <label>Add image</label> 
                                            <input name="avatar" type="file" class="form-control" placeholder="reviewImage"
                                                   onchange="document.getElementById('avatar').src = window.URL.createObjectURL(this.files[0])"/>
                                            <img id="avatar" class="img-fluid" />
                                        </div>-->
                                        <div class="form-group">
                                            <label for="message">Title </label>
                                            <textarea id="message" cols="30" rows="5" class="form-control" name="reviewtitle"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="message">Your Review </label>
                                            <textarea id="message" cols="30" rows="5" class="form-control" name="reviewtext"></textarea>
                                        </div>

                                        <div class="form-group mb-0">
                                            <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>          

        <!-- end book section -->

        <!-- footer section -->
        <footer class="footer_section">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-col">
                        <div class="footer_contact">
                            <h4>
                                Contact Us
                            </h4>
                            <div class="contact_link_box">
                                <a href="">
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    <span>
                                        Location
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    <span>
                                        Call +01 1234567890
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>
                                        demo@gmail.com
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-col">
                        <div class="footer_detail">
                            <a href="" class="footer-logo">
                                Feane
                            </a>
                            <p>
                                Necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with
                            </p>
                            <div class="footer_social">
                                <a href="">
                                    <i class="fa fa-facebook" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-twitter" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-linkedin" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-instagram" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-pinterest" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-col">
                        <h4>
                            Opening Hours
                        </h4>
                        <p>
                            Everyday
                        </p>
                        <p>
                            10.00 Am -10.00 Pm
                        </p>
                    </div>
                </div>
                <div class="footer-info">
                    <p>
                        &copy; <span id="displayYear"></span> All Rights Reserved By
                        <a href="https://html.design/">Free Html Templates</a><br><br>
                        &copy; <span id="displayYear"></span> Distributed By
                        <a href="https://themewagon.com/" target="_blank">ThemeWagon</a>
                    </p>
                </div>
            </div>
        </footer>
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
        <script src="js/productdetail.js"></script>


    </body>

</html>
