
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


        <!-- Custom styles for this template -->
        <!--<link href="../css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <!--<link href="../css/responsive.css" rel="stylesheet" />-->
        <link href="../css/adminstyle.css" rel="stylesheet" />


        <title> Chatter </title>
        <script>
            var usernames = [];

            <c:forEach items="${requestScope.accounts}" var="account">
            usernames.push('${account.username}');
            </c:forEach>
        </script>
    </head>
    <body class="row main_content">


        <div class="col-sm-3 g-2">
            <jsp:include page="Sidebar.jsp" />

        </div>   



        <div class="col-sm-9 gy-2">
            <h3 class="text-info p-3" >
                <span class="text-info fa-duotone fa-user-group"></span>
                Add new user </h3>
            <div class="form_container d-flex g-lg-6">
                <form action="users" method="POST" class="row g-3 form-control" >
                    <div class="row">
                        <div class="col-md-6">
                            <label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
                            <input id="username"  name="username"  type="text" class="form-control" placeholder="Enter username" onkeyup="checkUsername()" required autofocus>
                            <span id="dumlicate_username"></span>
                        </div> 
                        <div class="col-md-6">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                            <input id="inputPassword" name="password" type="password" class="form-control" placeholder="Enter password" required>
                        </div>
                        <div class="col-md-6">
                            <label for="inputFirstname" class=" col-form-label">First name</label>
                            <input id="inputFirstname" name="firstname" type="text" class="form-control" placeholder="User's first name">
                        </div>
                        <div class="col-md-6">
                            <label for="inputLastname" class="col-form-label">Last name</label>
                            <input id="inputLastname" name="lastname" type="text" class="form-control" placeholder="User's last name">
                        </div>

                        <div class="col-md-6">
                            <label for="inputPhonenumber" class="col-form-label">Phone number</label>
                            <input id="inputPhonenumber" name="phonenumber" type="tel" required class="form-control" placeholder="0906111111" pattern="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" title="Please input a phone number in Vietnam (10 digits)">
                        </div>

                        <div class="col-md-6">
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                            <input id="inputEmail" name="email" type="email" pattern="^[a-zA-Z0-9.! #$%&'*+=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+$" class="form-control" placeholder="mee@example.com" required >

                        </div>
                        <div class="col-md-6">
                        </div>

                        <div class="btn-group col-md-4 p-3 form-check" role="group" aria-label="" id="role">
                            <label class="form-check-label col-form-label col-lg-2" for="form-check">
                                Role
                            </label>

                            <input type="radio" class="btn-check" name="role" value="user" id="btnradio1" checked>
                            <label class="btn btn-outline-primary" for="btnradio1">User</label>

                            <input type="radio" class="btn-check" name="role" value="seller" id="btnradio2">
                            <label class="btn btn-outline-primary" for="btnradio2">Seller</label>

                            <input type="radio" class="btn-check" name="role" value="admin" id="btnradio3">
                            <label class="btn btn-outline-primary" for="btnradio3">Admin</label>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-box btn-success - col-sm-2" type="submit" id="add-user" name="action" value="add_user">
                            Add User
                        </button>
                    </div>
                </form>
            </div>
        </div>
            <div class=" text-bg-dark g-md-2 row" >
            <div class="col-2">
            </div>
            <div class="col-10">
                <br>
                <jsp:include page="../../Footer.jsp" />
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
                } else if(username===''){
                    document.getElementById('dumlicate_username').style.color = 'red';
                    document.getElementById('dumlicate_username').innerHTML =
                            'Please enter a username!';
                    document.getElementById('add-user').disabled = true;
                    document.getElementById('add-user').style.opacity = (0.4);
                }else
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