
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>
        <style>
            .tab-pane{
                background: rgba(255,255,255,0.6);
                margin-bottom: 2%;

            }
            .form-control{
                background: rgba(255,255,255,0);

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
        <link href="../css/responsive.css" rel="stylesheet" />
        <link href="../css/adminstyle.css" rel="stylesheet" />
        <title> Chatter </title>
        <script>
            function controlEditmode(type)
            {
                var editcomponent = document.getElementById('editmode');
                editcomponent.style.display = (type === 0) ? "none" : "inline";
            }

            function controlViewmode(type)
            {
                var viewcomponent = document.getElementById('viewmode');
                viewcomponent.style.display = (type == 0) ? "none" : "inline";
            }

            function cancelEdit(cid, cname)
            {
                hideEditmode(cid);
                showViewmode(cid);
                document.getElementById("edit_name" + cid).value = cname;
            }

        </script>
    </head>
    <body class="row main_content">


        <div class="col-sm-3 g-3">
            <jsp:include page="Sidebar.jsp" />
        </div>

        <div class="col-sm-9 gy-2">

            ${user}

            <c:set var = "user" scope = "session" value = "${requestScope.user}"/>
            <c:if test="${user == null}">
                <p >
                    <em><mark><strong class="lead text-secondary ">User not found! You can add new user by click on this button:</strong></mark></em>
                </p>
                <a href="add_user" class="btn btn-box btn-outline-info">Add new user</a>
            </c:if>

            <c:if test="${user != null}">
                <div class="blockquote">
                    <div class="display-6">
                        <img src="/Chatter/${user.avatar}" class="avatar" alt="avatar">  ${user.account.username}
                        <em class="display-6 blockquote-footer">(User ID: ${user.users_id})</em></div></div>

                <ul class="nav nav-tabs" id="myTab" role="tablist">

                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">User Details</button>
                    </li>

                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="order-tab" data-bs-toggle="tab" data-bs-target="#order"
                                type="button" role="tab" aria-controls="order" aria-selected="false">Orders history</button>
                    </li>

                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Contact</button>
                    </li>

                </ul>
                <div class="tab-content" id="myTabContent">

                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div id="viewmode">
                            <div class="container-content border border-light rounded row" id="UserDetails">
                                <div class="col-5 row g-2">
                                    <div class="col-10">
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

                                <div class="col-5 row g-2">
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

                                <div class="col text-end p-3">
                                    <button class="btn btn-outline-info btn-box fa fa-pencil-square-o" 
                                            onclick="controlEditmode(1);controlViewmode(0);"> Edit</button>

                                </div>
                            </div>

                        </div>

                        <!--Edit mode-->
                        <div id="editmode">
                            <form class=" form-control" action="edit_user" method="POST"  enctype="multipart/form-data">
                                <div class="container-content border border-light rounded row" id="UserDetails">
                                    <div class="col-6 row g-2">
                                        <div class="col-11">
                                            <div class="card border-info ">
                                                <div class=" card-header">
                                                    <i class="fa-duotone fa-ballot"></i>
                                                    General Info</div>

                                                <div class="card-body row row-cols-7 row-cols-lg-2 g-2 g-lg-3">
                                                    <div class="col">
                                                        <i class="fa-duotone fa-square-1"></i>
                                                        First name
                                                    </div>
                                                    <div class="col">
                                                        <input type="text" class="form-control" autofocus pattern="[A-Z][a-z]+$" value="${user.firstname}" name="firstname"/>
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-circle-0"></i>
                                                        Last name
                                                    </div>
                                                    <div class="col">
                                                        <input type="text" class="form-control" pattern="[A-Z][a-z]+$"  value="${user.lastname}" name="lastname"/>
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-venus-mars"></i>
                                                        Gender<br>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-check form-check-inline">
                                                            <input class="form-check-input" type="radio" name="gender" id="genderMale"
                                                                   ${user.gender eq 'male'?'checked':''} value="male">
                                                            <label class="form-check-label" for="genderMale">Male</label>
                                                        </div>
                                                        <div class="form-check form-check-inline">
                                                            <input class="form-check-input" ${user.gender eq 'female'?'checked':''} type="radio" name="gender" id="genderFemale" value="female">
                                                            <label class="form-check-label" for="genderFemale">Female</label>
                                                        </div>
                                                    </div>
                                                    <div class="row g-0 justify-content-between">
                                                        <div class="col-6 col-md-8 g-3">
                                                            <i class="fa-solid fa-person-military-pointing"></i>
                                                            Role
                                                        </div>
                                                        <div class="col-6 col-md-1 p-1 ">
                                                            <div class="btn-group col-md-0 form-check" role="group" aria-label="" id="role">

                                                                <input type="radio" class="btn-check" ${user.role eq 'user'?'checked':''} name="role" value="user" id="btnradio1">
                                                                <label class="btn btn-outline-primary" for="btnradio1">User</label>

                                                                <input type="radio" class="btn-check" ${user.role eq 'seller'?'checked':''} name="role" value="seller" id="btnradio2">
                                                                <label class="btn btn-outline-primary" for="btnradio2">Seller</label>

                                                                <input type="radio" class="btn-check" ${user.role eq 'admin'?'checked':''} name="role" value="admin" id="btnradio3">
                                                                <label class="btn btn-outline-primary" for="btnradio3">Admin</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col"></div>

                                                    <div class="col">
                                                        <i class="fa-solid fa-mobile-retro"></i>
                                                        Phone number
                                                    </div>
                                                    <div class="col">
                                                        <input id="inputPhonenumber" name="phonenumber" type="tel" value="${requestScope.user.phonenumber}"  required class="form-control"
                                                               placeholder="0906111111" pattern="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" title="Please input a phone number in Vietnam (10 digits)" value=${phone} >
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-envelopes"></i>                                   
                                                        Email
                                                    </div>
                                                    <div class="col">
                                                        <input id="inputEmail" name="email" type="email" value="${user.email}" class="form-control" placeholder="mee@example.com" required value=${email}>
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-camera-retro"></i>
                                                        Avatar
                                                    </div>
                                                    <div class="col">
                                                        <input accept="image/*" class="form-control" type="file" id="formFile" name="image">
                                                        <p class=" text-dark"><em>Preview avatar</em><img id="img-preview" alt="preview avatar" class="avatar rounded-circle me-2 justify-content-lg-end" src="/Chatter/${user.avatar}"/>
                                                        </p>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <!--Address-->

                                    <div class="col-6 row g-2">
                                        <div class="col-12">
                                            <div class="card border-info ">
                                                <div class=" card-header">
                                                    <i class="fa-duotone fa-address-book"></i>
                                                    Address</div>

                                                <div class="card-body row row-cols-6 row-cols-lg-2 g-2 g-lg-3">
                                                    <div class="col">
                                                        <i class="fa-duotone fa-house-tree"></i>
                                                        Home address
                                                    </div>
                                                    <div class="col">
                                                        <input type="text" class="form-control"  value="${user.home_address}" name="homeAddress"/>
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-house-building"></i>
                                                        District
                                                    </div>
                                                    <div class="col">
                                                        <input type="text" class="form-control"  value="${user.district}" name="district"/>
                                                    </div>

                                                    <div class="col">
                                                        <i class="fa-duotone fa-city"></i>
                                                        City
                                                    </div>
                                                    <div class="col">
                                                        <input type="text" class="form-control"  value="${user.city}" name="city"/>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <input type="hidden" name="userid" value="${user.users_id}"/>
                                <input type="hidden" name="username" value="${user.account.username}"/>
                                <div class="col text-center p-3">
                                    <button type="submit" class="btn btn-outline-warning btn-box me-md-4">
                                        <i class="fa-duotone fa-file-lines"></i>
                                        Save
                                    </button>

                                    <button type="reset" class="btn btn-outline-danger btn-box" onclick="controlEditmode(0);controlViewmode(1);">
                                        <i class="fa-duotone fa-eraser"></i>
                                        Cancel
                                    </button>
                                </div>

                            </form>

                        </div>
                    </div>

                    <div class="tab-pane fade" id="order" role="tabpanel" aria-labelledby="order-tab">
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    </div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                        ...
                    </div>
                </div>
            </c:if>
        </div>

        <div class=" btn-dark g-md-4 row" >
            <div class="col-2">
            </div>
            <div class="col-10">
                <br>
                <jsp:include page="../../Footer.jsp" />
            </div>
        </div>

        <script>

            controlEditmode(0);

            document.getElementById('users_page').classList.add('active');
            document.getElementById('users_page').classList.remove('link-dark');


            const input = document.getElementById('formFile');
            const image = document.getElementById('img-preview');

            input.addEventListener('change', (e) => {
                if (e.target.files.length) {
                    const src = URL.createObjectURL(e.target.files[0]);
                    image.src = src;
                }
            });
        </script>  

    </body>
</html>

