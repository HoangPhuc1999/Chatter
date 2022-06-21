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
<link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



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



        <div class="col-sm-9">
            <h3 class="text-warning p-2 fa-thin fa-user">  Add new user</h3>
<div class="form_container d-flex p-5">
                <form action="" method="POST" class="row g-3 form-control" >
                    <div class="row">
                        <div class="col-md-6">
                            <label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
                            <input name="username"  type="text" class="form-control" placeholder="Enter username" required value=${user} >
                        </div>
                        <div class="col-md-6">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                            <input id="inputPassword" name="password" type="password" class="form-control" placeholder="Enter password" required value=${pass}>
                        </div>
                        <div class="col-md-6">
                            <label for="inputFirstname" class=" col-form-label">First name</label>
                            <input id="inputFirstname" name="firstname" type="text" class="form-control" placeholder="User's first name" value=${first}>
                        </div>
                        <div class="col-md-6">
                            <label for="inputLastname" class="col-form-label">Last name</label>
                            <input id="inputLastname" name="lastname" type="text" class="form-control" placeholder="User's last name" value=${last}>
                        </div>

                        <div class="col-md-6">
                            <label for="inputPhonenumber" class="col-form-label">Phone number</label>
                            <input id="inputPhonenumber" name="phonenumber"type="text" class="form-control" placeholder="012435464" value=${phone}>
                        </div>
                        
                        <div class="col-md-6">
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                             <input id="inputEmail" name="email" type="email" class="form-control" placeholder="mee@example.com" required value=${email}>

                        </div>
                             <div class="col-md-6">
                        </div>
                        <div class="col-md-6">
                            <label for="inputDistrict" class="col-sm-2 col-form-label">District</label>
                            <input id="inputDistrict" name="district"type="text" class="form-control" placeholder="" value=${district}>
                        </div>
                        <div class="col-md-6">
                        </div>
                        
                        <div class="col-md-6">
                            <label for="inputCity" class="col-sm-2 col-form-label">City</label>
                            <input id="inputCity" name="city" type="text" class="form-control" placeholder="" value=${city}>
                        </div>
                    </div>

                    <button class="btn btn-box btn-success - col-sm-2">
                        Add User
                    </button>
                </form>
            </div>
        </div>
        <script>
            (function () {
                'use strict'
                const forms = document.querySelectorAll('.requires-validation')
                Array.from(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }

                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>


</html>