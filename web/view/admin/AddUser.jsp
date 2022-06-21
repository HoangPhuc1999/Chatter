<%-- 
Document   : signup
Created on : May 25, 2022, 9:04:43 PM
Author     : khuat
--%>
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
        <link rel="shortcut icon" href="images/favicon.png" type="">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>


        <!-- Custom styles for this template -->
        <link href="../css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="../css/responsive.css" rel="stylesheet" />
        <link href="../css/adminstyle.css" rel="stylesheet" />

        <title> Chatter </title>
    </head>
    <body class="row main_content">


        <div class="col-sm-3">
            <jsp:include page="Sidebar.jsp" />

        </div>   


        
            <div class="col-sm-9 card">
                <
                <form action="signup" method="POST" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col">

                            <div>
                                Username:        
                                <input name="username" type="text" class="form-control" placeholder="Username" value=${user}>
                            </div>
                            <div>
                                Password:        
                                <input name="password" type="text" class="form-control" placeholder="Password" value=${pass}>
                            </div>
                            <div>
                                Firstname:        
                                <input name="firstname" type="text" class="form-control" placeholder="First name" value=${first}>
                            </div>
                            <div>
                                Lastname:       
                                <input name="lastname" type="text" class="form-control" placeholder="Last name" value=${last}>
                            </div>
                        </div>
                        <div class="col">

                            <div>
                                Phone number:       
                                <input name="phonenumber"type="text" class="form-control" placeholder="Phone Number" value=${phone}>
                            </div>
                            <div>
                                Email:       
                                <input name="email" type="email" class="form-control" placeholder="Your Email" value=${email}>
                            </div>
                            <div>
                                District:       
                                <input name="district"type="text" class="form-control" placeholder="district" value=${district}>
                            </div>
                            <div>
                                City:       
                                <input name="city"type="text" class="form-control" placeholder="city" value=${city}>
                            </div>
                        </div>
                    </div>

                    <button class="btn btn-box btn-outline-success">
                        Add User
                    </button>
                </form>
            </div>
    </body>

</html>