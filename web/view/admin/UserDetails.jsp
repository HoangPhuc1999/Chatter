
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>
        <style>
            .container-content{
                background: rgba(255,255,255,0.4);
                
            }
            .avatar {
                border-radius: 50%;
                width: 50px;
            }
            img:hover {
                box-shadow: 0 0 4px 2px rgba(0, 140, 186, 0.5);
            }
        </style>

        <!-- Custom styles for this template -->
        <!--<link href="../css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <!--<link href="../css/responsive.css" rel="stylesheet" />-->
        <link href="../css/adminstyle.css" rel="stylesheet" />
        <title> Chatter </title>
        <script>
            function showEditmode(cid)
            {
                var editcomponents = document.getElementById('');
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "inline";
                }
            }
            function showViewmode(cid)
            {
                var editcomponents = document.getElementsByClassName("viewmode" + cid);
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "inline";
                }
            }
        </script>
    </head>
    <body class="row main_content">


        <div class="col-sm-3 g-3">
            <jsp:include page="Sidebar.jsp" />

        </div>


        <div class="col-sm-9 gy-2">

            <c:set var = "user" scope = "session" value = "${requestScope.user}"/>
            ${user}
            <div class="blockquote">
                <div class="display-6">
                    <img src="../avatar/female.jpg" class="avatar" alt="avatar">  ${user.account.username}
                    <em class="display-6 blockquote-footer">(User ID: ${user.users_id})</em></div></div>

            <ul class="nav nav-tabs" id="myTab" role="tablist">

                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">User Details</button>
                </li>

                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Orders history</button>
                </li>

                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Contact</button>
                </li>

            </ul>
            <div class="tab-content" id="myTabContent">

                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    
                    <div class="container-content border border-light rounded row" id="UserDetails">
                        <div class="col-6 row g-2">
                            <div class="col-8">
                                <div class="card border-info ">
                                    <div class=" card-header">
                                        <i class="fa-duotone fa-ballot"></i>
                                        General Info</div>

                                    <div class="card-body row row-cols-6 row-cols-lg-2 g-2 g-lg-3">
                                        <div class="col">
                                            <i class="fa-duotone fa-square-1"></i>
                                            First name<br>
                                        </div>
                                        <div class="col">
                                            ${user.firstname}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-duotone fa-circle-0"></i>
                                            Last name<br>
                                        </div>
                                        <div class="col">
                                            ${user.lastname}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-duotone fa-venus-mars"></i>
                                            Gender<br>
                                        </div>
                                        <div class="col">
                                            ${user.gender}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-solid fa-person-military-pointing"></i>
                                            Role<br>
                                        </div>
                                        <div class="col">
                                            ${user.role}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-solid fa-mobile-retro"></i>
                                            Phone number<br>
                                        </div>
                                        <div class="col">
                                            ${user.phonenumber}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-duotone fa-envelopes"></i>                                   
                                            Email<br>
                                        </div>
                                        <div class="col">
                                            ${user.email}<br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--Address-->

                        <div class="col-6 row g-2">
                            <div class="col-9">
                                <div class="card border-info ">
                                    <div class=" card-header">
                                        <i class="fa-duotone fa-address-book"></i>
                                        Address</div>

                                    <div class="card-body row row-cols-5 row-cols-lg-2 g-2 g-lg-3">
                                        <div class="col">
                                            <i class="fa-duotone fa-house-tree"></i>
                                            Home address<br>
                                        </div>
                                        <div class="col">
                                            ${user.home_address}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-duotone fa-house-building"></i>
                                            District<br>
                                        </div>
                                        <div class="col">
                                            ${user.district}<br>
                                        </div>

                                        <div class="col">
                                            <i class="fa-duotone fa-city"></i>
                                            City<br>
                                        </div>
                                        <div class="col">
                                            ${user.city}<br>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>                

                    </div>
                </div>

            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                
            </div>
            <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">...</div>
        </div>




    </div>

    <script>
        document.getElementById('users_page').classList.add('active');
        document.getElementById('users_page').className.replace('link-dark', '');


        function checkUsername() {
            let username = document.getElementById('username').value;
            const isDumlicate = usernames.some(element => {
                return element === username;
            });

            if (isDumlicate) {
                document.getElementById('dumlicate_username').style.color = 'red';
                document.getElementById('dumlicate_username').innerHTML =
                        'Username already exist!';
                document.getElementById('add-user').disabled = true;
                document.getElementById('add-user').style.opacity = (0.4);
            } else if (username === '') {
                document.getElementById('dumlicate_username').style.color = 'red';
                document.getElementById('dumlicate_username').innerHTML =
                        'Please enter a username!';
                document.getElementById('add-user').disabled = true;
                document.getElementById('add-user').style.opacity = (0.4);
            } else
            {
                document.getElementById('dumlicate_username').style.color = 'green';
                document.getElementById('dumlicate_username').innerHTML =
                        'Valid Username ';
                document.getElementById('add-user').disabled = false;
                document.getElementById('add-user').style.opacity = (1);
            }
        }
    </script>  

</body>
</html>

