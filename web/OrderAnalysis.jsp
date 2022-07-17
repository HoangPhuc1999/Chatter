<%-- 
    Document   : OrderAnalysis
    Created on : 16-Jul-2022, 10:24:06 PM
    Author     : Hoang Phuc
--%>

<%@page import="model.OrderAnalysis"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<OrderAnalysis> list = (List<OrderAnalysis>) request.getAttribute("top5");

    // If you use EL or JSTL, the above statement is not necessary. 
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
        <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-base.min.js"></script>

        <title> Chatter </title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="../css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="../css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="../css/responsive.css" rel="stylesheet" />


        <link href="../dashboardcss/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="../dashboardcss/style.css" rel="stylesheet">
        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <div class="bg-box">
                <img src="../images/hero-bg.jpg" alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="../home">
                            <span>
                                Chatter
                            </span>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="../home">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../menu">Menu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../About.jsp">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../Book.jsp">Book Table</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../Chatting.jsp">Chatting</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="../getreview">Review</a>
                                </li>
                            </ul>
                            <div class="user_option">
                                <a href="profile" class="user_link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </a>
                                <a class="cart_link" href="cart">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                    <g>
                                    <g>
                                    <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                          C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                          c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                    </g>
                                    </g>

                                    </svg>
                                </a>
                                <form action="search" method="post" id="search-box" class="form-row">
                                    <input type="search" name="txt" id="search-text"
                                           placeholder="Bạn muốn ăn gì?"
                                           required>
                                    <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit" id="search-btn">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </form>
                                <%User x = (User) request.getSession().getAttribute("user");%>
                                <% if (x != null) {
                                %>
                                <nav class="navbar navbar-dark bg-dark navbar-expand-sm">

                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbar-list-4">
                                        <ul class="navbar-nav">
                                            <li class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <img src="<%=x.getAvatar()%>" width="40" height="40" class="rounded-circle">
                                                </a>
                                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                                    <a class="dropdown-item" href="../profile">Profile</a>
                                                    <a class="dropdown-item" href="../logout">Log Out</a>
                                                </div>
                                            </li>   
                                        </ul>
                                    </div>
                                </nav>
                                <%                } else if (x == null) {
                                %>
                                <a href="../login" class="order_online">
                                    Sign in
                                </a>
                                <a href="../SignUp.jsp" class="order_online">
                                    Sign up
                                </a>
                                <%
                                    }
                                %>

                            </div>
                        </div>
                    </nav>
                </div>
            </header>
            <!-- end header section -->
        </div>

        <!-- book section -->

        <section class="book_section layout_padding">

            <div class="shopping-cart">
                <div class="px-4 px-lg-0">
                    <div class="container">
                        <div class="container-fluid pt-4 px-4">
                            <div class="row g-4">
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-line fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Today Sale</p>
                                            <h6 class="mb-0">$1234</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-bar fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Sale</p>
                                            <h6 class="mb-0">$1234</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-area fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Today Revenue</p>
                                            <h6 class="mb-0">$1234</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-pie fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Revenue</p>
                                            <h6 class="mb-0">$1234</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container-fluid pt-4 px-4">
                            <div class="row g-4">
                                <div class="col-sm-12 col-xl-6">
                                    <div id="container" style="width: 100%; height: 100%"></div>
                                    <script>
                                        anychart.onDocumentReady(function () {

                                            // set the data
                                            var data = {
                                                header: ["Product Name", "Revenue"],
                                                rows: [
                                        <%
                                            for (OrderAnalysis orderItem : list) {%>
                                                    ["<%=orderItem.getProductName()%>",<%=orderItem.getRevenue()%>],
                                        <%
                                            }
                                        %>

                                                ]};

                                            // create the chart
                                            var chart = anychart.bar();

                                            // add the data
                                            chart.data(data);

                                            // set the chart title
                                            chart.title("Top 5 most famous item on the menu by revenue");

                                            // draw
                                            chart.container("container");
                                            chart.draw();
                                        });
                                    </script>
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
                
                        <div class="container-fluid pt-4 px-4">
                            <div class="row g-4">
                                <div class="col-sm-12 col-xl-6">
                                    <div id="container1" style="width: 100%; height: 100%"></div>
                                    <script>
                                        anychart.onDocumentReady(function () {

                                            // set the data
                                            var data = {
                                                header: ["Product Name", "Revenue"],
                                                rows: [
                                        <%
                                            for (OrderAnalysis orderItem : list) {%>
                                                    ["<%=orderItem.getProductName()%>",<%=orderItem.getRevenue()%>],
                                        <%
                                            }
                                        %>

                                                ]};

                                            // create the chart
                                            var chart = anychart.column();

                                            // add the data
                                            chart.data(data);

                                            // set the chart title
                                            chart.title("Top 5  famous item on the menu by revenue");

                                            // draw
                                            chart.container("container1");
                                            chart.draw();
                                        });
                                    </script>
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