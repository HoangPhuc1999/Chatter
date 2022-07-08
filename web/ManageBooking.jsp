<%-- 
    Document   : ManageBooking
    Created on : 6-Jul-2022, 10:30:34 AM
    Author     : Hoang Phuc
--%>

<%@page import="model.User"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%
    List<Book> list = (List<Book>) request.getAttribute("bookinglist");

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

                    <div class="pb-5">
                        <div class="container">
                            <form action="../admin/booking" method="post" id="search-box" class="form-row">
                                <input type="search" name="phonenumber" id="search-text"
                                       placeholder="Tra thông tin đặt bàn theo số điện thoại hoặc tên người đặt"
                                       required>
                                <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit" id="search-btn">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </form>
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Book Id</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Name</div>
                                                    </th>

                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Email</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Phone Number</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Person</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Date</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Hoàn Thành</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <%                         if (list.isEmpty()) {

                                            %>
                                            <tbody>
                                            <div class="heading_container">
                                                <div class ="text">
                                                    No customer found
                                                </div>
                                            </div>
                                            </tbody>

                                            <%                                              } else {

                                            %>

                                            <tbody>
                                                <%                           for (Book y : list) {

                                                %>
                                                <tr>
                                                    <td class="align-middle"><strong><%=y.getBookId()%></strong></td>
                                                    <td class="align-middle"><strong><%=y.getName()%></strong></td>
                                                    <td class="align-middle"><strong><%=y.getEmail()%></strong></td>
                                                    <td class="align-middle"><strong><%=y.getPhoneNumber()%></strong></td>
                                                    <td class="align-middle"><strong><%=y.getUsersId()%></strong></td>
                                                    <td class="align-middle"><strong><%=y.getDob()%></strong></td>
                                                    <td class="align-middle">
                                                        <button type="button" class="btn btn-danger">Hoàn thành</button>
                                                        </a>
                                                    </td>




                                                </tr> 
                                                <% }%> 
                                            </tbody>
                                            <% }%> 
                                        </table>
                                    </div>
                                    <!-- End -->
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
