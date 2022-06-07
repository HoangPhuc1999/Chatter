<%-- 
    Document   : login
    Created on : 10-Mar-2022, 4:56:43 PM
    Author     : Hoang Phuc
--%>

<%@page import="model.User"%>
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
        <link href="css/phucstyle.css" rel="stylesheet" />

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
            <div class="container">
                <div class="heading_container">
                    <div class ="text">
                        Sign in                    
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">


                        <div class="form_container">

                            <form action="login" method="post">
                                <div class ="textusername">
                                    Username                 
                                </div>

                                <!--                                <div class ="textbox">
                                                                    <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 1024 1024">
                                                                    <path d="M1023.46 232a31.629 31.629 0 0 0-2.48-18.271C1012.917 178.288 987.3 160 944.005 160h-832c-38.08 0-79.105 14-99.28 41.472-1.745 1.328-3.409 2.832-4.912 4.576-6.449 7.44-8.705 17.009-7.264 26.033-.288 2.592-.544 5.2-.544 7.92v512c0 53.024 58.992 112 112 112h832c53.024 0 80-58.976 80-112v-512c0-2.832-.368-5.313-.544-8.001zm-911.459-8l832.001-.001h.432L512.002 568.655 81.314 225.407C91.106 223.599 103.154 224 112 224zm832.001 575.999H112.003c-17.648 0-48-30.336-48-48V293.551l427.04 341.648c6.016 5.2 13.487 7.792 20.959 7.792a32.046 32.046 0 0 0 20.976-7.792l427.024-341.632v458.432c0 17.664 1.664 48-16 48z"/>
                                                                    </svg>
                                                                </div>-->

                                <div>
                                    <input type="text" name="name" class="form-control" placeholder="Enter your username" />
                                </div>
                                <br>                      
                                <div class ="textusername">
                                    Password                 
                                </div>
                                <div>
                                    <input type="password" name="pass" class="form-control" placeholder="Enter your password" />
                                </div>

                                <div>
                                    <span>Forgot your password?</span>
                                    <a href="ResetPassword.jsp" class="text-decoration-none">Reset my password!</a>
                                </div>
                                <div class="btn_box"  type="submit">
                                    <button>
                                        Login
                                    </button>
                                </div>
                            </form>

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="img-box">
                            <img src="images/about-img.png" width="400" 
                                 height="500">
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
        <!-- Google Map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
        </script>
        <!-- End Google Map -->

    </body>

</html>
