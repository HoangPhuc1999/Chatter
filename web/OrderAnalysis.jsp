<%-- 
    Document   : OrderAnalysis
    Created on : 16-Jul-2022, 10:24:06 PM
    Author     : Hoang Phuc
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.SaleInfo"%>
<%@page import="model.OrderAnalysis"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<OrderAnalysis> list = (List<OrderAnalysis>) request.getAttribute("top5");
    List<SaleInfo> totalSaleList = (List<SaleInfo>) request.getAttribute("listoftotalsale");
    SaleInfo saleInfo = (SaleInfo) request.getAttribute("todaysale");
    SaleInfo totalSale = (SaleInfo) request.getAttribute("totalsale");
    double todayRevenue = saleInfo.getTotalRevenue() * 30 / 100;
    double totalRevenue = totalSale.getTotalRevenue() * 30 / 100;
    NumberFormat formatter = new DecimalFormat("#0.00");
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
                                            <h6 class="mb-0">$<%=formatter.format(saleInfo.getTotalRevenue())%></h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-bar fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Sale</p>
                                            <h6 class="mb-0">$<%=formatter.format(totalSale.getTotalRevenue())%></h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-area fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Today Revenue</p>
                                            <h6 class="mb-0">$<%=formatter.format(todayRevenue)%></h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xl-3">
                                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-chart-pie fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Revenue</p>
                                            <h6 class="mb-0">$<%=formatter.format(totalRevenue)%></h6>
                                        </div>
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
                                                header: ["Day", "Total Sale"],
                                                rows: [
                                        <%
                                            for (SaleInfo o : totalSaleList) {%>
                                                    ["<%=o.getOrderDate()%>",<%=o.getTotalRevenue()%>],
                                        <%
                                            }
                                        %>
                                                ]};
                                            // create the chart
                                            var chart = anychart.line();
                                            // add the data
                                            chart.data(data);
                                            // set the chart title
                                            chart.title("Sale of recent 5 days");

                                            // draw
                                            chart.container("container1");
                                            chart.draw();
                                        });
                                    </script>
                                </div>
                                <div class="col-md-6 ftco-animate makereservation p-4 p-md-5">
                                    <div class="heading-section ftco-animate mb-5">
                                        <h2 >Sale of recent 5 days</h2>
                                        <p>From order details database, calculate total sale of each day, then get the most recent 5 day to draw this chart.
                                        </p>
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
                                        <h2 >Top 5 most famous food item rank by sale</h2>
                                        <p> From order detail database, find top 5 most famous food item rank by sales.
                                        </p>

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