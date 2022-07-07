<%-- 
    Document   : About
    Created on : May 26, 2022, 1:09:40 AM
    Author     : 84384
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

        <title> Feane </title>

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
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="aboutcss/animate.css">

        <link rel="stylesheet" href="aboutcss/owl.carousel.min.css">
        <link rel="stylesheet" href="aboutcss/owl.theme.default.min.css">
        <link rel="stylesheet" href="aboutcss/magnific-popup.css">

        <link rel="stylesheet" href="aboutcss/bootstrap-datepicker.css">
        <link rel="stylesheet" href="aboutcss/jquery.timepicker.css">
        <link rel="stylesheet" href="aboutcss/flaticon.css">
        <link rel="stylesheet" href="aboutcss/style.css">

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

        <!-- about section --> 


        <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_5.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-end justify-content-center">
                    <div class="col-md-9 ftco-animate text-center mb-5">
                        <h1 class="mb-2 bread">About</h1>
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="fa fa-chevron-right"></i></a></span> <span>About <i class="fa fa-chevron-right"></i></span></p>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-section ftco-no-pt ftco-no-pb">
            <div class="container">
                <div class="row d-flex">
                    <div class="col-md-6 d-flex">
                        <div class="img img-2 w-100 mr-md-2" style="background-image: url(images/beefburger.jpg);"></div>
                        <div class="img img-2 w-100 ml-md-2" style="background-image: url(images/grillburger.jpg);"></div>
                    </div>
                    <div class="col-md-6 ftco-animate makereservation p-4 p-md-5">
                        <div class="heading-section ftco-animate mb-5">
                            <h2 >Perfect Ingredients</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.
                            </p>
                            <p><a href="#" class="btn btn-primary">Learn more</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(images/bg_4.jpg);" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row d-md-flex align-items-center justify-content-center">
                    <div class="col-lg-10">
                        <div class="row d-md-flex align-items-center">
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="100">0</strong>
                                        <span>Tasty Dishes</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="4000">0</strong>
                                        <span>Dishes Served</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="10">0</strong>
                                        <span>Restaurants</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18">
                                    <div class="text">
                                        <strong class="number" data-number="10000">0</strong>
                                        <span>Happy Customers</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="ftco-section ftco-no-pt ftco-no-pb ftco-intro bg-primary">
            <div class="container py-5">
                <div class="row py-2">
                    <div class="col-md-12 text-center">
                        <h2>We Make Delicious &amp; Nutritious Food</h2>
                        <a href="#" class="btn btn-white btn-outline-white">Book A Table Now</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- end about section -->

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


        <script src="aboutjs/jquery.min.js"></script>
        <script src="aboutjs/jquery-migrate-3.0.1.min.js"></script>
        <script src="aboutjs/popper.min.js"></script>
        <script src="aboutjs/bootstrap.min.js"></script>
        <script src="aboutjs/jquery.easing.1.3.js"></script>
        <script src="aboutjs/jquery.waypoints.min.js"></script>
        <script src="aboutjs/jquery.stellar.min.js"></script>
        <script src="aboutjs/owl.carousel.min.js"></script>
        <script src="aboutjs/jquery.magnific-popup.min.js"></script>
        <script src="aboutjs/jquery.animateNumber.min.js"></script>
        <script src="aboutjs/bootstrap-datepicker.js"></script>
        <script src="aboutjs/jquery.timepicker.min.js"></script>
        <script src="aboutjs/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="aboutjs/google-map.js"></script>
        <script src="aboutjs/main.js"></script>

    </body>

</html>
