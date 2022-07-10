<%-- 
    Document   : Dashboard
    Created on : Jun 15, 2022, 11:08:57 AM
    Author     : Tuan Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="/Chatter/images/favicon.png" type="">
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
        <!--<link href="/Chatter/css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <!--<link href="/Chatter/css/responsive.css" rel="stylesheet" />-->
        <link href="/Chatter/css/adminstyle.css" rel="stylesheet" />

        <title>Dashboard</title>
    </head>
    <body>
        <div class="col-sm-3 g-2">
            <jsp:include page="Sidebar.jsp" />

        </div>   
        <!-- footer section -->
        <jsp:include page="../../Footer.jsp" />
        <!-- footer section -->
        <script>


            document.getElementById('dashboard_page').classList.add('active');
            document.getElementById('dashboard_page').classList.remove('link-dark');

        </script>
    </body>
</html>
