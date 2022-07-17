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

